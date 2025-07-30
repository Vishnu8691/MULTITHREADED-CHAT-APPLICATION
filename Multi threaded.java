# SERVER IMPLEMENTATION 
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        while (true) {
            try {
                message = input.readUTF();
                broadcastMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            try {
                client.output.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



#CLIENT IMPLEMENTATION 

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            new Thread(new ReadMessages()).start();
            sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            try {
                output.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ReadMessages implements Runnable {
        @Override
        public void run() {
            String message;
            while (true) {
                try {
                    message = input.readUTF();
                    System.out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}



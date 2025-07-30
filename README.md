# MULTITHREADED-CHAT-APPLICATION

COMPANY: CODTECH IT SOLUTIONS

NAME: TOTTIREDDIGARI VISHNU VARDHAN REDDY

INTERN ID: CT06DG3063

DOMAIN: JAVA PROGRAMMING

DURATION: 6 WEEKS

MENTOR: NEELA SANTOSH


#DESCRIPTION

--->Overview


The chat application consists of a server and multiple clients that communicate in real-time. The server acts as a central hub that manages connections and facilitates message broadcasting among all connected clients. Each client can send and receive messages, allowing for interactive communication.


Components

--->Server:

->Functionality: The server listens for incoming client connections, accepts them, and creates a new thread for each client. It maintains a list of active clients and broadcasts messages received from any client to all other clients.
->Implementation:
Uses ServerSocket to listen on a specified port (e.g., 1234).
Each client connection is handled by a ClientHandler class that implements Runnable.
Messages are broadcasted to all clients using a synchronized method to ensure thread safety.

--->Client:

->Functionality: Each client connects to the server, sends messages, and receives messages from other clients. The client interface allows users to input messages and view incoming messages in real-time.

->Implementation:

Uses Socket to connect to the server.
A separate thread listens for incoming messages and displays them to the user.
The main thread captures user input and sends it to the server.
--->Key Features
->Real-time Communication: Clients can send and receive messages instantly, creating a seamless chat experience.
->Multithreading: Each client runs in its own thread, allowing multiple clients to communicate simultaneously without blocking each other.
->Broadcasting: Messages sent by one client are broadcasted to all other connected clients, enabling group chat functionality.
->Scalability: The server can handle multiple clients, making it suitable for small to medium-sized chat applications.


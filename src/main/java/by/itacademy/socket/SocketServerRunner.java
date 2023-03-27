package by.itacademy.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var server = new ServerSocket(7776);
             var socket = server.accept();
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {
            while (true) {
                System.out.println("Request from the Client: " + inputStream.readUTF());
                outputStream.writeUTF("Hello from the Server");
            }
        }
    }
}

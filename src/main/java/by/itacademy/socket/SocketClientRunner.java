package by.itacademy.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientRunner {

    public static void main(String[] args) throws IOException {
        try (var socket = new Socket("localhost", 7776);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {
            while (true) {
                outputStream.writeUTF("Hello, Server");
                System.out.println("Response from Server: " + inputStream.readUTF());
            }
        }
    }
}

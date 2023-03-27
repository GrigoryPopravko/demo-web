package by.itacademy.socket.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            var server = new ServerSocket(port);
            var socket = server.accept();
            System.out.println("Client accessed");
            processClient(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processClient(Socket socket) {
        try (var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {
            var body = "Hello from the Server";
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body).getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

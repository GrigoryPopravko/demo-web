package by.itacademy.socket.http;

public class HttpServerRunner {

    public static void main(String[] args) {
        HttpServer server = new HttpServer(7777);
        server.run();
    }
}

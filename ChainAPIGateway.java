package org.api;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ChainAPIGateway {
    private final int port;
    private HttpServer server;

    public ChainAPIGateway(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/block/latest", new LatestBlockHandler());
        server.createContext("/api/transaction/send", new TransactionHandler());
        server.setExecutor(null);
        server.start();
    }

    public void stopServer() {
        if (server != null) server.stop(0);
    }
}

class LatestBlockHandler implements HttpHandler {
    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) {
        // API逻辑实现
    }
}

class TransactionHandler implements HttpHandler {
    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) {
        // API逻辑实现
    }
}

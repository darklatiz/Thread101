package tech.geek.flu.multi.thread.throughput;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WarAndPeaceServer {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String text = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("war_and_peace.txt").toURI())));
        startServer(text);
    }

    public static void startServer(String text) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(16);
        httpServer.setExecutor(executor);
        httpServer.start();
    }
}

package tech.geek.flu.multi.thread.throughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordCountHandler implements HttpHandler {
    private String text;

    public WordCountHandler(String text) {
        this.text = text;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getQuery();
        String[] keyValue = query.split("=");
        String action = keyValue[0];
        String value = keyValue[1];
        if(!action.equals("word")) {
            httpExchange.sendResponseHeaders(400, 0);
            return;
        }
        long count = countWord(value);

        byte[] respose = Long.toString(count).getBytes();
        httpExchange.sendResponseHeaders(200, respose.length);
        OutputStream outputStream =  httpExchange.getResponseBody();
        outputStream.write(respose);
        outputStream.close();

    }

    private long countWord(String value) {
        long count = 0;
        int index = 0;
        while (index >= 0 ){
            index = text.indexOf(value, index);
            if (index > 0) {
                count++;
                index++;
            }
        }
        return count;
    }
}

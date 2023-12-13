package main.java.lecture21;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.java.lecture21.util.HttpUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

public class HelloWorldHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        String queryParam = requestURI.getQuery();
        Map<String, String> resultMap = HttpUtils.parseUriQueryParams(queryParam);
        try (OutputStream responseBody = exchange.getResponseBody()) {
            String name = resultMap.get("name");
            String text = "Hello, %s!".formatted(Objects.toString(name, "World"));
            byte[] result = text.getBytes();
            exchange.sendResponseHeaders(200, result.length);

            responseBody.write(result);
        }
//        responseBody.close();
    }
}
package com.andresrojas.literalura.Service;

import com.andresrojas.literalura.DTO.RespuestaGutendex;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoApi {

    private final ObjectMapper mapper = new ObjectMapper();

    public RespuestaGutendex buscarLibro(String titulo) {

        try {
            String direccion = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(response.body(), RespuestaGutendex.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al consumir API");
        }
    }
}
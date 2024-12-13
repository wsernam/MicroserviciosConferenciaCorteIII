package com.conference.gui.evaluator;

import com.conference.gui.entities.Evaluador;
import com.conference.gui.presentation.infra.Subject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del cliente REST para la gestión de evaluadores.
 *
 * @author sonhuila
 */
public class Evaluator extends Subject implements IEvaluatorRest {

    private static final String USER_AGENT = "GUIEvaluators";
    private final String urlEvaluatorService = "http://localhost:7777/api/Conferencia"; // Cambiar por el puerto/URL correcto
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Evaluador postulateEvaluator(Evaluador evaluador) {
        Evaluador postedEvaluator = null;
        try {
            // Convertir el objeto `Evaluador` a JSON
            String jsonInputString = objectMapper.writeValueAsString(evaluador);

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlEvaluatorService.concat("/PostularEvaluador")))
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 201) {
                postedEvaluator = objectMapper.readValue(response.body(), Evaluador.class);
                this.notifyAllObserves();
            } else {
                System.out.println("Error al postular evaluador: Código " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error de conexión al postular evaluador: " + e.getMessage());
            e.printStackTrace();
        }
        return postedEvaluator;
    }

    @Override
    public List<Evaluador> getEvaluators() {
        List<Evaluador> evaluators = new ArrayList<>();
        try {
            // Crear la solicitud HTTP de tipo GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlEvaluatorService.concat("/Evaluadores"))) // Endpoint para obtener todos los evaluadores
                    .header("User-Agent", USER_AGENT)
                    .GET() // Método GET
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                // Convertir la respuesta JSON en una lista de objetos Evaluador
                evaluators = objectMapper.readValue(response.body(), new TypeReference<List<Evaluador>>() {});
            } else {
                System.out.println("Error al obtener los evaluadores: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evaluators;
    }
}

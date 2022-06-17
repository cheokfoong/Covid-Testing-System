package com.mycompany.api;

// Import(s)
import com.mycompany.entity.CovidTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

/**
 * A concrete product
 * This class performs the GET method to obtain the list of Covid tests from the web service
 */
public class CovidTestGet extends Get<CovidTest> {
    
    // Method to obtain all Covid tests 
    @Override
    public List<CovidTest> createGetRequest() throws Exception 
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(COVID_TEST_URL))
                .setHeader("Authorization", API_KEY)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("Something went wrong");
        }
        
        ObjectNode[] jsonNodes = new ObjectMapper().readValue(response.body(), ObjectNode[].class);
        
        List<CovidTest> allCovidTests = new ArrayList<>();
        for (ObjectNode node: jsonNodes) {
            allCovidTests.add(GSON.fromJson(node.toString(), CovidTest.class));
        }
        
        return allCovidTests;
    }
}
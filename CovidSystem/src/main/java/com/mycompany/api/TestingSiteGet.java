package com.mycompany.api;

// Import(s)
import com.mycompany.entity.TestingSite;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

/**
 * A concrete product
 * This class performs the GET method to obtain the list of testing sites from the web service
 */
public class TestingSiteGet extends Get<TestingSite> {
    
    // Method to obtain all testing sites, with bookings
    @Override
    public List<TestingSite> createGetRequest() throws Exception 
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
            .newBuilder(URI.create(TESTING_SITE_URL + "?fields=bookings"))
            .setHeader("Authorization", API_KEY)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("API key is not specified");
        }

        ObjectNode[] jsonNodes = new ObjectMapper().readValue(response.body(), ObjectNode[].class);
        
        List<TestingSite> testingSites = new ArrayList<>();
        for (ObjectNode node: jsonNodes) {
            testingSites.add(GSON.fromJson(node.toString(), TestingSite.class));
        }

        return testingSites;
    }
}
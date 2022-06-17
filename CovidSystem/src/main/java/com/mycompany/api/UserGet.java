package com.mycompany.api;

// Import(s)
import com.mycompany.entity.User;
import com.mycompany.entity.Customer;
import com.mycompany.entity.Receptionist;
import com.mycompany.entity.Administerer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import com.google.gson.*;

/**
 * A concrete product
 * This class performs the GET method to obtain the list of users from the web service
 */
public class UserGet extends Get<User> {
    
    // Method to obtain all users, with bookings and covidTests field
    @Override
    public List<User> createGetRequest() throws Exception 
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(USER_URL + "?fields=bookings&fields=bookings.covidTests"))
                .setHeader("Authorization", API_KEY)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("Something went wrong");
        }
        
        ObjectNode[] jsonNodes = new ObjectMapper().readValue(response.body(), ObjectNode[].class);
        
        // Three types of users: Customer, Receptionist or Administerer
        List<User> allUsers = new ArrayList<>();
        for (ObjectNode node: jsonNodes) {
            JsonObject jsonObject = new JsonParser().parse(node.toString()).getAsJsonObject();
            if (jsonObject.get("isCustomer").getAsBoolean() == true)
                allUsers.add(GSON.fromJson(node.toString(), Customer.class));
            else if (jsonObject.get("isReceptionist").getAsBoolean() == true)
                allUsers.add(GSON.fromJson(node.toString(), Receptionist.class));
            else if (jsonObject.get("isHealthcareWorker").getAsBoolean() == true)
                allUsers.add(GSON.fromJson(node.toString(), Administerer.class));
        }
        
        return allUsers;
    }
}
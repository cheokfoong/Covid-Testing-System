package com.mycompany.api;

// Import(s)
import com.mycompany.entity.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

/**
 * A concrete product
 * This class performs the GET method to obtain the list of bookings from the web service
 */
public class BookingGet extends Get<Booking> {

    // Method to obtain all bookings with covidTests field
    @Override
    public List<Booking> createGetRequest() throws Exception 
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(BOOKING_URL + "?fields=covidTests"))
                .setHeader("Authorization", API_KEY)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("Something went wrong");
        }
        
        ObjectNode[] jsonNodes = new ObjectMapper().readValue(response.body(), ObjectNode[].class);
        
        List<Booking> allBookings = new ArrayList<>();
        for (ObjectNode node: jsonNodes) {
            allBookings.add(GSON.fromJson(node.toString(), Booking.class));
        }
        
        return allBookings;
    }
}
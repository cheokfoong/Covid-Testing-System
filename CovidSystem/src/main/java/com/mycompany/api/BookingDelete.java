package com.mycompany.api;

// Import(s)
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * A concrete product
 * This class performs the DELETE method to delete a booking in the web service
 */
public class BookingDelete extends Delete {

    // Method to delete a booking
    @Override
    public void createDeleteRequest(String bookingID) throws Exception {
        String specificBookingUrl = BOOKING_URL + "/" + bookingID;
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(specificBookingUrl))
                .setHeader("Authorization", API_KEY)
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 204) {
            throw new Exception("Something went wrong");
        }
    } 
}
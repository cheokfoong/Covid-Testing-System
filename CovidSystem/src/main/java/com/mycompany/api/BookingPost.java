package com.mycompany.api;

// Import(s)
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * A concrete product
 * This class performs the POST method to create a booking in the web service
 */
public class BookingPost extends Post {

    public static final int WITHOUT_ADDITIONAL_INFO = 3;
    public static final int WITH_ADDITIONAL_INFO = 5;

    // Method to create a booking
    // The argument is an array of strings
    @Override
    public void createPostRequest(String... strings) throws Exception 
    {
        // Depending on the size of the string array argument
        // The booking is created with different data
        // As seen in the jsonString variable
        
        String jsonString = "";
        if (strings.length == WITHOUT_ADDITIONAL_INFO)
        {
            String[] data = new String[strings.length];
            for (int i = 0; i < strings.length; i++)
            {
                data[i] = strings[i];
            }

            jsonString = "{" +
                "\"customerId\":\"" + data[0] + "\"," +
                "\"testingSiteId\":\"" + data[1] + "\"," +
                "\"startTime\":\"" + data[2] + "\"" +
                "}";
        }
        else if (strings.length == WITH_ADDITIONAL_INFO)
        {
            String[] data = new String[strings.length];
            for (int i = 0; i < strings.length; i++)
            {
                data[i] = strings[i];
            }

            String additionalInfo = "\"qrCode\":\"" + data[3] + "\"," + "\"url\":\"" + data[4];
        
            jsonString = "{" +
                "\"customerId\":\"" + data[0] + "\"," +
                "\"testingSiteId\":\"" + data[1] + "\"," +
                "\"startTime\":\"" + data[2] + "\"," +
                "\"additionalInfo\":" + "{" + additionalInfo + "\"" + "}" +
                "}";
        }
                
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(BOOKING_URL))
                .setHeader("Authorization", API_KEY)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 201) {
                throw new Exception("A customer and/or testing site with the provided ID was not found");
        }
    }
}
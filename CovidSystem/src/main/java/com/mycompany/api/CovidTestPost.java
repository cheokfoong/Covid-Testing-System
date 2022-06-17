package com.mycompany.api;

// Import(s)
import com.mycompany.covidsystem.ControlPanel;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * A concrete product
 * This class performs the POST method to create a Covid test in the web service
 */
public class CovidTestPost extends Post {
    
    // Method to create a Covid test
    // The argument is an array of strings
    @Override
    public void createPostRequest(String... strings) throws Exception 
    {
        String[] data = new String[strings.length];
        for (int i = 0; i < strings.length; i++)
        {
            data[i] = strings[i];
        }

        String jsonString = "{" +
            "\"type\":\"" + data[0] + "\"," +
            "\"patientId\":\"" + data[1] + "\"," +
            "\"bookingId\":\"" + data[2] + "\"," +
            "\"additionalInfo\":" + "{}" +
            "}";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(COVID_TEST_URL))
                .setHeader("Authorization", API_KEY)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 201) {
                throw new Exception("Please fill in all correct details");
        }
    }
}
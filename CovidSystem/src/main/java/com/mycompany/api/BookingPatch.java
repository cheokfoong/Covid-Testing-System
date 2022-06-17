package com.mycompany.api;

// Import(s)
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * A concrete product
 * This class performs the PATCH method to partially update data for an existing booking in the web service
 */
public class BookingPatch extends Patch {

    public static final String TIME = "Time";
    public static final String TESTING_SITE_AND_TIME = "Testing Site And Time";
    public static final String PREVIOUS_BOOKING = "Previous Booking";
    
    // Method to patch a booking
    // The argument is an array of strings
    @Override
    public void createPatchRequest(String... strings) throws Exception {
        
        String specificBookingUrl = "";
        String jsonString = "";
        
        // Depending on the size of the string array argument
        // The booking is patched with different data
        // As seen in the jsonString variable
        
        // Can be used in 2 situations
        // First, revert to a previous booking
        // Second, change to a new testing site and time
        // In both situations, the testingSiteId and startTime are changed
        // The list of previous bookings are also changed
        if (strings.length == 5)    
        {
            String[] data = new String[strings.length]; 
            for (int i = 0; i < strings.length; i++)
            {
                data[i] = strings[i];
            }

            jsonString = "{" +
                    "\"testingSiteId\":\"" + data[0] + "\"," +
                    "\"startTime\":\"" + data[1] + "\"," +
                    "\"additionalInfo\":" + "{" + data[3] + "}" +
                    "}";

            specificBookingUrl = BOOKING_URL + "/" + data[2];   
        }            
        else if (strings.length == 4)
        {
            // Can only be used in 1 situation
            // Change to a new time
            // Patch startTime, additionalInfo
            if (strings[3].equals(TIME) == true)
            {
                String[] data = new String[strings.length]; 
                for (int i = 0; i < strings.length; i++)
                {
                    data[i] = strings[i];
                }
                
                jsonString = "{" +
                        "\"startTime\":\"" + data[0] + "\"," +
                        "\"additionalInfo\":" + "{" + data[2] + "}" +
                        "}";

                specificBookingUrl = BOOKING_URL + "/" + data[1];   
            }
            // For home testing booking
            // Patch additionalInfo
            else
            {
                String[] data = new String[strings.length]; 
                for (int i = 0; i < strings.length; i++)
                {
                    data[i] = strings[i];
                }

                String additionalInfo = "\"qrCode\":\"" + data[0] + "\"," + "\"url\":\"" + data[1] + "\"," + "\"ratKit\":\"" + data[2];

                jsonString = "{" +
                    "\"additionalInfo\":" + "{" + additionalInfo + "\"" + "}" +
                    "}";

                specificBookingUrl = BOOKING_URL + "/" + data[3];
            }
        }
        // Patch status
        else if (strings.length == 2)
        {
            String[] data = new String[strings.length]; 
            for (int i = 0; i < strings.length; i++)
            {
                data[i] = strings[i];
            }

            jsonString = "{" +
                    "\"status\":\"" + data[0] + "\"" +
                    "}";

            specificBookingUrl = BOOKING_URL + "/" + data[1];
        }
            
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(specificBookingUrl))
                .setHeader("Authorization", API_KEY)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("Booking additional info JSON string is incorrect");
        }
    }
}
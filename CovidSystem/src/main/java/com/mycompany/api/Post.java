package com.mycompany.api;

// Import(s)
import com.google.gson.*;

/**
 * An abstract product representing the POST method
 */
public abstract class Post {
    
    public static final String API_KEY = "drrKN8HbB8Dq79TPPhkCLLh8zRzk9t";
    public static final String ROOT_URL = "https://fit3077.com/api/v2";  
    public static final String USER_URL = ROOT_URL + "/user";
    public static final String USER_LOGIN_URL = ROOT_URL + "/user/login";
    public static final String USER_VERIFY_JWT_TOKEN_URL = ROOT_URL + "/user/verify-token";
    public static final String TESTING_SITE_URL = ROOT_URL + "/testing-site";
    public static final String BOOKING_URL = ROOT_URL + "/booking";
    public static final String COVID_TEST_URL = ROOT_URL + "/covid-test";
    public static final Gson GSON = new Gson();

    // An abstract method, to be implemented in a concrete class
    public abstract void createPostRequest(String... strings) throws Exception;
}
package com.mycompany.additionalinfo;

/**
 * This class represents the additional information of a user
 */
public class UserAdditionalInfo implements AdditionalInfo {
    
    // All these variables are needed to store required data
    private final String testingSiteId;

    // Constructor for UserAdditionalInfo object
    public UserAdditionalInfo(String testingSiteId)
    {
        this.testingSiteId = testingSiteId;
    }

    // toString method used primarily for debugging or displaying data
    @Override
    public String toString()
    {
        return 
        "Additional Info: \n" +
        "Testing Site ID: " + testingSiteId;
    }  
    
    // Getters
    public String getTesingSiteId() {return this.testingSiteId;}
}
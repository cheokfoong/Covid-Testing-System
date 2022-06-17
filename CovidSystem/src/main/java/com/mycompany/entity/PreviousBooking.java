package com.mycompany.entity;

/**
 * This class stores the details of a previous booking
 */
public class PreviousBooking {
    
    private String timestamp;
    private String testingSiteId;
    private String testingSiteName;
    private String startTime;
    
    // Constructor for PreviousBooking object
    public PreviousBooking(String timestamp, String testingSiteId, String testingSiteName, String startTime)
    {
        this.timestamp = timestamp;
        this.testingSiteId = testingSiteId;
        this.testingSiteName = testingSiteName;
        this.startTime = startTime;       
    }
    
    // Getters         
    public String getTimestamp()        {return this.timestamp;}
    
    public String getTestingSiteId()    {return this.testingSiteId;}
            
    public String getTestingSiteName()  {return this.testingSiteName;}
                    
    public String getStartTime()        {return this.startTime;}     
 }
package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.BookingAdditionalInfo;
import java.util.*;

/**
 * This class represents a booking
 */
public class Booking {
    
    // All these variables are needed to store required data
    // Some are optional
    private final String id;
    private final Customer customer; 
    private final TestingSite testingSite; 
    private final String createdAt;
    private final String updatedAt;
    private final String startTime;
    private final String smsPin;
    private final String status;
    private final List<CovidTest> covidTests;
    private final String notes;
    private final BookingAdditionalInfo additionalInfo;
    
    // Constructor for Booking object
    public Booking(String id, Customer customer, TestingSite testingSite, String createdAt, String updatedAt, String startTime, String smsPin, String status, List<CovidTest> covidTests, String notes, BookingAdditionalInfo additionalInfo)
    {
        this.id = id;
        this.customer = customer;
        this.testingSite = testingSite;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.startTime = startTime;
        this.smsPin = smsPin;
        this.status = status;
        this.covidTests = covidTests; 
        this.notes = notes;
        this.additionalInfo = additionalInfo;
    }
    
    // Getters
    public String getId()                               {return this.id;}

    public Customer getCustomer()                       {return this.customer;}
    
    public TestingSite getTestingSite()                 {return this.testingSite;}

    public String getCreatedAt()                        {return this.createdAt;}

    public String getUpdatedAt()                        {return this.updatedAt;}
    
    public String getStartTime()                        {return this.startTime;}
    
    public String getSmsPin()                           {return this.smsPin;}
    
    public String getStatus()                           {return this.status;}
    
    public List<CovidTest> getCovidTests()              {return this.covidTests;}

    public String getNotes()                            {return this.notes;}

    public BookingAdditionalInfo getAdditionalInfo()    {return this.additionalInfo;}
}
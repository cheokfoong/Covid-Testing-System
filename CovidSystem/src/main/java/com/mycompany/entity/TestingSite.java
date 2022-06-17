package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.TestingSiteAdditionalInfo;
import java.util.*;

/**
 * This class represents a testing site
 */
public class TestingSite {
    
    // All these variables are needed to store required data
    // Except for description, websiteUrl, phoneNumber and bookings where they are optional
    private final String id;
    private final String name;
    private final String description;
    private final String websiteUrl;
    private final String phoneNumber;
    private final Address address;    
    private final List<Booking> bookings;
    private final String createdAt;
    private final String updatedAt;
    private final TestingSiteAdditionalInfo additionalInfo;

    // Constructor for TestingSite object
    public TestingSite(String id, String name, String description, String websiteUrl, String phoneNumber, Address address, List<Booking> bookings, String createdAt, String updatedAt, TestingSiteAdditionalInfo additionalInfo)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bookings = bookings;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.additionalInfo = additionalInfo;
    }

    // toString method used primarily for debugging or displaying data
    @Override
    public String toString()
    {
        // Debugging version
        // return 
        // "\nId: " + this.id + "\n\n" +
        // "Name: " + this.name + "\n\n" +
        // "Description: " + this.description + "\n\n" +
        // "Website Url: " + this.websiteUrl + "\n\n" +
        // "Phone Number: " + this.phoneNumber + "\n\n" +
        // this.address + "\n" +
        // "Created At: " + this.createdAt + "\n\n" +
        // "Updated At: " + this.updatedAt + "\n\n" +
        // this.additionalInfo + "\n" +
        // "Bookings: " + this.bookings + "\n";

        // GUI display version
        return this.name;
    }

    // Getters
    public String getId()                                   {return this.id;}

    public String getName()                                 {return this.name;}

    public String getDescription()                          {return this.description;}

    public String getWebsiteUrl()                           {return this.websiteUrl;}

    public String getPhoneNumber()                          {return this.phoneNumber;}

    public Address getAddress()                             {return this.address;}

    public List<Booking> getBookings()                      {return this.bookings;}

    public String getCreatedAt()                            {return this.createdAt;}

    public String getUpdatedAt()                            {return this.updatedAt;}

    public TestingSiteAdditionalInfo getAdditionalInfo()    {return this.additionalInfo;}
}
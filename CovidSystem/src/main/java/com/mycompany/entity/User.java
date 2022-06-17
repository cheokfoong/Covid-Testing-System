package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.UserAdditionalInfo;
import java.util.*;

/**
 * This class represents a user
 */
public abstract class User {
    
    // All these variables are needed to store required data
    // Some are optional
    private final String id;
    private final String givenName;
    private final String familyName;
    private final String userName;
    private final String phoneNumber;
    private final boolean isCustomer;
    private final boolean isReceptionist;
    private final boolean isHealthcareWorker;
    private final List<Booking> bookings;
    private final UserAdditionalInfo additionalInfo;
   
    // Constructor for User object
    public User(String id, String givenName, String familyName, String userName, String phoneNumber, boolean isCustomer,
            boolean isReceptionist, boolean isHealthcareWorker, List<Booking> bookings, UserAdditionalInfo additionalInfo) 
    {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.isCustomer = isCustomer;
        this.isReceptionist = isReceptionist;
        this.isHealthcareWorker = isHealthcareWorker;
        this.bookings = bookings;
        this.additionalInfo = additionalInfo;
    }
    
    // Getters
    public String getId()                           {return this.id;}
    
    public String getGivenName()                    {return this.givenName;}
    
    public String getFamilyName()                   {return this.familyName;}

    public String getUsername()                     {return this.userName;}

    public String getPhoneNumber()                  {return this.phoneNumber;}
    
    public Boolean isCustomer()                     {return this.isCustomer;};
    
    public Boolean isReceptionist()                 {return this.isReceptionist;};
    
    public Boolean isHealthcareWorker()             {return this.isHealthcareWorker;};

    public List<Booking> getBookings()              {return this.bookings;}

    public UserAdditionalInfo getAdditionalInfo()   {return this.additionalInfo;} 
}
package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.UserAdditionalInfo;
import java.util.*;

/**
 * This class represents a receptionist
 */
public class Receptionist extends User {
    
    // Constructor for Receptionist object
    public Receptionist(String id, String givenName, String familyName, String userName, String phoneNumber, Boolean isCustomer,
            Boolean isReceptionist, Boolean isHealthcareWorker, ArrayList<Booking> bookings, UserAdditionalInfo additionalInfo)
    {
        super(id, givenName, familyName, userName, phoneNumber, isCustomer, isReceptionist, isHealthcareWorker, bookings, additionalInfo);
    }  
}
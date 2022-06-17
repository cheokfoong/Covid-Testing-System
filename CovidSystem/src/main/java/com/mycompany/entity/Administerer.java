package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.UserAdditionalInfo;
import java.util.*;

/**
 * This class represents an administerer
 */
public class Administerer extends User {
    
    // Constructor for Administerer object
    public Administerer(String id, String givenName, String familyName, String userName, String phoneNumber, Boolean isCustomer,
            Boolean isReceptionist, Boolean isHealthcareWorker, ArrayList<Booking> bookings, UserAdditionalInfo additionalInfo)
    {
        super(id, givenName, familyName, userName, phoneNumber, isCustomer, isReceptionist, isHealthcareWorker, bookings, additionalInfo);
    } 
}
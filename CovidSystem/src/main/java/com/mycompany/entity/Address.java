package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.AddressAdditionalInfo;

/**
 * This class represents the address of a testing site
 */
public class Address {
    
    // All these variables are needed to store required data
    // Except for unitNumber and street2 where they are optional
    private final double latitude;
    private final double longitude;
    private final String unitNumber;
    private final String street;
    private final String street2;       
    private final String suburb;
    private final String state;
    private final String postcode;
    private final AddressAdditionalInfo additionalInfo;
    
    // Constructor for Address object
    public Address(double latitude, double longitude, String unitNumber, String street, String street2, String suburb, String state, String postcode, AddressAdditionalInfo additionalInfo)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.unitNumber = unitNumber;
        this.street = street;
        this.street2 = street2;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.additionalInfo = additionalInfo;
    }

    // toString method used primarily for debugging or displaying data
    @Override
    public String toString()
    {
        return String.format("Address: \nLatitude: %d\nLongitude: %d\nUnit Number: %s\nStreet: %s\nStreet 2: %s\nSuburb: %s\nState: %s\nPostcode: %s\n%s", 
        this.latitude, this.longitude, this.unitNumber, this.street, this.street2, this.suburb, this.state, this.postcode, this.additionalInfo);
    }

    // Getters
    public double getLatitude()                         {return this.latitude;}

    public double getLongitude()                        {return this.longitude;}

    public String getUnitNumber()                       {return this.unitNumber;}

    public String getStreet()                           {return this.street;}

    public String getStreet2()                          {return this.street2;}

    public String getSuburb()                           {return this.suburb;}

    public String getState()                            {return this.state;}

    public String getPostcode()                         {return this.postcode;}

    public AddressAdditionalInfo getAdditionalInfo()    {return this.additionalInfo;}
}
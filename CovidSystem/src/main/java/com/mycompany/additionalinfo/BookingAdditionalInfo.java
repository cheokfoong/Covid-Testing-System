package com.mycompany.additionalinfo;

// Import(s)
import com.mycompany.entity.PreviousBooking;
import java.util.*;

/**
 * This class represents the additional information of a booking
 */
public class BookingAdditionalInfo implements AdditionalInfo {
    
    // All these variables are needed to store required data
    // Some bookings might store them as null
    private final String qrCode;
    private final String url;
    private String ratKit;
    private List<PreviousBooking> previousBookings = new ArrayList<>();
    
    // Constructor without ratKit
    public BookingAdditionalInfo(String qrCode, String url, List<PreviousBooking> previousBookings)
    {
        this.qrCode = qrCode;
        this.url = url;
        this.previousBookings = previousBookings;
    }
    
    // Constructor with ratKit
    public BookingAdditionalInfo(String qrCode, String url, String ratKit, List<PreviousBooking> previousBookings)
    {
        this.qrCode = qrCode;
        this.url = url;
        this.ratKit = ratKit;
        this.previousBookings = previousBookings;
    }
    
    // toString method used primarily for debugging or displaying data
    @Override
    public String toString()
    {
        return 
        "Additional Info: \n" +
        "QR Code: " + this.qrCode + "\n" +
        "URL: " + this.url + "\n" +
        "RAT Kit: " + this.ratKit + "\n" + 
        "Previous Booking(s): " + this.previousBookings.size();
    } 
    
    // Getters
    public String getQrCode()                          {return this.qrCode;}
    
    public String getUrl()                             {return this.url;}
    
    public String getRatKit()                          {return this.ratKit;}   
    
    public List<PreviousBooking> getPreviousBookings() {return this.previousBookings;}
}
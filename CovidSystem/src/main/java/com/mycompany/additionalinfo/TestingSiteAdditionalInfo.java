package com.mycompany.additionalinfo;

/**
 * This class represents the additional information of a testing site
 */
public class TestingSiteAdditionalInfo implements AdditionalInfo {

    // All these variables are needed to store required data
    private final boolean onSiteBooking;
    private final boolean onSiteTesting;
    private final String facilityType;
    private final String openingTime;
    private final String closingTime;

    // Constructor for TestingSiteAdditionalInfo object
    public TestingSiteAdditionalInfo(boolean onSiteBooking, boolean onSiteTesting, String facilityType, String openingTime, String closingTime)
    {
        this.onSiteBooking = onSiteBooking;
        this.onSiteTesting = onSiteTesting;
        this.facilityType = facilityType;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    
    // toString method used primarily for debugging or displaying data
    @Override
    public String toString()
    {
        return 
        "Additional Info: \n" +
        "On-site Booking: " + yesOrNo(this.onSiteBooking) + "\n" +
        "On-site Testing: " + yesOrNo(this.onSiteTesting) + "\n" +
        "Facility Type: " + this.facilityType + "\n" +
        "Opening Time: " + this.openingTime + "\n" +
        "Closing Time: " + this.closingTime + "\n";      
    }

    // Getters
    public boolean getOnSiteBooking()   {return this.onSiteBooking;}

    public boolean getOnSiteTesting()   {return this.onSiteTesting;}

    public String getfacilityType()     {return this.facilityType;}
    
    public String getOpeningTime()      {return this.openingTime;}
    
    public String getClosingTime()      {return this.closingTime;}

    // If true, return yes
    // Else, return no
    public String yesOrNo(boolean value)
    {
        if (value)
        {
            return "Yes";
        }
        else
        {
            return "No";
        }
    }
}
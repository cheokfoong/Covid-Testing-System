package com.mycompany.entity;

// Import(s)
import com.mycompany.additionalinfo.CovidTestAdditionalInfo;

/**
 * This class represents a Covid test
 */
public class CovidTest {
    
    // All these variables are needed to store required data
    // Some are optional
    private final String id;
    private final String type;
    private final Customer patient;
    private final Administerer administerer; 
    private final Booking booking;
    private final String result;
    private final String status;
    private final String notes;
    private final String datePerformed;
    private final String dateOfResults;
    private final String createdAt;
    private final String updatedAt;
    private final CovidTestAdditionalInfo additionalInfo;
    
    // Constructor for CovidTest object
    public CovidTest(String id, String type, Customer patient, Administerer administerer, Booking booking, String result, String status, 
            String notes, String datePerformed, String dateOfResults, String createdAt, String updatedAt, CovidTestAdditionalInfo additionalInfo)
    {
        this.id = id;
        this.type = type;
        this.patient = patient;
        this.administerer = administerer;
        this.booking = booking;
        this.result = result;
        this.status = status;
        this.notes = notes;
        this.datePerformed = datePerformed;
        this.dateOfResults = dateOfResults;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.additionalInfo = additionalInfo;
    }
    
    // Getters
    public String getId()                               {return this.id;}

    public String getType()                             {return this.type;}

    public Customer getPatient()                        {return this.patient;}
    
    public Administerer getAdministerer()               {return this.administerer;}
    
    public Booking getBooking()                         {return this.booking;}
    
    public String getResult()                           {return this.result;}
    
    public String getStatus()                           {return this.status;}

    public String getNotes()                            {return this.notes;}

    public String getDatePerformed()                    {return this.datePerformed;}

    public String getDateOfResults()                    {return this.dateOfResults;}

    public String getCreatedAt()                        {return this.createdAt;}

    public String getUpdatedAt()                        {return this.updatedAt;}

    public CovidTestAdditionalInfo getAdditionalInfo()  {return this.additionalInfo;}
}
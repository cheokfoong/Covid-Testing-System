package com.mycompany.api;

// Import(s)
import com.mycompany.entity.Booking;
import com.mycompany.entity.TestingSite;
import com.mycompany.entity.CovidTest;
import com.mycompany.entity.User;

/**
 * This is a class that acts as a creator of concrete factories
 * Each method returns a different concrete factory object
 */
public class FactoryCreator {

    public static APIFactory<Booking> getBookingFactory()
    {
        return new BookingFactory();
    }

    public static APIFactory<TestingSite> getTestingSiteFactory()
    {
        return new TestingSiteFactory();
    }

    public static APIFactory<CovidTest> getCovidTestFactory()
    {
        return new CovidTestFactory();
    }

    public static APIFactory<User> getUserFactory()
    {
        return new UserFactory();
    }
}
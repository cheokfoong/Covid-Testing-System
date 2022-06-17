package com.mycompany.api;

// Import(s)
import com.mycompany.entity.Booking;

/**
 * A concrete factory that contains methods to produce concrete products
 * This factory returns Booking related concrete products
 * Some are null as they are not needed
 */
public class BookingFactory implements APIFactory<Booking> {

    @Override
    public Get<Booking> createGet() 
    {
        return new BookingGet();
    }

    @Override
    public Post createPost() 
    {
        return new BookingPost();
    }

    @Override
    public Patch createPatch() 
    {
        return new BookingPatch();
    }

    @Override
    public Delete createDelete() 
    {
        return new BookingDelete();
    }  
}
package com.mycompany.api;

/**
 * The abstract factory interface
 * T can represent Booking/TestingSite/CovidTest/User
 */
public interface APIFactory<T> {

    public Get<T> createGet();

    public Post createPost();

    public Patch createPatch();

    public Delete createDelete();
}
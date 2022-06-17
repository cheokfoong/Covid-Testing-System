package com.mycompany.api;

// Import(s)
import com.mycompany.entity.CovidTest;

/**
 * A concrete factory that contains methods to produce concrete products
 * This factory returns CovidTest related concrete products
 * Some are null as they are not needed
 */
public class CovidTestFactory implements APIFactory<CovidTest> {

    @Override
    public Get<CovidTest> createGet() 
    {
        return new CovidTestGet();
    }

    @Override
    public Post createPost() 
    {
        return new CovidTestPost();
    }

    @Override
    public Patch createPatch() 
    {
        return null;
    }

    @Override
    public Delete createDelete() 
    {
        return null;
    }
}
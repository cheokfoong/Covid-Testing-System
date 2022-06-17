package com.mycompany.api;

// Import(s)
import com.mycompany.entity.TestingSite;

/**
 * A concrete factory that contains methods to produce concrete products
 * This factory returns TestingSite related concrete products
 * Some are null as they are not needed
 */
public class TestingSiteFactory implements APIFactory<TestingSite> {

    @Override
    public Get<TestingSite> createGet() 
    {
        return new TestingSiteGet();
    }

    @Override
    public Post createPost() 
    {
        return null;
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
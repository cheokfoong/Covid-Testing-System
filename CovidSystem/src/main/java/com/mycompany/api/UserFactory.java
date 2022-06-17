package com.mycompany.api;

// Import(s)
import com.mycompany.entity.User;

/**
 * A concrete factory that contains methods to produce concrete products
 * This factory returns User related concrete products
 * Some are null as they are not needed
 */
public class UserFactory implements APIFactory<User> {

    @Override
    public Get<User> createGet() 
    {
        return new UserGet();
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
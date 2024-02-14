package com.u3.model;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Unit tests of the model class
 */
public class ModelTest { 

    static private ObjectMapper mapper = new ObjectMapper(); // static because we can reuse it

    /**
     * Test the default constructor
     */
    @Test
    public void testModelGet() {
        Model model = Model.get();
        assertTrue(model != null);
        assertTrue(mapper != null);
    }

}

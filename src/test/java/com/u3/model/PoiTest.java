package com.u3.model;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertTrue;
//import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Unit tests of the Poi class
 */
public class PoiTest {

    static private ObjectMapper mapper = new ObjectMapper(); // static because we can reuse it

    @Test
    public void testPoiDefaultConstructor() {
        Poi poi = new Poi();
        assertTrue(poi != null);
        assertTrue(mapper != null);
    }

}

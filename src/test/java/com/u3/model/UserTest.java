package com.u3.model;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertTrue;
//import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Unit tests of the User class
 */
public class UserTest {

    static private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testUserGeneralConstructor() {
        User user = new User("user", "student", "password1", "John Doe", null, mapper);
        assertTrue(user != null);
        assertTrue(user.getType().equals("user") == true);
        assertTrue(user.getUserid().equals("student") == true);
        assertTrue(user.getPassword().equals("password1") == true);
        assertTrue(user.getAlias().equals("John Doe") == true);

    }

    @Test
    public void testUserSetter () {
        User user = new User("user", "student", "password1", "John Doe", null, mapper);
        assertTrue(user != null);
        user.setType("admin");
        user.setUserid("admin");
        user.setPassword("password2");
        user.setAlias("Jane Doe");
        assertTrue(user.getType().equals("admin") == true);
        assertTrue(user.getUserid().equals("admin") == true);
        assertTrue(user.getPassword().equals("password2") == true);
        assertTrue(user.getAlias().equals("Jane Doe") == true);
    }

    @Test
    public void testUserPois() {


        User user = new User("user", "student", "password1", "John Doe", null, mapper);
        assertTrue(user != null);

        Poi poi = new Poi("owner", new Position(3,4), 1, "5", "south", "type", "fax", "lable","class", "data/images/map-pin.jpeg" , null, null, mapper);
        assertTrue(poi != null);
        assertTrue(poi.getOwner().equals("owner") == true);
        assertTrue(poi.getPos().getXPos() == 3);
        assertTrue(poi.getPos().getYPos() == 4);

    }

    
    
}

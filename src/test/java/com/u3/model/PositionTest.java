package com.u3.model;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertTrue;
/**
 * Unit tests of the Position class
 */
public class PositionTest {


    @Test
    public void testPositionDefaultConstructor() {
        Position position = new Position();
        assertTrue(position != null);
        assertTrue(position.getXPos() == 0);
        assertTrue(position.getYPos() == 0);
    }

    @Test
    public void testPositionGeneralConstructor() {
        Position position = new Position(1, 2);
        assertTrue(position != null);
        assertTrue(position.getXPos() == 1);
        assertTrue(position.getYPos() == 2);
    }

    @Test
    public void testPositionSetter() {
        Position position = new Position(1, 2);
        position.setXPos(2);
        position.setYPos(7);
        assertTrue(position.getXPos() == 2);
        assertTrue(position.getYPos() == 7);
    }

    @Test
    public void testPositionToString() {
        Position position = new Position(1, 2);
        String positionString = position.toString();
        assertTrue(positionString != null);
    }
    
}

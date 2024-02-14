package com.u3.frontend;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;


public class WeatherTest {

    private Weather_API api;
  
    @BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    public void setUp() {
     System.out.println("Instantiating Weather_API");
     api = new Weather_API();
    }

    @Test
    public void testGetCurrentTemp(){
        String currentTemp = api.get_currentTemp();
        assertTrue(currentTemp!=null);
    }

    @Test
    public void testGetFeelsLikeTemp() {
        String feelslikeTemp = api.get_feelsLike();
        assertTrue(feelslikeTemp!=null);
  }

    @Test
        public void testGetDescription() {
            String description = api.get_description();
            assertTrue(description!=null);
    }

    @Test
    public void testGetMinTemp() {
        String min_temp = api.get_minTemp();
        assertTrue(min_temp!=null);
    }

    @Test
    public void testGetMaxTemp() {
        String max_temp = api.get_maxTemp();
        assertTrue(max_temp!=null);
    }

    @Test
    public void testGetPressure() {
        String pressure = api.get_Pressure();
        assertTrue(pressure!=null);
    }

    @Test
    public void testGetHumidity() {
        String humidity = api.get_Humidity();
        assertTrue(humidity!=null);
    }

    @Test
    public void testGetIcon() {
        String icon = api.get_Icon();
        assertTrue(icon!=null);
    }

}

package com.u3.model;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Unit tests for the building class
 */
public class BuildingTest {

    static private ObjectMapper mapper = new ObjectMapper(); // static because we can reuse it

    @Test
    public void testBuildingGeneralConstructor() {
        Building building = new Building("MC", "Middlesex College", null, mapper);
        assertTrue(building != null);
        assertTrue(building.getCode().equals("MC") == true);
        assertTrue(building.getName().equals("Middlesex College") == true);

    }

    @Test
    public void testBuildingSetter() {
        Building building = new Building("MC", "Middlesex College", null,  mapper);
        building.setCode("WSC");
        building.setName("Western Science Center");
        assertTrue(building.getCode().equals("WSC") == true);
        assertTrue(building.getName().equals("Western Science Center") == true);
    }

    @Test
    public void testBuildingToString() {
        Building building = new Building("MC", "Middlesex College", null,  mapper);
        String buildingString = building.toString();
        assertTrue(buildingString != null);
    }

    @Test
    public void testBuildingCreate() {
        Building building = Building.create("MC", "Middlesex College", null);
        assertTrue(building != null);
        assertTrue(building.getCode().equals("MC") == true);
        assertTrue(building.getName().equals("Middlesex College") == true);
    }

    @Test
    public void testBuildingGetFloors() {
        
        FloorMap mapMCFlr1 = FloorMap.create("Ground Floor", "data/floormaps/MC-groundfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr2 = FloorMap.create("Second Floor", "data/floormaps/MC-secondfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr3 = FloorMap.create("Third Floor", "data/floormaps/MC-thirdfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr4 = FloorMap.create("Fourth Floor", "data/floormaps/MC-fourthfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr5 = FloorMap.create("Fifth Floor", "data/floormaps/MC-fifthfloor.png", new ArrayList<Poi>());
        ArrayList<FloorMap> mcFloorMaps = new ArrayList<FloorMap>();
        mcFloorMaps.add(mapMCFlr1);
        mcFloorMaps.add(mapMCFlr2);
        mcFloorMaps.add(mapMCFlr3);
        mcFloorMaps.add(mapMCFlr4);
        mcFloorMaps.add(mapMCFlr5);

        Building building = Building.create("MC", "Middlesex College", mcFloorMaps);
        
        assertTrue(building != null);
        assertTrue(building.getFloors() != null);
        assertTrue(building.getFloors().get(0) == mapMCFlr1.getName());
    }


    
}

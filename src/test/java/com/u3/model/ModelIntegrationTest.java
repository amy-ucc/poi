package com.u3.model;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Integration tests of the model class
 */
public class ModelIntegrationTest {

    static private ObjectMapper mapper = new ObjectMapper(); // static because we can reuse it

    /**
     * Test the integration of the model classe with the JSON file
     */
    @Test 
    public void testIntegrationWithFile() {

        File modeTestFile = new File("data/model-test.json");

        // Starting setup of users
        User admin = User.create("admin","root", "root_password","SuperGirl", new ArrayList<Poi>());
        User general = User.create("general","user", "user_password","RegularUser", new ArrayList<Poi>());
        HashMap<String, User> users = new HashMap<String, User>();
        users.put(admin.getUserid(), admin); // get by userid == root
        users.put(general.getUserid(), general); // get by userid == general

        // Starting setup of buildings
        // Middlesex College
        // floormaps should go in data/floormaps directory of where the jar is run from
        FloorMap mapMCFlr0 = FloorMap.create("Ground Floor", "data/floormaps/MC-groundfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr1 = FloorMap.create("First Floor", "data/floormaps/MC-firstfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr2 = FloorMap.create("Second Floor", "data/floormaps/MC-secondfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr3 = FloorMap.create("Third Floor", "data/floormaps/MC-thirdfloor.png", new ArrayList<Poi>());
        FloorMap mapMCFlr4 = FloorMap.create("Fourth Floor", "data/floormaps/MC-fourthfloor.png", new ArrayList<Poi>());
        ArrayList<FloorMap> mcFloorMaps = new ArrayList<FloorMap>();
        mcFloorMaps.add(mapMCFlr0);
        mcFloorMaps.add(mapMCFlr1);
        mcFloorMaps.add(mapMCFlr2);
        mcFloorMaps.add(mapMCFlr3);
        mcFloorMaps.add(mapMCFlr4);
        
        FloorMap mapHSBFlr1 = FloorMap.create("Ground Floor", "data/floormaps/HSB-groundfloor.png", new ArrayList<Poi>());
        FloorMap mapHSBFlr2 = FloorMap.create("Second Floor", "data/floormaps/HSB-secondfloor.png", new ArrayList<Poi>());
        FloorMap mapHSBFlr3 = FloorMap.create("Third Floor", "data/floormaps/HSB-thirdfloor.png", new ArrayList<Poi>());
        FloorMap mapHSBFlr4 = FloorMap.create("Fourth Floor", "data/floormaps/HSB-fourthfloor.png", new ArrayList<Poi>());
        ArrayList<FloorMap> hsbFloorMaps = new ArrayList<FloorMap>();
        hsbFloorMaps.add(mapHSBFlr1);
        hsbFloorMaps.add(mapHSBFlr2);
        hsbFloorMaps.add(mapHSBFlr3);
        hsbFloorMaps.add(mapHSBFlr4);

        FloorMap mapWSCFlr1 = FloorMap.create("Ground Floor", "data/floormaps/WSC-groundfloor.png", new ArrayList<Poi>());
        FloorMap mapWSCFlr2 = FloorMap.create("Second Floor", "data/floormaps/WSC-secondfloor.png", new ArrayList<Poi>());
        FloorMap mapWSCFlr3 = FloorMap.create("Third Floor", "data/floormaps/WSC-thirdfloor.png", new ArrayList<Poi>());
        FloorMap mapWSCFlr4 = FloorMap.create("Fourth Floor", "data/floormaps/WSC-fourthfloor.png", new ArrayList<Poi>());
        ArrayList<FloorMap> wscFloorMaps = new ArrayList<FloorMap>();
        wscFloorMaps.add(mapWSCFlr1);
        wscFloorMaps.add(mapWSCFlr2);
        wscFloorMaps.add(mapWSCFlr3);
        wscFloorMaps.add(mapWSCFlr4);

        // Create buildings
        Building bldMC = Building.create("MC", "Middlesex College", mcFloorMaps);
        Building bldHSB = Building.create("HSB", "Health Science Building", hsbFloorMaps);
        Building bldWSC = Building.create("WSC", "Western Science Center", wscFloorMaps);

        // Pois
        Poi poiMCFlr00 = Poi.create("user", new Position(3,4), 0, "5", "south", "type", "fax", "lable","class", "data/images/map-pin.jpeg" , null, null);
        mapMCFlr0.addPoi(poiMCFlr00);
        Poi poiMCFlr01 = Poi.create("user", new Position(10,44), 0, "5", "south", "type", "fax", "lable","class", "data/images/map-pin.jpeg" , null, null);
        mapMCFlr0.addPoi(poiMCFlr01);

        // pass the buildings collection to the model
        HashMap<String, Building> buildings = new HashMap<String, Building>();
        buildings.put(bldMC.getName(), bldMC);
        buildings.put(bldHSB.getName(), bldHSB);
        buildings.put(bldWSC.getName(), bldWSC);

        Model model = new Model(users, buildings,  null, mapper, modeTestFile);


        assertTrue(model != null);
        String modelInMemoryStr = model.toString();
        model.serialize();

        Model modelFromFile= null;
        String modelFromFileStr = null;

        try {
            modelFromFile = mapper.readValue((modeTestFile), Model.class);
            modelFromFile.setMapper(mapper);
            modelFromFile.setModelFile(modeTestFile);
        } catch (IOException e) {
            e.printStackTrace();
            assertFalse("IOException thrown when reading model from file", false);
        }

        modelFromFileStr = modelFromFile.toString();
        assertTrue("Model from file should be the same as the model in memory", modelInMemoryStr.equals(modelFromFileStr)); 

    }


    
}

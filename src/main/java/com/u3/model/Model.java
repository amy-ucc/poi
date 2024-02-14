package com.u3.model; // package

import java.io.File; // required for file handling
import java.io.IOException; // required for file handling
import java.util.ArrayList; // ArrayList
import java.util.HashMap; // HashMap

import com.fasterxml.jackson.annotation.JsonIgnore; // required to ignore fields when serializing

// lombok allows getters, setters and constructors to be automatically created by annotation
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.databind.ObjectMapper; // required to serialize objects with jackson
import com.fasterxml.jackson.databind.SerializationFeature; // required to serialize objects with jackson

@NoArgsConstructor(access = AccessLevel.PUBLIC) // creates a no argument constructor required by jackson
@AllArgsConstructor(access = AccessLevel.PUBLIC) // creates an all argument constructor required by jackson
public class Model implements ISerialize, IPrintable {

    // the reference to and only data wizard / model
    // static reference
    private static Model single_instance = null;

    // the instance variables of the model
    //private @Setter @Getter ArrayList <User> users;
    // lombok automatically creates getters and setters for these fields based on annotations
    private @Setter @Getter HashMap <String, User> users; // hashmap of users
    private @Setter @Getter HashMap <String, Building> buildings; // hashmap of buildings
    private @Setter @Getter @JsonIgnore User currUser; // current user
    private @Setter @Getter @JsonIgnore ObjectMapper mapper; // object mapper for serialization
    private @Setter @Getter @JsonIgnore File modelFile; // file for serialization

    /**
     * Return the entire model to a string in json format
     */
    @Override
    public String toString() {
        try {
            return mapper.enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
        } catch (Exception e) {
            System.out.print(e);
            return e.toString();       
        }
    }

    /**
     * Print the model out to console
     */
    @Override
    public void printOut() {
        System.out.println(this.toString());
    }

    @Override
    public void serialize() {
        try {
            mapper.writeValue(modelFile, this);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    ///////////////  User  Methods ///////////////
    /**
     * Get the users list
     * @return arraylist of users
     */
    @JsonIgnore
    public ArrayList <User> getUsersList() {
        ArrayList <User> output = new ArrayList<User>();
        for (String key : users.keySet()) {
            output.add(users.get(key));
        }
        return output;
    }

    /**
     * Get the users name as a string array
     * @return string of usernames
     */
    @JsonIgnore
    public String [] getUsersArray() {
        String [] output = new String[users.size()];
        int i = 0;
        for (String key : users.keySet()) {
            output[i] = users.get(key).getUserid();
            i++;
        }
        return output;
    }

    /**
     * Get a user from the model by usierid
     * @param key userid of the user
     */
    @JsonIgnore
    public User getUser(String key) {
        return users.get(key);
    }

    /**
     * check if a userid and password exists in the model
     * if it does return the user if not return null
     * @param userid
     * @param password
     * @return user or null
     */
    @JsonIgnore
    public User checkUser(String userid, String password) {
        User user = users.get(userid);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * Login a user by setting currUser to the user
     * if the user password matches otherwise set currUser to null
     * @param userid
     * @param password
     * @return user or null
     */
    public User login(String userid, String password) {
        User user = checkUser(userid, password);
        if (user != null) {
            currUser = user;
        }
        return user;
    }

    ////////////  Building Methods //////////////
    /**
     * Get an arraylist of buildings
     * @return arraylist of buildings
     */
    @JsonIgnore
    public ArrayList<Building> getBuildingsList() {
        ArrayList <Building> output = new ArrayList<Building>();
        for (String key : buildings.keySet()) {
            output.add(buildings.get(key));
        }
        return output;
    }

    /**
     * Get an array of building names
     * @return string array of building names
     */
    @JsonIgnore
    public String [] getBuildingsArray() {
        String [] output = new String[buildings.size()];
        int i = 0;
        for (String key : buildings.keySet()) {
            output[i] = buildings.get(key).getName();
            i++;
        }
        return output;
    }

    /**
     * Get a building by name
     * @param key building name
     * @return
     */
    @JsonIgnore
    public Building getBuilding(String key) {
        return buildings.get(key);
    }

    /**
     * Get a building by name
     * Better to use the one above this is keept to not break code that might
     * have used it earlier
     * @param key
     * @return
     */
    @JsonIgnore
    public Building get(String key) {
        return this.getBuilding(key);
    }

    ///////// Factory method to get or create single model object /////////
    /**
     * Singleton pattern to create or get a single instance of the model
     * @return model object ( can only be one )
     */
    public static Model get()
    {
        if (single_instance == null) {

            ObjectMapper mapper = new ObjectMapper();
            File modelFile = new File("data/model.json");
            
            try {
                if (modelFile.exists()) {

                    single_instance = mapper.readValue((modelFile), Model.class);
                    single_instance.setMapper(mapper);
                    single_instance.setModelFile(modelFile);

                } else {

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

                    FloorMap mapWSCFlr0 = FloorMap.create("Ground Floor", "data/floormaps/WSC-groundfloor.png", new ArrayList<Poi>());
                    FloorMap mapWSCFlr1 = FloorMap.create("First Floor", "data/floormaps/WSC-firstfloor.png", new ArrayList<Poi>());
                    FloorMap mapWSCFlr2 = FloorMap.create("Second Floor", "data/floormaps/WSC-secondfloor.png", new ArrayList<Poi>());
                    FloorMap mapWSCFlr3 = FloorMap.create("Third Floor", "data/floormaps/WSC-thirdfloor.png", new ArrayList<Poi>());
                    ArrayList<FloorMap> wscFloorMaps = new ArrayList<FloorMap>();
                    wscFloorMaps.add(mapWSCFlr0);
                    wscFloorMaps.add(mapWSCFlr1);
                    wscFloorMaps.add(mapWSCFlr2);
                    wscFloorMaps.add(mapWSCFlr3);

                    // Create buildings
                    Building bldMC = Building.create("MC", "Middlesex College", mcFloorMaps);
                    Building bldHSB = Building.create("HSB", "Health Science Building", hsbFloorMaps);
                    Building bldWSC = Building.create("WSC", "Western Science Center", wscFloorMaps);

                    // Pois
                    // Poi poiMCFlr00 = Poi.create("user", new Position(3,4), 0, "5", "south", "type", "fax", "lable","class", "data/images/map-pin.jpeg" , null, null);
                    //mapMCFlr0.addPoi(poiMCFlr00);
                    //Poi poiMCFlr01 = Poi.create("user", new Position(10,44), 0, "5", "south", "type", "fax", "lable","class", "data/images/map-pin.jpeg" , null, null);
                    //mapMCFlr0.addPoi(poiMCFlr01);

                    // pass the buildings collection to the model
                    HashMap<String, Building> buildings = new HashMap<String, Building>();
                    buildings.put(bldMC.getName(), bldMC);
                    buildings.put(bldHSB.getName(), bldHSB);
                    buildings.put(bldWSC.getName(), bldWSC);

                    // Create the model
                    single_instance = new Model(users, buildings,  null, mapper, modelFile);
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }   
            
        }
        return single_instance;
    }
    
}

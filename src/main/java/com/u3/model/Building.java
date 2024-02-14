package com.u3.model; // package 
import java.util.ArrayList; // ArrayList class

import com.fasterxml.jackson.annotation.JsonIgnore; // required to ignore fields when serializing
import com.fasterxml.jackson.databind.*; // required to serialize objects

// lombok allows getters, setters and constructors to be automatically created by annotation
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Building class that represents a building
 *
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC) // creates a no argument constructor required by jackson
@AllArgsConstructor(access = AccessLevel.PUBLIC) // creates an all argument constructor required by jackson
public class Building implements IPrintable {

    // lombok automatically creates getters and setters for these fields based on annotations
    private @Setter @Getter String code;
    private @Setter @Getter String name;
    private @Setter @Getter ArrayList<FloorMap> floorMaps;
    private @Setter @Getter @JsonIgnore ObjectMapper mapper;


    /**
     * Factory static mehtod that creates a new building with the given code, name, and list of floor maps
     * @param code
     * @param name
     * @param floorMaps
     * @return
     */
    public static Building create(String code, String name, ArrayList<FloorMap> floorMaps) {    
        return new Building(code, name, floorMaps, new ObjectMapper());
    }


    /**
     * Returns the building object to a string in json format
     * @return json string
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
     * Returns all floormaps in the building
     * @return arraylist of floor maps
     *
     */
    @JsonIgnore
    public ArrayList<String> getFloors() {
        ArrayList<String> output = new ArrayList<String>();
        for(FloorMap fm : getFloorMaps()) {
            output.add(fm.getName());
        }
        return output; 
    }

    /**
     * Returns all floormap names in the building
     * @return array of floor map names
     */
    @JsonIgnore
    public String [] getFloorsArray() {
        ArrayList<String> output = new ArrayList<String>();
        for(FloorMap fm : getFloorMaps()) {
            output.add(fm.getName());
        }
        return output.toArray(new String[0]); 
    }

    /**
     * Returns the floor map for the given floor
     * @param floor
     * @return
     */
    @JsonIgnore
    public FloorMap getFloorMap(String floor) {
        for(FloorMap fm : getFloorMaps()) {
            if(fm.getName().equals(floor)) {
                return fm;
            }
        }
        return null;
    }

    // returns the floor map for the given index
    @JsonIgnore
    public FloorMap get(int index) {
        return getFloorMaps().get(index);
    }

} 
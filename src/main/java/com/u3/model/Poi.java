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
 * Poi class that represents a point of interest
 * 
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC) // creates a no argument constructor required by jackson
@AllArgsConstructor(access = AccessLevel.PUBLIC) // creates an all argument constructor required by jackson
public class Poi implements IPrintable{
    
    // lombok automatically creates getters and setters for these fields based on annotations
    private @Setter @Getter String owner;
    private @Setter @Getter Position pos;
    private @Setter @Getter int favCount;
    private @Setter @Getter String roomNum;
    private @Setter @Getter String locDesc;
    private @Setter @Getter String type;
    private @Setter @Getter String fax;
    private @Setter @Getter String label;
    private @Setter @Getter String classification;
    private @Setter @Getter String filePath;
    private @Setter @Getter ArrayList<String> layers;
    private @Setter @Getter ArrayList<String> tags;
    private @Setter @Getter @JsonIgnore ObjectMapper mapper;

    /**
     * Factory static method that creates a new poi with the given owner, position, favorite count, room number, location description, 
     * type, fax, label, classification, filepath, layers, and tags
     * 
     * @param owner
     * @param pos
     * @param favCount
     * @param roomNum
     * @param locDesc
     * @param type
     * @param fax
     * @param label
     * @param classification
     * @param filePath
     * @param layers
     * @param tags
     * @return poi
     */
    public static Poi create(String owner, Position pos, int favCount, String roomNum, String locDesc, String type, String fax, String label, String classification, String filePath, ArrayList<String> layers, ArrayList<String> tags) {
        return new Poi(owner, pos, favCount, roomNum, locDesc, type, fax, label, classification, filePath, layers, tags, new ObjectMapper());
    }

    /**
     * Returns the poi object ot a string in json format
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
     * Adds a tag to the poi
     * @param tag tag to add
     */
    @JsonIgnore
    public void addTag(String tag) {
        if (tags == null) {
            tags = new ArrayList<String>();
        }
        tags.add(tag);
    }

    /**
     * Adds a layername to the pois
     * @param layer
     */
    @JsonIgnore
    public void addLayer(String layername) {
        if (layers == null) {
            layers = new ArrayList<String>();
        }
        for (String l : layers) {
            if(l.equals(layername)) {
                return;
            }
        } 
        layers.add(layername);
    }

    @JsonIgnore
    public void removeLayer(String layername) {
        if (layers == null) {
            layers = new ArrayList<String>();
        }
        for (String l : layers) {
            if(l.equals(layername)) {
                layers.remove(l);
                return;
            }
        } 
    }

    /**
     *  Adds to the favCount
     *  @return the current favCount after incrementing
     */
    @JsonIgnore
    public int addFavCount() {
        return ++favCount;
    }


    /**
     *  Remove to the favCount
     *  @return the current favCount after incrementing
     */
    @JsonIgnore
    public int removeFavCount() {
        return --favCount;
    }
    
}

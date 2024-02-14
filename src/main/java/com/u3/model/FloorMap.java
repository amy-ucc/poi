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
 * FloorMap class that represents a floor map
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC) // creates a no argument constructor required by jackson
@AllArgsConstructor(access = AccessLevel.PUBLIC) // creates an all argument constructor required by jackson
public class FloorMap implements IPrintable {

    // lombok automatically creates getters and setters for these fields based on annotations
    private @Setter @Getter String name; 
    private @Setter @Getter String filePath;
    private @Setter @Getter ArrayList<Poi> pois;
    private @Setter @Getter @JsonIgnore ObjectMapper mapper;

    /**
     * Factory static mehtod that creates a new floor map with the given name, and list of pois filepath
     * @param name
     * @param filePath
     * @param pois
     * @return
     */
    public static FloorMap create(String name, String filePath, ArrayList<Poi> pois) {
        return new FloorMap(name, filePath, pois, new ObjectMapper());
    }

    /**
     * Returns the floor map object to a string in json format
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

    // Methods that return pois in the list
    /**
     * Returns the poi at a given position
     * @param x x position
     * @param y 
     * @return poi     
     */
    @JsonIgnore
    public Poi getPoiAtPos(int x, int y) {
        Poi output = null;
        for(Poi p : getPois()) {
            if(p.getPos().getXPos() == x && p.getPos().getYPos() == y) {
                output = p;
            }
        }
        return output;
    }

    /**
     * Returns the poi at a given index
     * @param index the index
     * @return poi at the givem index
     */
    @JsonIgnore
    Poi getPoiAtIndex(int index) {
        return pois.get(index);
    }

    /**
     * @param x1 upper left x
     * @param y1 upper left y
     * @param x2 lower right x
     * @param y2 lower right y
     * @return ArrayList of pois within the given rectangle
     */
    @JsonIgnore
    public ArrayList<Poi> getPoisWithinRect(int x1, int y1, int x2, int y2) {
        ArrayList<Poi> output = new ArrayList<Poi>();
        for(Poi p : getPois()) {
            if(p.getPos().getXPos() >= x1 && p.getPos().getXPos() <= x2 && p.getPos().getYPos() >= y1 && p.getPos().getYPos() <= y2) {
                output.add(p);
            }
        }
        return output;
    }

    /**
     * Returns all pois in the list with a given layer
     * @param layername layer name
     * @return ArrayList of pois
     */
    @JsonIgnore
    public ArrayList<Poi> getPoiLayer(String layername) {
        ArrayList<Poi> output = new ArrayList<Poi>();
        for(Poi p : getPois()) {
            if (p.getLayers() != null) {
                for (String layer : p.getLayers()) {
                    if(layer.equals(name)) {
                        output.add(p);
                    }
                }
            }
            
        }
        return output;
    }

    /**
     * Returns all pois in the list that have at least a count of one for favCount
     * @return ArrayList of pois
     */
    public ArrayList<Poi> getAllFavPois() {
        ArrayList<Poi> output = new ArrayList<Poi>();
        for(Poi p : getPois()) {
            if( p.getFavCount()>0 ) {
                output.add(p);
            }
        }
        return output;
    }


    ///////////////// Methods that modify the pois list
    /**
     * adds a poi to the pois list
     * @param poi poi to be saved
     */
    @JsonIgnore
    public void addPoi(Poi poi) {
        if (pois == null) {
            pois = new ArrayList<Poi>();
        }
        pois.add(poi);
    }

    /**
     * Edits a poi at the given position
     * @param x x position of poi
     * @param y y position of poi
     * @param poi poi to be edited
     */
    @JsonIgnore
    public void savePoiAtPos(int x, int y, Poi poi) {
        
        // security check to make sure it only a owner that can edit a poi
        // only the owner can edit the poi
        if(Model.get().getCurrUser().getUserid().equals(poi.getOwner())) {
            
            int index = getIndexOfPoiAtPos(x, y);
            if(index != -1) {
                pois.set(index, poi);
            } else {
                pois.add(poi);
            }
        }

    }


    ////////////////// Private Helper methods
    /**
     * returns the index of the poi at the given position
     * returns -1 if no poi is found
     * @param x x position of poi
     * @param y y position of poi
     * @return index of poi at position or -1 if no poi is found
     */
    @JsonIgnore 
    private int getIndexOfPoiAtPos(int x, int y) {
        int output = -1;
        for(int i = 0; i < pois.size(); i++) {
            if(pois.get(i).getPos().getXPos() == x && pois.get(i).getPos().getYPos() == y) {
                output = i;
            }
        }
        return output;
    }

}

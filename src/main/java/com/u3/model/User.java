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
 * User class that represents a user
 *
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC) // lombok creates a no argument constructor required by jackson
@AllArgsConstructor(access = AccessLevel.PUBLIC) // lombok creates an all argument constructor required by jackson
public class User implements IPrintable {

    private @Setter @Getter String type; // getType(), setType() created by lombok
    private @Setter @Getter String userid; // getFirstName(), setFirstName() created by lombok
    private @Setter @Getter String password; // getPassword(), setPassword() created by lombok
    private @Setter @Getter String alias; // getAlias(), setAlias(); created by lombok
    private @Setter @Getter ArrayList<Poi> favs; // getFavs(), setFavs() created by lombok
    private @Setter @Getter @JsonIgnore ObjectMapper mapper; // getMapper(), setMapper() created by lombok

    /**
     * Factory static method that creates a new user with the given type, userid, password, alias, and favs
     * @param type
     * @param userid
     * @param password
     * @param alias
     * @param favs
     * @return user
     */
    public static User create(String type, String userid, String password, String alias, ArrayList<Poi> favs) {
        return new User(type, userid, password, alias, favs, new ObjectMapper());
    }

    /**
     * Returns the user object to a string
     * @return string
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
     * Adds a poi to the user's list of favourites
     * @param poi
     */
    @JsonIgnore
    public void addFav(Poi poi) {
        if(poi.getFavCount() <= 0) {
            poi.addFavCount();
            favs.add(poi);
        }
    }

      /**
     * Adds a poi to the user's list of favourites
     * @param poi
     */
    @JsonIgnore
    public void removeFav(Poi poi) {
        if(poi.getFavCount() > 0) {
            poi.removeFavCount();
            favs.remove(poi);
        }
    }

}




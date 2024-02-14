package com.u3.model; // package 

// lombok allows getters, setters and constructors to be automatically created by annotation
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Position class that represents a position
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC) // lombok creates a no argument constructor required by jackson
@AllArgsConstructor(access = AccessLevel.PUBLIC) // lombok  creates an all argument constructor required by jackson
public class Position implements IPrintable {

    // lombok automatically creates getters and setters for these fields based on annotations
    private @Getter @Setter int xPos;
    private @Getter @Setter int yPos;

    /**
     * Returns the position object to a string
     * @return string
     */
    @Override
    public String toString() {
        return "Position [xPos=" + xPos + ", yPos=" + yPos + "]";
    }

}
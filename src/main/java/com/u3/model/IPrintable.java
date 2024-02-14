package com.u3.model;

/**
 * Interface for printing objects
 */
interface IPrintable {
    
    /**
     * Prints out the object to the console
     * Provides a default implementation
     * @return void
     */
    public default void printOut() {
        System.out.println(this.toString());
    }

}

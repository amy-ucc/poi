package com.u3; // package

import java.io.File; // required for file handling
import java.util.ArrayList; // ArrayList

import com.u3.frontend.User_Interface; // User Interface class
import com.u3.frontend.Login_Page; // Login Page class
import com.u3.model.*; // Model and all its classes

/**
 * Class that starts the application
 *
 */
public class App 
{

    /**
     * Main method that starts the application
     * @param args
     */
    public static void main( String[] args )
    {
        // make data directory if it doesn't exist
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir(); 
        }

        File floorMapDir = new File("data/floormaps");
        if (!floorMapDir.exists()) {
            floorMapDir.mkdir();
        }

    
        Model model = Model.get();
        model.printOut();
        // User usr = model.login("user", "user_password");
        // if (usr != null) {
        //     System.out.println("Logged in as " + usr.getUserid());
        // } else {
        //     System.out.println("Login failed");
        // }

        // usr = model.getCurrUser();

        ArrayList<Building> blds = model.getBuildingsList();
        Building bld = model.getBuilding("Middlesex College");
        ArrayList<User> users = model.getUsersList();
        String [] bldNames = model.getBuildingsArray();
        FloorMap fm = bld.getFloorMap("Ground Floor");

        //model.serialize();

        // edit
        // Poi p = fm.getPoiAtPos(3,4);
        // p.setLabel("edited label");
        // p.setClassification("edited classification");
        // p.addLayer("Bathroom");
        // //fm.savePoiAtPos(3,4,p);
        // ArrayList<Poi> pois = fm.getPoiLayer("Bathroom");
        
        System.out.println("Users size: " + users.size());
        System.out.println("Buildings size: " + blds.size());
        System.out.println("Buildings length: " + bldNames.length);
        //System.out.println("POIs size: " + pois.size());
        
        model.serialize();

        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         new User_Interface(model).setVisible(true);
        //     }
        // });

        new Login_Page(model).setVisible(true);
        
        System.out.println("We are on the other side of the login user interface");
       
    }
}

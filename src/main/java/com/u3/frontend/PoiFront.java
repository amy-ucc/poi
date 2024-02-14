/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u3.frontend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.u3.model.FloorMap;
import com.u3.model.Model;
import com.u3.model.Building;
import com.u3.model.Poi;
import com.u3.model.Position;

/**
 *
 * @author Otis Ding
 */
public class PoiFront {
    
    public JLabel point;
    private String desc;
    private int xCoord;
    private int yCoord;
    private BufferedImage pinPicture;
    private Poi Poi;
    private FloorMap floormap;
    private String building;
    private String floor;
    private Model model;
    
    public PoiFront(Poi Poi, String building, String floor, Model model){
        
        
        Building bld = model.getBuilding(building);
        FloorMap floormap = bld.getFloorMap(floor);
        this.building = building;
        this.floor = floor;
        
        
        this.desc = Poi.getLocDesc();
        this.xCoord = Poi.getPos().getXPos();
        this.yCoord = Poi.getPos().getYPos();
        this.Poi = Poi;
        this.model = model;
        try{
            pinPicture = ImageIO.read(new File("data/images/map-pin.jpeg"));  //For getting the image that represents the POI
        } catch(IOException ex){
            System.out.println("IOException");
        }
        point = new JLabel(new ImageIcon(pinPicture));
        point.setSize(20,20);
        point.setLocation(this.xCoord, this.yCoord);
        point.setText("POI");
        
        point.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pointMouseClicked(evt);
            }
        });
    }
    
    
    
    public void setDescription(String description){
        this.desc = description;
    }
    
    public void setVisible(boolean state){
        point.setVisible(state);
    }
    
    public JLabel getLabel(){
        return point;
    }
    
    public Poi getPoi(){
        return this.Poi;
    }
    
    private void pointMouseClicked(java.awt.event.MouseEvent evt){
        JFrame pop = new popup(this.Poi, this.building, this.floor, model, point);
        pop.setVisible(true);
        pop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    
}

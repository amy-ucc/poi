package com.u3.frontend;
import java.util.ArrayList;

import com.u3.model.*;


/**
 *
 * @author sadiy
 */
public class EditLayers_Popup extends javax.swing.JFrame {

    private Model model;
    private Poi Poi;

    /**
     * Creates new form EditLayers_Popup
     */
    public EditLayers_Popup(Poi Poi, Model model) {
        this.model = model; 
        this.Poi = Poi;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Layer_Panel = new javax.swing.JPanel();
        Entry_Points_CheckBox = new javax.swing.JCheckBox();
        Exit_Points_CheckBox = new javax.swing.JCheckBox();
        Stairwells_CheckBox = new javax.swing.JCheckBox();
        Elevators_CheckBox = new javax.swing.JCheckBox();
        Layers_Label = new javax.swing.JLabel();
        UCPOI_CheckBox = new javax.swing.JCheckBox();
        Classrooms_CheckBox = new javax.swing.JCheckBox();
        Labs_CheckBox = new javax.swing.JCheckBox();
        CSpaces_CheckBox = new javax.swing.JCheckBox();
        FavPOI_CheckBox = new javax.swing.JCheckBox();
        Restaurants_CheckBox = new javax.swing.JCheckBox();
        POILayer_Button = new javax.swing.JButton();

        ArrayList<String> layersList = new ArrayList<>();
        layersList = this.Poi.getLayers();
        
        if ( layersList != null ) {
            for (String layer : layersList) {
                if (layer.equals("Entry")) {
                    Entry_Points_CheckBox.setSelected(true);
                } else if (layer.equals("Exit")) {
                    Exit_Points_CheckBox.setSelected(true);
                } else if (layer.equals("Stairwells")) {
                    Stairwells_CheckBox.setSelected(true);
                } else if (layer.equals("Elevators")) {
                    Elevators_CheckBox.setSelected(true);
                } else if (layer.equals("UCPOI")) {
                    UCPOI_CheckBox.setSelected(true);
                } else if (layer.equals("Classrooms")) {
                    Classrooms_CheckBox.setSelected(true);
                } else if (layer.equals("Labs")) {
                    Labs_CheckBox.setSelected(true);
                } else if (layer.equals("CSpaces")) {
                    CSpaces_CheckBox.setSelected(true);
                } else if (layer.equals("Fav")) {
                    FavPOI_CheckBox.setSelected(true);
                } else if (layer.equals("Restaurants")) {
                    Restaurants_CheckBox.setSelected(true);
                }
            }
        }


            
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Layer_Panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Entry_Points_CheckBox.setText("Entry Points");
        Entry_Points_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Exit_Points_CheckBox.setText("Exit Points");
        Exit_Points_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Stairwells_CheckBox.setText("Stairwells");
        Stairwells_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Elevators_CheckBox.setText("Elevators");
        Elevators_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Layers_Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Layers_Label.setText("Layers");

        UCPOI_CheckBox.setText("User Created POIs");
        UCPOI_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Classrooms_CheckBox.setText("Classrooms");
        Classrooms_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Labs_CheckBox.setText("Labs");
        Labs_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        CSpaces_CheckBox.setText("Collaborative Spaces");
        CSpaces_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        FavPOI_CheckBox.setText("Favourite POIs");
        FavPOI_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        Restaurants_CheckBox.setText("Restaurants");
        Restaurants_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });

        POILayer_Button.setText("Apply Layers");
        POILayer_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POILayer_ButtonActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout Layer_PanelLayout = new javax.swing.GroupLayout(Layer_Panel);
        Layer_Panel.setLayout(Layer_PanelLayout);
        Layer_PanelLayout.setHorizontalGroup(
            Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layer_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Layer_PanelLayout.createSequentialGroup()
                        .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Exit_Points_CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Stairwells_CheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Elevators_CheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Entry_Points_CheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FavPOI_CheckBox)
                            .addGroup(Layer_PanelLayout.createSequentialGroup()
                                .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Classrooms_CheckBox)
                                    .addComponent(Labs_CheckBox)
                                    .addComponent(UCPOI_CheckBox))
                                .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Layer_PanelLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CSpaces_CheckBox)
                                            .addComponent(Restaurants_CheckBox)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Layer_PanelLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(POILayer_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(Layers_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        Layer_PanelLayout.setVerticalGroup(
            Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layer_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Layers_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Layer_PanelLayout.createSequentialGroup()
                        .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Layer_PanelLayout.createSequentialGroup()
                                .addComponent(Entry_Points_CheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Exit_Points_CheckBox))
                            .addGroup(Layer_PanelLayout.createSequentialGroup()
                                .addComponent(Restaurants_CheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CSpaces_CheckBox)))
                        .addGroup(Layer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Layer_PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Stairwells_CheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Elevators_CheckBox))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Layer_PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(POILayer_Button))))
                    .addGroup(Layer_PanelLayout.createSequentialGroup()
                        .addComponent(Classrooms_CheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Labs_CheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FavPOI_CheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UCPOI_CheckBox)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Layer_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Layer_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    //@Override
    public void POILayer_ButtonActionPerformed(java.awt.event.ActionEvent evt) {

        if (evt.getSource() == Entry_Points_CheckBox) {
            if (Entry_Points_CheckBox.isSelected()) {
                this.Poi.addLayer("Entry");
            } else {
                this.Poi.removeLayer("Entry");
            }

        } else if (evt.getSource() == Exit_Points_CheckBox) {
            if (Exit_Points_CheckBox.isSelected()) {
                this.Poi.addLayer("Exit");
            } else {
                this.Poi.removeLayer("Exit");
            }

        } else if (evt.getSource() == Stairwells_CheckBox) {
            if (Stairwells_CheckBox.isSelected()) {
                this.Poi.addLayer("Stairwells");
            } else {
                this.Poi.removeLayer("Stairwells");
            }


        } else if (evt.getSource() == Elevators_CheckBox) {
            if (Elevators_CheckBox.isSelected()) {
                this.Poi.addLayer("Elevators");
            } else {
                this.Poi.removeLayer("Elevators");
            }


        } else if (evt.getSource() == Labs_CheckBox) {
            if (Labs_CheckBox.isSelected()) {
                this.Poi.addLayer("Labs");
            } else {
                this.Poi.removeLayer("Labs");
            }


        } else if (evt.getSource() == CSpaces_CheckBox) {
            if (CSpaces_CheckBox.isSelected()) {
                this.Poi.addLayer("CSpaces");
            } else {
                this.Poi.removeLayer("CSpaces");
            }


        } else if (evt.getSource() == Classrooms_CheckBox) {
            if (Classrooms_CheckBox.isSelected()) {
                this.Poi.addLayer("Classrooms");
            } else {
                this.Poi.removeLayer("Classrooms");
            }


        } else if (evt.getSource() == FavPOI_CheckBox) {
            if (FavPOI_CheckBox.isSelected()) {
                this.Poi.addLayer("Fav");
            } else {
                this.Poi.removeLayer("Fav");
            }


        } else if (evt.getSource() == UCPOI_CheckBox) {
            if (UCPOI_CheckBox.isSelected()) {
                this.Poi.addLayer("UCPOI");
            } else {
                this.Poi.removeLayer("UCPOI");
            }


        } else if (evt.getSource() == Restaurants_CheckBox) {
            if (Restaurants_CheckBox.isSelected()) {
                this.Poi.addLayer("Restaurants");
            } else {
                this.Poi.removeLayer("Restaurants");
            }

        } 
        
        model.serialize();
        // if (evt.getSource() == POILayer_Button) {
        //     model.serialize(); 
        // }
    }








    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditLayers_Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditLayers_Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditLayers_Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditLayers_Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EditLayers_Popup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CSpaces_CheckBox;
    private javax.swing.JCheckBox Classrooms_CheckBox;
    private javax.swing.JCheckBox Elevators_CheckBox;
    private javax.swing.JCheckBox Entry_Points_CheckBox;
    private javax.swing.JCheckBox Exit_Points_CheckBox;
    private javax.swing.JCheckBox FavPOI_CheckBox;
    private javax.swing.JCheckBox Labs_CheckBox;
    private javax.swing.JPanel Layer_Panel;
    private javax.swing.JLabel Layers_Label;
    private javax.swing.JButton POILayer_Button;
    private javax.swing.JCheckBox Restaurants_CheckBox;
    private javax.swing.JCheckBox Stairwells_CheckBox;
    private javax.swing.JCheckBox UCPOI_CheckBox;
    // End of variables declaration//GEN-END:variables
}

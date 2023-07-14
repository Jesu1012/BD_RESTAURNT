/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package xyz.companyrestaurant.bd_restaurant.Vista.VistaComponente;

import xyz.companyrestaurant.bd_restaurant.Global.SharedElementClass;

/**
 *
 * @author MI PC
 */
public class Bar_CRUD extends javax.swing.JPanel {

    /**
     * Creates new form CRUD
     */
    public Bar_CRUD() {
        initComponents();
        setBackground(SharedElementClass.FondoTitulo);
    }
    public int getRbSelected(){
        int R=0;
        if(rbCreate.isSelected()) R=1;
        else if(rbRead.isSelected()) R=2;
        else if(rbUpdate.isSelected()) R=3;
        else if(rbDelete.isSelected()) R=4;
        return R;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbCreate = new javax.swing.JRadioButton();
        rbRead = new javax.swing.JRadioButton();
        rbUpdate = new javax.swing.JRadioButton();
        rbDelete = new javax.swing.JRadioButton();

        rbCreate.setText("CREATE");

        rbRead.setText("READ");

        rbUpdate.setText("UPDATE");

        rbDelete.setText("DELETE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCreate)
                .addGap(18, 18, 18)
                .addComponent(rbRead)
                .addGap(18, 18, 18)
                .addComponent(rbUpdate)
                .addGap(18, 18, 18)
                .addComponent(rbDelete)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCreate)
                    .addComponent(rbRead)
                    .addComponent(rbUpdate)
                    .addComponent(rbDelete))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton rbCreate;
    private javax.swing.JRadioButton rbDelete;
    private javax.swing.JRadioButton rbRead;
    private javax.swing.JRadioButton rbUpdate;
    // End of variables declaration//GEN-END:variables
}

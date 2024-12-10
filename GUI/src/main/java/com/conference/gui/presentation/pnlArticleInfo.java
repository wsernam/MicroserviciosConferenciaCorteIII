/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.conference.gui.presentation;

import com.conference.gui.entities.Articulo;
import com.conference.gui.entities.Conference;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Ashlee Campaz
 */
public class pnlArticleInfo extends javax.swing.JPanel {

    /**
     * Creates new form pnlConferenceInfo
     */
    private Articulo article;
    public pnlArticleInfo(Articulo a) {
        this.article = a;
        initComponents();
        lbInfoArticulo.setText(a.getNombre());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlBtnVerMas = new javax.swing.JPanel();
        lbVerMas = new javax.swing.JLabel();
        pnlInfoConferencia = new javax.swing.JPanel();
        lbInfoArticulo = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        pnlBtnVerMas.setBackground(new java.awt.Color(255, 255, 255));
        pnlBtnVerMas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBtnVerMas.setLayout(new java.awt.BorderLayout());

        lbVerMas.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        lbVerMas.setForeground(new java.awt.Color(0, 51, 204));
        lbVerMas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVerMas.setText("Ver más");
        lbVerMas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVerMasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbVerMasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbVerMasMouseExited(evt);
            }
        });
        pnlBtnVerMas.add(lbVerMas, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(pnlBtnVerMas, gridBagConstraints);

        pnlInfoConferencia.setLayout(new java.awt.BorderLayout());

        lbInfoArticulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lbInfoArticulo.setText("Nombre articulo");
        pnlInfoConferencia.add(lbInfoArticulo, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 465;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(pnlInfoConferencia, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lbVerMasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVerMasMouseEntered
        lbVerMas.setFont(new java.awt.Font("Segoe UI Historic", 1, 12));
    }//GEN-LAST:event_lbVerMasMouseEntered

    private void lbVerMasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVerMasMouseExited
       lbVerMas.setFont(new java.awt.Font("Segoe UI Historic", 0, 12));
    }//GEN-LAST:event_lbVerMasMouseExited

    private void lbVerMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVerMasMouseClicked
        JInternalFrame interfalFrame = getDesktopPaneParent(this);
        if(interfalFrame!=null){
            GUImisArticulos guimisarticulos = (GUImisArticulos) interfalFrame;
            
        }
    }//GEN-LAST:event_lbVerMasMouseClicked

    private JInternalFrame getDesktopPaneParent(pnlArticleInfo pc){
        Container parent = pc.getParent(); 
        while (parent != null) {
            if (parent instanceof JInternalFrame) {
                return (JInternalFrame) parent;
            }
            parent = parent.getParent();
        }
        return null; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbInfoArticulo;
    private javax.swing.JLabel lbVerMas;
    private javax.swing.JPanel pnlBtnVerMas;
    private javax.swing.JPanel pnlInfoConferencia;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.conference.gui.presentation;

import com.conference.gui.article.Article;
import com.conference.gui.clients.IRestArticle;
import com.conference.gui.entities.Articulo;
import com.conference.gui.presentation.infra.Observer;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public class GUImisArticulos extends javax.swing.JInternalFrame implements Observer {

    /**
     * Creates new form GUImisArticulos
     */
    
    private IRestArticle articleClient;
    private List<Articulo> articulos; 
    
    public GUImisArticulos() {
        initComponents();
    }
    
    public GUImisArticulos(IRestArticle articleClient) {
        this.articleClient = articleClient;
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
        java.awt.GridBagConstraints gridBagConstraints;

        lbMisArticulos = new javax.swing.JLabel();
        scrlpArticulos = new javax.swing.JScrollPane();
        pnlArticulos = new javax.swing.JPanel();
        pnlInfoArticulo = new javax.swing.JPanel();
        lbInfoArticulo = new javax.swing.JLabel();
        lbtitulo = new javax.swing.JLabel();
        lbResumen = new javax.swing.JLabel();
        lbPalabrasClave = new javax.swing.JLabel();
        lbResumentext = new javax.swing.JLabel();

        setBorder(null);
        setFrameIcon(null);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lbMisArticulos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        lbMisArticulos.setText("Mis articulos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 49, 0, 0);
        getContentPane().add(lbMisArticulos, gridBagConstraints);

        pnlArticulos.setLayout(new javax.swing.BoxLayout(pnlArticulos, javax.swing.BoxLayout.Y_AXIS));
        scrlpArticulos.setViewportView(pnlArticulos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 339;
        gridBagConstraints.ipady = 326;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(26, 49, 10, 0);
        getContentPane().add(scrlpArticulos, gridBagConstraints);

        pnlInfoArticulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlInfoArticulo.setForeground(new java.awt.Color(102, 102, 102));
        pnlInfoArticulo.setLayout(new java.awt.GridBagLayout());

        lbInfoArticulo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        lbInfoArticulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInfoArticulo.setText("Informacion Articulo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 29, 0, 134);
        pnlInfoArticulo.add(lbInfoArticulo, gridBagConstraints);

        lbtitulo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbtitulo.setText("Titulo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 28, 0, 0);
        pnlInfoArticulo.add(lbtitulo, gridBagConstraints);

        lbResumen.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbResumen.setText("Resumen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 28, 0, 0);
        pnlInfoArticulo.add(lbResumen, gridBagConstraints);

        lbPalabrasClave.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbPalabrasClave.setText("Palabras claves:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(73, 28, 51, 0);
        pnlInfoArticulo.add(lbPalabrasClave, gridBagConstraints);

        lbResumentext.setText("resumen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 28, 0, 0);
        pnlInfoArticulo.add(lbResumentext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 34, 0, 29);
        getContentPane().add(pnlInfoArticulo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void update(Object o) {
        
    }
    
    public void buildResultPanels(){
        
        for(Articulo a: articulos){
            pnlArticleInfo infoArticulo = new pnlArticleInfo(a); 
            pnlArticulos.add(infoArticulo);
        }
        pnlArticulos.revalidate();
        pnlArticulos.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbInfoArticulo;
    private javax.swing.JLabel lbMisArticulos;
    private javax.swing.JLabel lbPalabrasClave;
    private javax.swing.JLabel lbResumen;
    private javax.swing.JLabel lbResumentext;
    private javax.swing.JLabel lbtitulo;
    private javax.swing.JPanel pnlArticulos;
    private javax.swing.JPanel pnlInfoArticulo;
    private javax.swing.JScrollPane scrlpArticulos;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.conference.gui.presentation;

import com.conference.gui.entities.Conferencia;

/**
 *
 * @author Ashlee Campaz
 */
public class GUIconferenceChair extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIconferenceChair
     */
    private Conferencia conference;
    public GUIconferenceChair(Conferencia c) {
        this.conference = c;
        initComponents();
        setLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void setLabels(){
        //TODO implementacion
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbGestionConferencia = new javax.swing.JLabel();
        lbConferenceName = new javax.swing.JLabel();
        pnlBtnMatchingManual = new javax.swing.JPanel();
        lbMatchingManual = new javax.swing.JLabel();
        pnlInfoArticulos = new javax.swing.JPanel();
        lbNumArtEnviados = new javax.swing.JLabel();
        lbNumArtEvaluados = new javax.swing.JLabel();
        lbNumArtAceptados = new javax.swing.JLabel();
        lbNumArtRechazados = new javax.swing.JLabel();
        lbCalMinima = new javax.swing.JLabel();
        pnlConferenceInfo = new javax.swing.JPanel();
        lbFechaInicio = new javax.swing.JLabel();
        lbFechaFin = new javax.swing.JLabel();
        lbFechaRepArt = new javax.swing.JLabel();
        lbFechaEvaluaciones = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbCiudad = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        pnlBtnMatchingAuto = new javax.swing.JPanel();
        lbMatchingAuto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(229, 229, 229));
        setBorder(null);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(873, 650));
        setPreferredSize(new java.awt.Dimension(873, 650));

        lbGestionConferencia.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lbGestionConferencia.setForeground(new java.awt.Color(102, 102, 102));
        lbGestionConferencia.setText("Gestion Conferencia");

        lbConferenceName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbConferenceName.setForeground(new java.awt.Color(102, 102, 102));
        lbConferenceName.setText("conference_name");

        pnlBtnMatchingManual.setBackground(new java.awt.Color(129, 218, 199));
        pnlBtnMatchingManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBtnMatchingManual.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlBtnMatchingManual.setPreferredSize(new java.awt.Dimension(226, 109));
        pnlBtnMatchingManual.setLayout(new java.awt.BorderLayout());

        lbMatchingManual.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbMatchingManual.setForeground(new java.awt.Color(255, 255, 255));
        lbMatchingManual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMatchingManual.setText("Proceso de Matching manual");
        lbMatchingManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMatchingManualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMatchingManualMouseExited(evt);
            }
        });
        pnlBtnMatchingManual.add(lbMatchingManual, java.awt.BorderLayout.CENTER);

        pnlInfoArticulos.setBackground(new java.awt.Color(255, 255, 255));

        lbNumArtEnviados.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbNumArtEnviados.setText("Numero articulos enviados: #/#");

        lbNumArtEvaluados.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbNumArtEvaluados.setText("Numero articulos evaluados: #/#");

        lbNumArtAceptados.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbNumArtAceptados.setText("Numero de articulos aceptados: #/#");

        lbNumArtRechazados.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbNumArtRechazados.setText("Numero de articulos rechazados: #/#");

        lbCalMinima.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbCalMinima.setText("Calificacion minima aceptable: #/#");

        javax.swing.GroupLayout pnlInfoArticulosLayout = new javax.swing.GroupLayout(pnlInfoArticulos);
        pnlInfoArticulos.setLayout(pnlInfoArticulosLayout);
        pnlInfoArticulosLayout.setHorizontalGroup(
            pnlInfoArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoArticulosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlInfoArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCalMinima)
                    .addComponent(lbNumArtRechazados)
                    .addComponent(lbNumArtAceptados)
                    .addComponent(lbNumArtEvaluados)
                    .addComponent(lbNumArtEnviados))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlInfoArticulosLayout.setVerticalGroup(
            pnlInfoArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoArticulosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbNumArtEnviados)
                .addGap(27, 27, 27)
                .addComponent(lbNumArtEvaluados)
                .addGap(18, 18, 18)
                .addComponent(lbNumArtAceptados)
                .addGap(18, 18, 18)
                .addComponent(lbNumArtRechazados)
                .addGap(18, 18, 18)
                .addComponent(lbCalMinima)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlConferenceInfo.setBackground(new java.awt.Color(255, 255, 255));

        lbFechaInicio.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbFechaInicio.setText("Inicio: DD/MM/AAAA");

        lbFechaFin.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbFechaFin.setText("Fin: DD/MM/AAAA");

        lbFechaRepArt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbFechaRepArt.setText("Recepcion de articulos hasta: DD/MM/AAAA");

        lbFechaEvaluaciones.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbFechaEvaluaciones.setText("Evaluaciones: DD/MM/AAAA");

        lbPais.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbPais.setText("Pais: ####");

        lbEstado.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbEstado.setText("Provincia/Estado: ####");

        lbCiudad.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbCiudad.setText("Cuidad: ####");

        lbDireccion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbDireccion.setText("Direccion: ####");
        lbDireccion.setToolTipText("");

        javax.swing.GroupLayout pnlConferenceInfoLayout = new javax.swing.GroupLayout(pnlConferenceInfo);
        pnlConferenceInfo.setLayout(pnlConferenceInfoLayout);
        pnlConferenceInfoLayout.setHorizontalGroup(
            pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConferenceInfoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFechaInicio)
                    .addComponent(lbFechaEvaluaciones)
                    .addComponent(lbFechaRepArt)
                    .addComponent(lbFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPais)
                    .addComponent(lbEstado)
                    .addComponent(lbCiudad)
                    .addComponent(lbDireccion))
                .addGap(52, 52, 52))
        );
        pnlConferenceInfoLayout.setVerticalGroup(
            pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConferenceInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaInicio)
                    .addComponent(lbPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaFin)
                    .addComponent(lbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaRepArt)
                    .addComponent(lbCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConferenceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaEvaluaciones)
                    .addComponent(lbDireccion))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlBtnMatchingAuto.setBackground(new java.awt.Color(129, 218, 199));
        pnlBtnMatchingAuto.setLayout(new java.awt.BorderLayout());

        lbMatchingAuto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbMatchingAuto.setForeground(new java.awt.Color(255, 255, 255));
        lbMatchingAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMatchingAuto.setText("Proceso de Matching automatico");
        lbMatchingAuto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMatchingAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMatchingAutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMatchingAutoMouseExited(evt);
            }
        });
        pnlBtnMatchingAuto.add(lbMatchingAuto, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGestionConferencia)
                    .addComponent(lbConferenceName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInfoArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlBtnMatchingAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlBtnMatchingManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnlConferenceInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbGestionConferencia)
                .addGap(34, 34, 34)
                .addComponent(lbConferenceName)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlBtnMatchingAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlBtnMatchingManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlInfoArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(pnlConferenceInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMatchingAutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMatchingAutoMouseEntered
        lbMatchingAuto.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbMatchingAutoMouseEntered

    private void lbMatchingAutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMatchingAutoMouseExited
       lbMatchingAuto.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbMatchingAutoMouseExited

    private void lbMatchingManualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMatchingManualMouseEntered
        lbMatchingManual.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbMatchingManualMouseEntered

    private void lbMatchingManualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMatchingManualMouseExited
       lbMatchingManual.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbMatchingManualMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCalMinima;
    private javax.swing.JLabel lbCiudad;
    private javax.swing.JLabel lbConferenceName;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbFechaEvaluaciones;
    private javax.swing.JLabel lbFechaFin;
    private javax.swing.JLabel lbFechaInicio;
    private javax.swing.JLabel lbFechaRepArt;
    private javax.swing.JLabel lbGestionConferencia;
    private javax.swing.JLabel lbMatchingAuto;
    private javax.swing.JLabel lbMatchingManual;
    private javax.swing.JLabel lbNumArtAceptados;
    private javax.swing.JLabel lbNumArtEnviados;
    private javax.swing.JLabel lbNumArtEvaluados;
    private javax.swing.JLabel lbNumArtRechazados;
    private javax.swing.JLabel lbPais;
    private javax.swing.JPanel pnlBtnMatchingAuto;
    private javax.swing.JPanel pnlBtnMatchingManual;
    private javax.swing.JPanel pnlConferenceInfo;
    private javax.swing.JPanel pnlInfoArticulos;
    // End of variables declaration//GEN-END:variables
}

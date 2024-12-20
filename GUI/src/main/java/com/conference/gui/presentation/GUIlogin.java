package com.conference.gui.presentation;

//import com.easyconference.access.Article.ArticleArrayListRepository;
import com.conference.gui.clients.IUserRestClient;
import com.conference.gui.clients.UserClient;
import com.conference.gui.entities.Login;
import com.conference.gui.entities.Usuario;
import com.conference.gui.entities.Usuario_Autorizado;
import com.conference.gui.presentation.infra.ApplicationContext;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
//import com.easyconference.access.Conference.IConferenceRepository;
//import com.easyconference.access.Article.IArticleRepository;
//import com.easyconference.access.Conference.ConferenceArrayListRepository;
//import com.easyconference.access.User.IUserRepository;
//import com.easyconference.access.User.UserArrayListRepository;

/**
 * Interfaz Login
 *
 * @author
 * @version 1.0
 * @since 2024
 */
public class GUIlogin extends javax.swing.JFrame {

    private IUserRestClient userclient;

    /**
     * Creates new form login
     *
     * @param userclient
     */
    public GUIlogin(IUserRestClient userclient) {
        initComponents();
        this.userclient = userclient;

    }

    /**
     * public GUIlogin() { initComponents();
    }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        lbEasyConference = new javax.swing.JLabel();
        pnlInicio = new javax.swing.JPanel();
        txtfCorreo = new javax.swing.JTextField();
        pswfContrasenia = new javax.swing.JPasswordField();
        lbInicio_sesion = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        lbbtnVizualizar = new javax.swing.JLabel();
        lbNotienesCuenta = new javax.swing.JLabel();
        lbCamposVacios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(408, 365));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setMaximumSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        pnlFondo.setMinimumSize(new java.awt.Dimension(400, 360));
        pnlFondo.setPreferredSize(new java.awt.Dimension(400, 320));

        pnlSuperior.setBackground(new java.awt.Color(0, 153, 153));
        pnlSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        lbEasyConference.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbEasyConference.setForeground(new java.awt.Color(255, 255, 255));
        lbEasyConference.setText("easyConference");
        pnlSuperior.add(lbEasyConference);

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        pnlInicio.setForeground(new java.awt.Color(0, 153, 204));
        pnlInicio.setPreferredSize(new Dimension(408,314));
        pnlInicio.setLayout(new java.awt.GridBagLayout());

        txtfCorreo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfCorreo.setForeground(new java.awt.Color(102, 102, 102));
        txtfCorreo.setText("Ingrese su correo");
        txtfCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo electronico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semilight", 0, 12))); // NOI18N
        txtfCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtfCorreoMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 70;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 2);
        pnlInicio.add(txtfCorreo, gridBagConstraints);

        pswfContrasenia.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        pswfContrasenia.setForeground(new java.awt.Color(102, 102, 102));
        pswfContrasenia.setText(".......");
        pswfContrasenia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semilight", 0, 12))); // NOI18N
        pswfContrasenia.setCaretColor(new java.awt.Color(102, 102, 102));
        pswfContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pswfContraseniaMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 70;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        pnlInicio.add(pswfContrasenia, gridBagConstraints);

        lbInicio_sesion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbInicio_sesion.setForeground(new java.awt.Color(0, 102, 102));
        lbInicio_sesion.setText("Inicio de sesion ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 12, 0);
        pnlInicio.add(lbInicio_sesion, gridBagConstraints);

        btnIngresar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 70;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 4, 5, 0);
        pnlInicio.add(btnIngresar, gridBagConstraints);

        lbbtnVizualizar.setText("visualizar");
        lbbtnVizualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbbtnVizualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbbtnVizualizarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 70;
        gridBagConstraints.gridy = 2;
        pnlInicio.add(lbbtnVizualizar, gridBagConstraints);

        lbNotienesCuenta.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbNotienesCuenta.setForeground(new java.awt.Color(0, 102, 102));
        lbNotienesCuenta.setText("¿No tienes cuenta?Da clic aquí");
        lbNotienesCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNotienesCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNotienesCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbNotienesCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbNotienesCuentaMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 70;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        pnlInicio.add(lbNotienesCuenta, gridBagConstraints);

        lbCamposVacios.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        lbCamposVacios.setForeground(new java.awt.Color(255, 51, 51));
        lbCamposVacios.setText("No debe haber campos vacios");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlInicio.add(lbCamposVacios, gridBagConstraints);
        lbCamposVacios.setVisible(false);

        SpringLayout centrador = new SpringLayout();
        centrador.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnlInicio, 0, SpringLayout.HORIZONTAL_CENTER, pnlFondo);
        centrador.putConstraint(SpringLayout.VERTICAL_CENTER, pnlInicio, 0, SpringLayout.VERTICAL_CENTER, pnlFondo);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        pnlFondo.setLayout(centrador);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbbtnVizualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbbtnVizualizarMouseClicked
        if (pswfContrasenia.getEchoChar() == 0) {
            pswfContrasenia.setEchoChar('•');
        } else {
            pswfContrasenia.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_lbbtnVizualizarMouseClicked

    private void lbNotienesCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNotienesCuentaMouseEntered
        lbNotienesCuenta.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbNotienesCuentaMouseEntered

    private void lbNotienesCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNotienesCuentaMouseExited
        lbNotienesCuenta.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbNotienesCuentaMouseExited

    private void lbNotienesCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNotienesCuentaMouseClicked
        GUIregister registro = new GUIregister(userclient);
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNotienesCuentaMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Usuario us = null;

        if (txtfCorreo.getText().isBlank() || String.valueOf(pswfContrasenia.getPassword()).isBlank()) {
            lbCamposVacios.setVisible(true);
            return;
        }

        try {
            us = userclient.login(txtfCorreo.getText(), new String(pswfContrasenia.getPassword()));
        } catch (Exception ex) {
            Logger.getLogger(GUIlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (us != null) {
            ApplicationContext.getInstance().setUsuarioLogueado(us);
            GUIcontainer container = new GUIcontainer();
            // Pasar Usuario, ConferenceService y ArticleService al constructor de GUIcontainer
            container.setUsuario(us);
            container.setVisible(true);
            cleanFields();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Contraseña y/o usuario incorrecto", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtfCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfCorreoMousePressed
        lbCamposVacios.setVisible(false);
        if (txtfCorreo.getText().equals("Ingrese su correo"))
            txtfCorreo.setText("");
    }//GEN-LAST:event_txtfCorreoMousePressed

    private void pswfContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pswfContraseniaMousePressed
        lbCamposVacios.setVisible(false);
        if (String.valueOf(pswfContrasenia.getPassword()).equals("......."))
            pswfContrasenia.setText("");
    }//GEN-LAST:event_pswfContraseniaMousePressed

    public void cleanFields() {
        pswfContrasenia.setText("");
        txtfCorreo.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lbCamposVacios;
    private javax.swing.JLabel lbEasyConference;
    private javax.swing.JLabel lbInicio_sesion;
    private javax.swing.JLabel lbNotienesCuenta;
    private javax.swing.JLabel lbbtnVizualizar;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPasswordField pswfContrasenia;
    private javax.swing.JTextField txtfCorreo;
    // End of variables declaration//GEN-END:variables
}

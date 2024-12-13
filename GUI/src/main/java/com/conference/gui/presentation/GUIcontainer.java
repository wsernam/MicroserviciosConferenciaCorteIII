
package com.conference.gui.presentation;


import com.conference.gui.clients.UserClient;
import com.conference.gui.entities.Articulo;
import com.conference.gui.entities.Conferencia;
import com.conference.gui.entities.Usuario;
import com.conference.gui.entities.Usuario_Autorizado;
import com.conference.gui.presentation.infra.ApplicationContext;
import com.conference.gui.presentation.infra.InternalFrameFactory;
import com.conference.gui.presentation.infra.RestClientManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Interfaz contenedora 
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */

public class GUIcontainer extends javax.swing.JFrame {

    private Usuario usuario;


    /**
     * Creates new form GUIcontainer
     * @param us
     */

    public GUIcontainer(Usuario us) {
        this.usuario = us;
        initComponents();
        RestClientManager.createClientManager(us);
        //listConferences("");//muestra todas las listas
        //listArticles();
    }
    
    public GUIcontainer(){
        initComponents();
         //listConferences("");
         //listArticles();
    }
       
    @SuppressWarnings("unchecked")
    // Método que se ejecuta cuando el usuario hace clic en "Listado de conferencias"
    /**
 public void listConferences(String searchText) {
    pnlListadoCon.removeAll();  // Limpiamos el contenido actual del panel de conferencias

    // Configuramos el layout del panel para mantener el título arriba
    pnlListadoCon.setLayout(new BorderLayout());

    // Añadimos nuevamente el título "Listado de conferencias" en la parte superior
    pnlListadoCon.add(lbListadoCon, BorderLayout.NORTH);

    // Obtenemos todas las conferencias desde el servicio
    List<Conference> conferences = objConference.getConferencias();

    // Filtramos la lista de conferencias si se proporciona un texto de búsqueda
    if (searchText != null && !searchText.isEmpty()) {
        conferences = conferences.stream()
            .filter(conference -> conference.getNombre().toLowerCase().contains(searchText.toLowerCase()))
            .collect(Collectors.toList());
    }

    // Creamos un panel para listar las conferencias con un BoxLayout para apilar verticalmente
    JPanel panelConferencias = new JPanel();
    panelConferencias.setLayout(new BoxLayout(panelConferencias, BoxLayout.Y_AXIS));  // Apilamos verticalmente los mini paneles

    // Verificamos si hay conferencias disponibles
    if (conferences.isEmpty()) {
        System.out.println("No hay conferencias");
    } else {
        for (Conference conference : conferences) {
            JPanel conferencePanel = new JPanel();  // Creamos un panel para cada conferencia
            conferencePanel.setLayout(new BorderLayout());  // Usamos BorderLayout para organizar componentes
            conferencePanel.setPreferredSize(new Dimension(277, 30));  // Ajustamos el tamaño del panel
            conferencePanel.setMaximumSize(new Dimension(277, 30));  // Evita que los paneles se estiren más allá de este tamaño

            // Etiquetas con la información de la conferencia
            JLabel nameLabel = new JLabel("Conferencia: " + conference.getNombre());  // Etiqueta con el nombre de la conferencia

            // Botón con el símbolo "+"
            JButton detallesButton = new JButton("+");
            detallesButton.setPreferredSize(new Dimension(45, 40));  // Ajustamos el tamaño del botón
            detallesButton.addActionListener(e -> {
                // Abre la ventana GUIcreateArticle para la conferencia seleccionada
                Article articleUsuario = new Article();
                GUIcreateArticle createArticleView = new GUIcreateArticle(articleUsuario, conference);  // Pasamos ArticleService y Conference al constructor

                // Añadimos GUIcreateArticle al JDesktopPane
                dskpaneContenedor.add(createArticleView);  // Agregamos la ventana al JDesktopPane

                // Configuramos el JInternalFrame para que se muestre correctamente
                createArticleView.setVisible(true);  // Hacemos visible el JInternalFrame
                try {
                    createArticleView.setMaximum(true);  // Lo maximizamos dentro del JDesktopPane (opcional)
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }
                // Actualizamos la lista de artículos después de abrir la ventana de creación de artículo
                listArticles();
            });

            // Añadimos las etiquetas de información en un sub-panel
            JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  // Usamos FlowLayout para alinear a la izquierda
            infoPanel.add(nameLabel);

            // Añadimos las etiquetas de información en el centro del mini panel
            conferencePanel.add(infoPanel, BorderLayout.CENTER);

            // Añadimos el botón "+" en el lado derecho del mini panel
            conferencePanel.add(detallesButton, BorderLayout.EAST);

            // Añadimos el mini panel al panel de conferencias
            panelConferencias.add(conferencePanel);

            // Añadimos un espacio entre los paneles para que no se vean juntos
            panelConferencias.add(Box.createRigidArea(new Dimension(0, 1)));
        }
    }

    // Ahora, ponemos el panelConferencias dentro de un JScrollPane para agregar scroll si es necesario
    JScrollPane scrollPane = new JScrollPane(panelConferencias);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // Barra de desplazamiento vertical cuando sea necesario
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Deshabilitar barra horizontal

    // Añadimos el JScrollPane al centro de pnlListadoCon
    pnlListadoCon.add(scrollPane, BorderLayout.CENTER);

    // Refrescamos y repintamos el panel para que los cambios se reflejen
    pnlListadoCon.revalidate();
    pnlListadoCon.repaint();

}

**/

/**
    // Método para listar los artículos del usuario
    @SuppressWarnings("unchecked")
   public void listArticles() {
    pnlListadoAr.removeAll(); // Limpiamos el contenido actual del panel de artículos
    pnlListadoAr.setLayout(new BorderLayout()); // Layout para mantener el título arriba

    // Panel para listar los artículos con un BoxLayout vertical
    JPanel panelArticulos = new JPanel();
    panelArticulos.setLayout(new BoxLayout(panelArticulos, BoxLayout.Y_AXIS));

    // Añadimos el título "Listado de artículos" en la parte superior
    pnlListadoAr.add(lbListadoAr, BorderLayout.NORTH);

    // Obtenemos todos los artículos desde el servicio
    List<Articulo> articulos = objArticle.getArticulos();

    // Verificamos si la lista de artículos está vacía
    if (articulos == null || articulos.isEmpty()) {
        System.out.println("No hay Articulos");
    } else {
        // Iteramos sobre cada artículo y creamos un mini panel para mostrar su información
        for (Articulo articulo : articulos) {
            JPanel articuloPanel = new JPanel(new BorderLayout()); // Panel para cada artículo
            articuloPanel.setPreferredSize(new Dimension(277, 30));
            articuloPanel.setMaximumSize(new Dimension(277, 30));

            // Etiqueta con el nombre del artículo
            JLabel nameLabel = new JLabel("Artículo: " + articulo.getNombre());
            articuloPanel.add(nameLabel, BorderLayout.CENTER);

            // Añadimos el mini panel al panel de artículos
            panelArticulos.add(articuloPanel);

            // Añadimos un espacio entre los paneles
            panelArticulos.add(Box.createRigidArea(new Dimension(0, 1)));
        }
    }

    // Ponemos el panelArticulos dentro de un JScrollPane
    JScrollPane scrollPane = new JScrollPane(panelArticulos);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // Añadimos el JScrollPane al centro de pnlListadoAr
    pnlListadoAr.add(scrollPane, BorderLayout.CENTER);

    // Refrescamos y repintamos el panel para que los cambios se reflejen
    pnlListadoAr.revalidate();
    pnlListadoAr.repaint();
}
*/
   public List<Conferencia> searchConferences(String searchText){
        List<Conferencia> conferences = RestClientManager.getConferenceClient().getConferences();
        // Filtramos la lista de conferencias si se proporciona un texto de búsqueda
        if (searchText != null && !searchText.isEmpty()) {
            conferences = conferences.stream()
                .filter(conference -> conference.getNombre().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
        }
        return conferences;
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

        pnlFondo = new javax.swing.JPanel();
        dskpaneContenedor = new javax.swing.JDesktopPane();
        intfInicio = new javax.swing.JInternalFrame();
        dskpaneSubContenedorPrincipal = new javax.swing.JDesktopPane();
        pnlPrincipal = new javax.swing.JPanel();
        pnlBotonCrearCon = new javax.swing.JPanel();
        lbCrearCon = new javax.swing.JLabel();
        pnlBotonMisCon = new javax.swing.JPanel();
        lbMisCon = new javax.swing.JLabel();
        pnlBotonMisArt = new javax.swing.JPanel();
        lbMisArt = new javax.swing.JLabel();
        pnlBotonAsignarEvaluador = new javax.swing.JPanel();
        jLabelAsignar = new javax.swing.JLabel();
        lbBienvenido = new javax.swing.JLabel();
        txtfBusqueda = new javax.swing.JTextField();
        lbBtnBuscar = new javax.swing.JLabel();
        pnlSuperior = new javax.swing.JPanel();
        lbeasyConference = new javax.swing.JLabel();
        lbCerrarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(873, 650));
        setSize(new java.awt.Dimension(873, 650));

        pnlFondo.setMinimumSize(new java.awt.Dimension(873, 650));
        pnlFondo.setPreferredSize(new java.awt.Dimension(873, 650));
        pnlFondo.setLayout(new java.awt.BorderLayout());

        dskpaneContenedor.setSelectedFrame(intfInicio);
        dskpaneContenedor.setLayout(new java.awt.BorderLayout());

        intfInicio.setBackground(new java.awt.Color(255, 255, 255));
        intfInicio.setBorder(null);
        intfInicio.setFrameIcon(null);
        intfInicio.setMinimumSize(new java.awt.Dimension(873, 650));
        intfInicio.setPreferredSize(new java.awt.Dimension(873, 650));
        intfInicio.setVisible(true);
        try {
            intfInicio.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        intfInicio.getContentPane().setLayout(new java.awt.GridBagLayout());

        dskpaneSubContenedorPrincipal.setPreferredSize(new java.awt.Dimension(1000, 365));
        dskpaneSubContenedorPrincipal.setLayout(new java.awt.BorderLayout());

        pnlPrincipal.setPreferredSize(new java.awt.Dimension(900, 327));

        pnlBotonCrearCon.setBackground(new java.awt.Color(129, 218, 199));
        pnlBotonCrearCon.setLayout(new java.awt.BorderLayout());

        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbCrearCon.setForeground(new java.awt.Color(255, 255, 255));
        lbCrearCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCrearCon.setText("Crear conferencia");
        lbCrearCon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCrearCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCrearConMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCrearConMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCrearConMouseExited(evt);
            }
        });
        pnlBotonCrearCon.add(lbCrearCon, java.awt.BorderLayout.CENTER);

        pnlBotonMisCon.setBackground(new java.awt.Color(129, 218, 199));
        pnlBotonMisCon.setLayout(new java.awt.BorderLayout());

        lbMisCon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbMisCon.setForeground(new java.awt.Color(255, 255, 255));
        lbMisCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMisCon.setText("Mis Conferencias");
        lbMisCon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMisCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMisConMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMisConMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMisConMouseExited(evt);
            }
        });
        pnlBotonMisCon.add(lbMisCon, java.awt.BorderLayout.CENTER);

        pnlBotonMisArt.setBackground(new java.awt.Color(129, 218, 199));
        pnlBotonMisArt.setLayout(new java.awt.BorderLayout());

        lbMisArt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbMisArt.setForeground(new java.awt.Color(245, 245, 245));
        lbMisArt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMisArt.setText("Mis Articulos");
        pnlBotonMisArt.add(lbMisArt, java.awt.BorderLayout.CENTER);

        pnlBotonAsignarEvaluador.setBackground(new java.awt.Color(129, 218, 199));

        jLabelAsignar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelAsignar.setForeground(new java.awt.Color(245, 245, 245));
        jLabelAsignar.setText("Asignar Evaluadores");
        jLabelAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAsignarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAsignarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonAsignarEvaluadorLayout = new javax.swing.GroupLayout(pnlBotonAsignarEvaluador);
        pnlBotonAsignarEvaluador.setLayout(pnlBotonAsignarEvaluadorLayout);
        pnlBotonAsignarEvaluadorLayout.setHorizontalGroup(
            pnlBotonAsignarEvaluadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonAsignarEvaluadorLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelAsignar)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlBotonAsignarEvaluadorLayout.setVerticalGroup(
            pnlBotonAsignarEvaluadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonAsignarEvaluadorLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabelAsignar)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(pnlBotonMisArt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBotonMisCon, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(pnlBotonCrearCon, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pnlBotonAsignarEvaluador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlBotonAsignarEvaluador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBotonMisArt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBotonMisCon, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBotonCrearCon, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        dskpaneSubContenedorPrincipal.add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 1000;
        gridBagConstraints.ipady = 365;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 75, 22);
        intfInicio.getContentPane().add(dskpaneSubContenedorPrincipal, gridBagConstraints);

        lbBienvenido.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        lbBienvenido.setText("Bienvenido! ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 479;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 43, 0, 0);
        intfInicio.getContentPane().add(lbBienvenido, gridBagConstraints);

        txtfBusqueda.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfBusqueda.setText("Buscar conferencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 314;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 254, 0, 0);
        intfInicio.getContentPane().add(txtfBusqueda, gridBagConstraints);

        lbBtnBuscar.setText("Buscar");
        lbBtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBtnBuscarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 6, 0, 0);
        intfInicio.getContentPane().add(lbBtnBuscar, gridBagConstraints);

        dskpaneContenedor.add(intfInicio, java.awt.BorderLayout.CENTER);
        //getContentPane().add(intfInicio, java.awt.BorderLayout.CENTER);

        pnlFondo.add(dskpaneContenedor, java.awt.BorderLayout.CENTER);
        //getContentPane().add(dskpaneContenedor, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pnlSuperior.setBackground(new java.awt.Color(0, 153, 153));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(1028, 52));
        pnlSuperior.setLayout(new java.awt.BorderLayout(10, 0));

        lbeasyConference.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lbeasyConference.setForeground(new java.awt.Color(255, 255, 255));
        lbeasyConference.setText("easyConference");
        pnlSuperior.add(lbeasyConference, java.awt.BorderLayout.CENTER);
        pnlSuperior.add(lbeasyConference, java.awt.BorderLayout.WEST);

        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lbCerrarSesion.setText("Cerrar sesion");
        lbCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseExited(evt);
            }
        });
        pnlSuperior.add(lbCerrarSesion, java.awt.BorderLayout.PAGE_START);
        pnlSuperior.add(lbCerrarSesion, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbBtnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBtnBuscarMouseClicked
                                          
        String searchText = txtfBusqueda.getText().trim();  // Obtener texto de búsqueda sin modificar el caso
        //listConferences(searchText);  // Llamar a la función para listar conferencias con el texto de búsqueda
        List<Conferencia> conferences = searchConferences(searchText); 
        
        if(conferences.isEmpty()){
            pnlNoConferences panelNoConferencias = new pnlNoConferences(); 
            dskpaneSubContenedorPrincipal.add(panelNoConferencias, java.awt.BorderLayout.CENTER);
            panelNoConferencias.setVisible(true);
        }
        else{
            GUIconferenceSearch searchResults = new GUIconferenceSearch(conferences); 
            dskpaneSubContenedorPrincipal.add(searchResults,java.awt.BorderLayout.CENTER);
            searchResults.setVisible(true);
        }


    }//GEN-LAST:event_lbBtnBuscarMouseClicked

    private void lbCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseEntered
          ApplicationContext.getInstance().setUsuarioLogueado(null);
        
        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
        
    }//GEN-LAST:event_lbCerrarSesionMouseEntered

    private void lbCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseExited
        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbCerrarSesionMouseExited

    private void lbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseClicked
        this.dispose();
        UserClient userclient = new UserClient();
        GUIlogin login = new GUIlogin(userclient); 
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_lbCerrarSesionMouseClicked

    private void lbMisConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMisConMouseClicked
        GUImisConferencias misConferencias = (GUImisConferencias) InternalFrameFactory.getInstance().getJInternalFrame("MC");
        try {
            misConferencias.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        dskpaneContenedor.add(misConferencias, java.awt.BorderLayout.CENTER);
        misConferencias.setVisible(true);
    }//GEN-LAST:event_lbMisConMouseClicked

    private void lbMisConMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMisConMouseEntered
        lbMisCon.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbMisConMouseEntered

    private void lbMisConMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMisConMouseExited
       lbMisCon.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbMisConMouseExited

    private void lbCrearConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseClicked

        GUIcreateConference crearConferencia = (GUIcreateConference) InternalFrameFactory.getInstance().getJInternalFrame("CC");
        try {
            crearConferencia.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        dskpaneContenedor.add(crearConferencia, java.awt.BorderLayout.CENTER);
        crearConferencia.setVisible(true);
    }//GEN-LAST:event_lbCrearConMouseClicked

    private void lbCrearConMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseEntered
         lbCrearCon.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbCrearConMouseEntered

    private void lbCrearConMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseExited
        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbCrearConMouseExited

    private void lbMisArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMisArtMouseClicked
       GUImisArticulos misArticulos = (GUImisArticulos) InternalFrameFactory.getInstance().getJInternalFrame("MA");
        try {
            misArticulos.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        dskpaneContenedor.add(misArticulos, java.awt.BorderLayout.CENTER);
        misArticulos.setVisible(true);
    }//GEN-LAST:event_lbMisArtMouseClicked

    private void jLabelAsignarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAsignarMouseEntered
        jLabelAsignar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_jLabelAsignarMouseEntered

    private void jLabelAsignarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAsignarMouseExited
        jLabelAsignar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_jLabelAsignarMouseExited
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
         lbBienvenido.setText("Bienvenido! "+ usuario.getName() + " " + usuario.getLastName());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskpaneContenedor;
    private javax.swing.JDesktopPane dskpaneSubContenedorPrincipal;
    private javax.swing.JInternalFrame intfInicio;
    private javax.swing.JLabel jLabelAsignar;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbBtnBuscar;
    private javax.swing.JLabel lbCerrarSesion;
    private javax.swing.JLabel lbCrearCon;
    private javax.swing.JLabel lbMisArt;
    private javax.swing.JLabel lbMisCon;
    private javax.swing.JLabel lbeasyConference;
    private javax.swing.JPanel pnlBotonAsignarEvaluador;
    private javax.swing.JPanel pnlBotonCrearCon;
    private javax.swing.JPanel pnlBotonMisArt;
    private javax.swing.JPanel pnlBotonMisCon;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTextField txtfBusqueda;
    // End of variables declaration//GEN-END:variables

    //@Override
    public void update(Object o) {
        switch (o.getClass().getSimpleName()){
            case "ConferenceService": 
                //listConferences(""); 
                break;
            case "ArticleService":
                //listArticles();
                break;
        }
        this.repaint();
    }
}

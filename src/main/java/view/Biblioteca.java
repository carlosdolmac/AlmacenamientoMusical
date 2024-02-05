/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.HibernateHelper;
import controller.MensajesInternacionales;
import controller.PrincipalController;
import java.awt.Color;

/**
 * Representa el panel de la biblioteca, que muestra estadísticas y enlaces relacionados con las canciones y playlists del usuario.
 * 
 * @author Carlos de los Dolores Macías
 */
public class Biblioteca extends javax.swing.JPanel {
    private PrincipalController principalController;
    private HibernateHelper sqlHelper;    
    
    /**
     * Constructor que inicializa el panel de la biblioteca.
     * @param principalController Controlador principal que gestiona las acciones de la interfaz.
     */
    public Biblioteca(PrincipalController principalController) {
        initComponents();
        sqlHelper = new HibernateHelper();
        this.principalController = principalController;
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h1" );
        numCancionesGuardadas.putClientProperty( "FlatLaf.styleClass", "h3" );
        numPlaylists.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelCancionesGuardadas.putClientProperty( "FlatLaf.styleClass", "h4" );
        labelPlaylists.putClientProperty( "FlatLaf.styleClass", "h4" );
        
        //Titulos
        labelBiblioteca.setText(MensajesInternacionales.obtenerMensaje("label.biblioteca"));
        labelPlaylists.setText(MensajesInternacionales.obtenerMensaje("label.playlists"));
        labelCancionesGuardadas.setText(MensajesInternacionales.obtenerMensaje("label.cancionesguardadas"));
        labelVerLista.setText(MensajesInternacionales.obtenerMensaje("label.verlista"));
        labelVerPlaylists.setText(MensajesInternacionales.obtenerMensaje("label.verplaylists"));
        
        numCancionesGuardadas.setText(String.valueOf(sqlHelper.obtenerNumeroCancionesPorUsuarioActual())); // Actualiza el JLabel con el número de tus canciones
        numPlaylists.setText(String.valueOf(sqlHelper.obtenerNumeroPlaylistsUsuarioActual())); // Actualiza el JLabel con el número de tus playlists
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoBiblioteca = new javax.swing.JPanel();
        labelBiblioteca = new javax.swing.JLabel();
        panelCanciones = new javax.swing.JPanel();
        panelVerLista = new javax.swing.JPanel();
        labelVerLista = new javax.swing.JLabel();
        imgCanciones = new javax.swing.JLabel();
        numCancionesGuardadas = new javax.swing.JLabel();
        labelCancionesGuardadas = new javax.swing.JLabel();
        panelPlaylists = new javax.swing.JPanel();
        panelVerPlaylists = new javax.swing.JPanel();
        labelVerPlaylists = new javax.swing.JLabel();
        imgPlaylists = new javax.swing.JLabel();
        numPlaylists = new javax.swing.JLabel();
        labelPlaylists = new javax.swing.JLabel();

        fondoBiblioteca.setBackground(new java.awt.Color(244, 246, 248));

        labelBiblioteca.setText("Biblioteca");

        panelCanciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        panelCanciones.setPreferredSize(new java.awt.Dimension(212, 152));

        panelVerLista.setBackground(new java.awt.Color(204, 255, 204));

        labelVerLista.setText("Ver Lista Completa");
        labelVerLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelVerLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVerListaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelVerListaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelVerListaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelVerListaLayout = new javax.swing.GroupLayout(panelVerLista);
        panelVerLista.setLayout(panelVerListaLayout);
        panelVerListaLayout.setHorizontalGroup(
            panelVerListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerListaLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(labelVerLista)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelVerListaLayout.setVerticalGroup(
            panelVerListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelVerLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        imgCanciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/song.png"))); // NOI18N

        numCancionesGuardadas.setText("0");

        labelCancionesGuardadas.setText("Canciones");

        javax.swing.GroupLayout panelCancionesLayout = new javax.swing.GroupLayout(panelCanciones);
        panelCanciones.setLayout(panelCancionesLayout);
        panelCancionesLayout.setHorizontalGroup(
            panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCancionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numCancionesGuardadas)
                .addGap(100, 100, 100))
            .addGroup(panelCancionesLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCancionesGuardadas)
                    .addComponent(imgCanciones))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelCancionesLayout.setVerticalGroup(
            panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCancionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imgCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numCancionesGuardadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCancionesGuardadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(panelVerLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPlaylists.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        panelPlaylists.setPreferredSize(new java.awt.Dimension(212, 152));

        panelVerPlaylists.setBackground(new java.awt.Color(204, 255, 204));

        labelVerPlaylists.setText("Ver Playlists");
        labelVerPlaylists.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelVerPlaylists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVerPlaylistsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelVerPlaylistsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelVerPlaylistsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelVerPlaylistsLayout = new javax.swing.GroupLayout(panelVerPlaylists);
        panelVerPlaylists.setLayout(panelVerPlaylistsLayout);
        panelVerPlaylistsLayout.setHorizontalGroup(
            panelVerPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerPlaylistsLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelVerPlaylists)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        panelVerPlaylistsLayout.setVerticalGroup(
            panelVerPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerPlaylistsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelVerPlaylists)
                .addContainerGap())
        );

        imgPlaylists.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/playlist 1.png"))); // NOI18N

        numPlaylists.setText("0");

        labelPlaylists.setText("Playlists");

        javax.swing.GroupLayout panelPlaylistsLayout = new javax.swing.GroupLayout(panelPlaylists);
        panelPlaylists.setLayout(panelPlaylistsLayout);
        panelPlaylistsLayout.setHorizontalGroup(
            panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerPlaylists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlaylistsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPlaylists)
                    .addGroup(panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlaylistsLayout.createSequentialGroup()
                            .addComponent(imgPlaylists)
                            .addGap(88, 88, 88))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlaylistsLayout.createSequentialGroup()
                            .addComponent(numPlaylists)
                            .addGap(101, 101, 101)))))
        );
        panelPlaylistsLayout.setVerticalGroup(
            panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlaylistsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imgPlaylists)
                .addGap(18, 18, 18)
                .addComponent(numPlaylists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPlaylists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(panelVerPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout fondoBibliotecaLayout = new javax.swing.GroupLayout(fondoBiblioteca);
        fondoBiblioteca.setLayout(fondoBibliotecaLayout);
        fondoBibliotecaLayout.setHorizontalGroup(
            fondoBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoBibliotecaLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(fondoBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoBibliotecaLayout.createSequentialGroup()
                        .addComponent(panelCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(panelPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelBiblioteca))
                .addContainerGap(500, Short.MAX_VALUE))
        );
        fondoBibliotecaLayout.setVerticalGroup(
            fondoBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoBibliotecaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(labelBiblioteca)
                .addGap(40, 40, 40)
                .addGroup(fondoBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(406, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestiona los eventos del ratón para los enlaces de la interfaz relacionados con la biblioteca.
     * 
     */
    private void labelVerListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerListaMouseClicked
        principalController.mostrarListaDeCanciones();
    }//GEN-LAST:event_labelVerListaMouseClicked

    /**
     * Gestiona los eventos del ratón para los enlaces de la interfaz relacionados con la biblioteca.
     * 
     */
    private void labelVerPlaylistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerPlaylistsMouseClicked
        principalController.mostrarPlaylists();
    }//GEN-LAST:event_labelVerPlaylistsMouseClicked

    /**
     * Gestiona los eventos del ratón para los enlaces de la interfaz relacionados con la biblioteca.
     *    
     */
    private void labelVerListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerListaMouseEntered
       labelVerLista.setForeground(Color.blue);
    }//GEN-LAST:event_labelVerListaMouseEntered

    /**
     * Gestiona los eventos del ratón para los enlaces de la interfaz relacionados con la biblioteca.
     *  
     */
    private void labelVerListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerListaMouseExited
        labelVerLista.setForeground(Color.black);
    }//GEN-LAST:event_labelVerListaMouseExited

    /**
     * Gestiona los eventos del ratón para los enlaces de la interfaz relacionados con la biblioteca.
     * 
     */
    private void labelVerPlaylistsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerPlaylistsMouseEntered
        labelVerPlaylists.setForeground(Color.blue);
    }//GEN-LAST:event_labelVerPlaylistsMouseEntered

    /**
     * Gestiona los eventos del ratón para los enlaces de la interfaz relacionados con la biblioteca.
     * 
     */
    private void labelVerPlaylistsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerPlaylistsMouseExited
        labelVerPlaylists.setForeground(Color.black);
    }//GEN-LAST:event_labelVerPlaylistsMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoBiblioteca;
    private javax.swing.JLabel imgCanciones;
    private javax.swing.JLabel imgPlaylists;
    private javax.swing.JLabel labelBiblioteca;
    private javax.swing.JLabel labelCancionesGuardadas;
    private javax.swing.JLabel labelPlaylists;
    private javax.swing.JLabel labelVerLista;
    private javax.swing.JLabel labelVerPlaylists;
    private javax.swing.JLabel numCancionesGuardadas;
    private javax.swing.JLabel numPlaylists;
    private javax.swing.JPanel panelCanciones;
    private javax.swing.JPanel panelPlaylists;
    private javax.swing.JPanel panelVerLista;
    private javax.swing.JPanel panelVerPlaylists;
    // End of variables declaration//GEN-END:variables
}

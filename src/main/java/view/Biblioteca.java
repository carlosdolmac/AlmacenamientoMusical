/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.PrincipalController;
import java.awt.Color;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Biblioteca extends javax.swing.JPanel {
    private PrincipalController principalController;    
    /**
     * Creates new form Biblioteca
     */
    public Biblioteca(PrincipalController principalController) {
        initComponents();
        this.principalController = principalController;
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h1" );
        numCancionesGuardadas.putClientProperty( "FlatLaf.styleClass", "h3" );
        numPlaylists.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelCancionesGuardadas.putClientProperty( "FlatLaf.styleClass", "h4" );
        labelPlaylists.putClientProperty( "FlatLaf.styleClass", "h4" );
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
        labelCancionesGuardadas = new javax.swing.JLabel();
        numCancionesGuardadas = new javax.swing.JLabel();
        imgCanciones = new javax.swing.JLabel();
        panelPlaylists = new javax.swing.JPanel();
        panelVerPlaylists = new javax.swing.JPanel();
        labelVerPlaylists = new javax.swing.JLabel();
        labelPlaylists = new javax.swing.JLabel();
        numPlaylists = new javax.swing.JLabel();
        imgPlaylists = new javax.swing.JLabel();

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
                .addGap(48, 48, 48)
                .addComponent(labelVerLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVerListaLayout.setVerticalGroup(
            panelVerListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelVerLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelCancionesGuardadas.setText("Canciones Guardadas");

        numCancionesGuardadas.setText("0");

        imgCanciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/song.png"))); // NOI18N

        javax.swing.GroupLayout panelCancionesLayout = new javax.swing.GroupLayout(panelCanciones);
        panelCanciones.setLayout(panelCancionesLayout);
        panelCancionesLayout.setHorizontalGroup(
            panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCancionesLayout.createSequentialGroup()
                .addGroup(panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCancionesLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(labelCancionesGuardadas))
                    .addGroup(panelCancionesLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(numCancionesGuardadas))
                    .addGroup(panelCancionesLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(imgCanciones)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelCancionesLayout.setVerticalGroup(
            panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCancionesLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(imgCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numCancionesGuardadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCancionesGuardadas)
                .addGap(18, 18, 18)
                .addComponent(panelVerLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPlaylists.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 51), 1, true));
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
                .addGap(70, 70, 70)
                .addComponent(labelVerPlaylists)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVerPlaylistsLayout.setVerticalGroup(
            panelVerPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerPlaylistsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelVerPlaylists)
                .addContainerGap())
        );

        labelPlaylists.setText("Playlists");

        numPlaylists.setText("0");

        imgPlaylists.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/playlist 1.png"))); // NOI18N

        javax.swing.GroupLayout panelPlaylistsLayout = new javax.swing.GroupLayout(panelPlaylists);
        panelPlaylists.setLayout(panelPlaylistsLayout);
        panelPlaylistsLayout.setHorizontalGroup(
            panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerPlaylists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPlaylistsLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgPlaylists)
                    .addGroup(panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelPlaylists)
                        .addGroup(panelPlaylistsLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(numPlaylists))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        panelPlaylistsLayout.setVerticalGroup(
            panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlaylistsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPlaylists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(numPlaylists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPlaylists)
                .addGap(18, 18, 18)
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
                .addGap(45, 45, 45)
                .addComponent(labelBiblioteca)
                .addGap(40, 40, 40)
                .addGroup(fondoBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(407, Short.MAX_VALUE))
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

    private void labelVerListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerListaMouseClicked
        principalController.mostrarListaDeCanciones();
    }//GEN-LAST:event_labelVerListaMouseClicked

    private void labelVerPlaylistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerPlaylistsMouseClicked
        principalController.mostrarPlaylists();
    }//GEN-LAST:event_labelVerPlaylistsMouseClicked

    private void labelVerListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerListaMouseEntered
       labelVerLista.setForeground(Color.blue);
    }//GEN-LAST:event_labelVerListaMouseEntered

    private void labelVerListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerListaMouseExited
        labelVerLista.setForeground(Color.black);
    }//GEN-LAST:event_labelVerListaMouseExited

    private void labelVerPlaylistsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerPlaylistsMouseEntered
        labelVerPlaylists.setForeground(Color.blue);
    }//GEN-LAST:event_labelVerPlaylistsMouseEntered

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

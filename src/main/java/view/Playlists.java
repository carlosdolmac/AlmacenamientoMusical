/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author Alumno
 */
public class Playlists extends javax.swing.JPanel {

    /**
     * Creates new form Playlists
     */
    public Playlists() {
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

        fondoPlaylists = new javax.swing.JPanel();
        labelBiblioteca = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelPlaylists = new javax.swing.JLabel();

        labelBiblioteca.setForeground(new java.awt.Color(153, 153, 153));
        labelBiblioteca.setText("Biblioteca");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mayor.png"))); // NOI18N

        labelPlaylists.setText("Playlists");

        javax.swing.GroupLayout fondoPlaylistsLayout = new javax.swing.GroupLayout(fondoPlaylists);
        fondoPlaylists.setLayout(fondoPlaylistsLayout);
        fondoPlaylistsLayout.setHorizontalGroup(
            fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(labelBiblioteca)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(labelPlaylists)
                .addContainerGap(805, Short.MAX_VALUE))
        );
        fondoPlaylistsLayout.setVerticalGroup(
            fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBiblioteca)
                    .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addComponent(labelPlaylists))
                .addContainerGap(538, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPlaylists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPlaylists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoPlaylists;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelBiblioteca;
    private javax.swing.JLabel labelPlaylists;
    // End of variables declaration//GEN-END:variables
}

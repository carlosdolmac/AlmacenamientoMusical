/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import controller.PrincipalController;
import java.awt.Color;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class ListaDeCanciones extends javax.swing.JPanel {
    private PrincipalController principalController;
    
    /**
     * Creates new form ListaDeCanciones
     */
    public ListaDeCanciones(PrincipalController principalController) {
        initComponents();
        this.principalController = principalController;
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelListaCanciones.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelDescripcion.putClientProperty( "FlatLaf.styleClass", "h4" );
        buscarCancion.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Busca una Canción" ); //Placeholder
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoListaDeCanciones = new javax.swing.JPanel();
        labelBiblioteca = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelListaCanciones = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        buscarCancion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCanciones = new javax.swing.JTable();
        borrarCancion = new javax.swing.JButton();
        anadirCancion = new javax.swing.JButton();

        fondoListaDeCanciones.setBackground(new java.awt.Color(244, 246, 248));

        labelBiblioteca.setForeground(new java.awt.Color(153, 153, 153));
        labelBiblioteca.setText("Biblioteca");
        labelBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBibliotecaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelBibliotecaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelBibliotecaMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mayor.png"))); // NOI18N

        labelListaCanciones.setText("Lista de Canciones");

        labelDescripcion.setText("Lista de Canciones que has guardado");

        buscarCancion.setBackground(new java.awt.Color(227, 236, 227));
        buscarCancion.setPreferredSize(new java.awt.Dimension(340, 38));

        tablaCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Playlist", "Numero Canciones", "Vista Detallada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCanciones);

        borrarCancion.setBackground(new java.awt.Color(139, 243, 204));
        borrarCancion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        borrarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mas.png"))); // NOI18N
        borrarCancion.setText("Borrar Canción");
        borrarCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        anadirCancion.setBackground(new java.awt.Color(139, 243, 204));
        anadirCancion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        anadirCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mas.png"))); // NOI18N
        anadirCancion.setText("Añadir Canción");
        anadirCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anadirCancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anadirCancionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoListaDeCancionesLayout = new javax.swing.GroupLayout(fondoListaDeCanciones);
        fondoListaDeCanciones.setLayout(fondoListaDeCancionesLayout);
        fondoListaDeCancionesLayout.setHorizontalGroup(
            fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcion)
                    .addComponent(buscarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                            .addComponent(labelBiblioteca)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1)
                            .addGap(22, 22, 22)
                            .addComponent(labelListaCanciones)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(borrarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(anadirCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        fondoListaDeCancionesLayout.setVerticalGroup(
            fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelListaCanciones)
                            .addComponent(anadirCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBiblioteca))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoListaDeCancionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)))
                .addComponent(labelDescripcion)
                .addGap(16, 16, 16)
                .addComponent(buscarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoListaDeCanciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoListaDeCanciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al hacer clic en el botón 'anadirCancion'.
     * Se muestra un nuevo panel para añadir la canción
     */
    private void anadirCancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anadirCancionMouseClicked
        principalController.mostrarAnadirCancion();
    }//GEN-LAST:event_anadirCancionMouseClicked

    private void labelBibliotecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseEntered
       labelBiblioteca.setForeground(Color.black);
    }//GEN-LAST:event_labelBibliotecaMouseEntered

    private void labelBibliotecaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseExited
        labelBiblioteca.setForeground(Color.gray);
    }//GEN-LAST:event_labelBibliotecaMouseExited

    private void labelBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseClicked
        principalController.mostrarBiblioteca();
    }//GEN-LAST:event_labelBibliotecaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadirCancion;
    private javax.swing.JButton borrarCancion;
    private javax.swing.JTextField buscarCancion;
    private javax.swing.JPanel fondoListaDeCanciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBiblioteca;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelListaCanciones;
    private javax.swing.JTable tablaCanciones;
    // End of variables declaration//GEN-END:variables
}

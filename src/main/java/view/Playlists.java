/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import controller.HibernateHelper;
import controller.MensajesInternacionales;
import controller.PrincipalController;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Panel que muestra las playlists del usuario actual.
 * 
 * @author Carlos de los Dolores Macías
 */
public class Playlists extends javax.swing.JPanel {
    HibernateHelper hibernateHelper = new HibernateHelper();
    private PrincipalController principalController;
    
    /**
     * Crea una nueva instancia del panel Playlists.
     * Inicializa los componentes y configura la interfaz de usuario.
     * 
     * @param principalController Controlador principal para la gestión de la interfaz.
     */
    public Playlists(PrincipalController principalController) {
        initComponents();
        this.principalController = principalController;
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelPlaylists.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelDescripcion.putClientProperty( "FlatLaf.styleClass", "h4" );
        buscarPlaylist.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Busca una Playlist" ); //Placeholder
        
        mostrarPlaylistsEnTabla();
        
        //Titulos
        labelBiblioteca.setText(MensajesInternacionales.obtenerMensaje("label.biblioteca"));
        labelPlaylists.setText(MensajesInternacionales.obtenerMensaje("label.playlists"));
        borrarPlaylist.setText(MensajesInternacionales.obtenerMensaje("button.borrarplaylist"));
        anadirPlaylist.setText(MensajesInternacionales.obtenerMensaje("button.anadirplaylist"));
        labelDescripcion.setText(MensajesInternacionales.obtenerMensaje("label.descripcionplaylists"));
        
        // Internacionalizar los encabezados de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaPlaylists.getModel();
        model.setColumnIdentifiers(new Object[] {
            MensajesInternacionales.obtenerMensaje("columna.nombreplaylist"),
            MensajesInternacionales.obtenerMensaje("columna.numcanciones")
        });
        
         // Agregar el DocumentListener al campo buscarPlaylist para filtrar la tabla
        buscarPlaylist.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTablaPlaylists(buscarPlaylist.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTablaPlaylists(buscarPlaylist.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTablaPlaylists(buscarPlaylist.getText());
            }
        });
    }

    /**
     * Muestra las playlists del usuario actual en la tabla.
     */
    private void mostrarPlaylistsEnTabla() {
        // Obtain playlists from HibernateHelper
        List<model.Playlists> playlists = hibernateHelper.obtenerPlaylistsUsuarioActual();

        // Populate the table with playlist data
        DefaultTableModel model = (DefaultTableModel) tablaPlaylists.getModel();
        model.setRowCount(0);  // Clear the table before adding new data

        for (model.Playlists playlist : playlists) {
            // Add each playlist as a row in the table
            model.addRow(new Object[]{
                    playlist.getNombrePlaylist(),
                    playlist.getCancioneses().size()  // Assuming 'getCancioneses()' returns a set of songs
            });
        }
    }
    
     /**
     * Filtra la tabla de playlists según el texto ingresado en el campo buscarPlaylist.
     * 
     * @param texto El texto ingresado para filtrar la tabla.
     */
    private void filtrarTablaPlaylists(String texto) {
        DefaultTableModel model = (DefaultTableModel) tablaPlaylists.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tablaPlaylists.setRowSorter(sorter);
        
        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto)); // Case-insensitive search
        }
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
        labelDescripcion = new javax.swing.JLabel();
        buscarPlaylist = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlaylists = new javax.swing.JTable();
        borrarPlaylist = new javax.swing.JButton();
        anadirPlaylist = new javax.swing.JButton();

        fondoPlaylists.setBackground(new java.awt.Color(244, 246, 248));

        labelBiblioteca.setForeground(new java.awt.Color(153, 153, 153));
        labelBiblioteca.setText("Biblioteca");
        labelBiblioteca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        labelPlaylists.setText("Playlists");

        labelDescripcion.setText("Lista de playlists que has guardado");

        buscarPlaylist.setBackground(new java.awt.Color(227, 236, 227));
        buscarPlaylist.setPreferredSize(new java.awt.Dimension(340, 38));

        tablaPlaylists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre Playlist", "Numero Canciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPlaylists);

        borrarPlaylist.setBackground(new java.awt.Color(139, 243, 204));
        borrarPlaylist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        borrarPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mas.png"))); // NOI18N
        borrarPlaylist.setText("Borrar Playlist");
        borrarPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrarPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarPlaylistActionPerformed(evt);
            }
        });

        anadirPlaylist.setBackground(new java.awt.Color(139, 243, 204));
        anadirPlaylist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        anadirPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mas.png"))); // NOI18N
        anadirPlaylist.setText("Añadir Playlist");
        anadirPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anadirPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anadirPlaylistMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoPlaylistsLayout = new javax.swing.GroupLayout(fondoPlaylists);
        fondoPlaylists.setLayout(fondoPlaylistsLayout);
        fondoPlaylistsLayout.setHorizontalGroup(
            fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcion)
                    .addComponent(buscarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                            .addComponent(labelBiblioteca)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1)
                            .addGap(22, 22, 22)
                            .addComponent(labelPlaylists)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(borrarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(anadirPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        fondoPlaylistsLayout.setVerticalGroup(
            fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoPlaylistsLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anadirPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPlaylistsLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelPlaylists)
                                .addComponent(labelBiblioteca))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPlaylistsLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)))
                        .addGap(27, 27, 27)))
                .addComponent(labelDescripcion)
                .addGap(16, 16, 16)
                .addComponent(buscarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
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

    /**
     * Maneja el evento de clic en el botón "Añadir Playlist".
     * Abre la vista de añadir playlist.
     * 
     * @param evt Evento de acción del mouse.
     */
    private void anadirPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anadirPlaylistMouseClicked
        principalController.mostrarAnadirPlaylist();
    }//GEN-LAST:event_anadirPlaylistMouseClicked

    /**
     * Maneja el evento de clic en la etiqueta "Biblioteca".
     * Navega a la vista de Biblioteca.
     * 
     * @param evt Evento de acción del mouse.
     */
    private void labelBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseClicked
        principalController.mostrarBiblioteca();
    }//GEN-LAST:event_labelBibliotecaMouseClicked

    /**
     * Maneja el evento cuando el mouse entra en la etiqueta "Biblioteca".
     * Cambia el color del texto a negro.
     * 
     * @param evt Evento de mouse.
     */
    private void labelBibliotecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseEntered
        labelBiblioteca.setForeground(Color.black);
    }//GEN-LAST:event_labelBibliotecaMouseEntered

    /**
     * Maneja el evento cuando el mouse sale de la etiqueta "Biblioteca".
     * Cambia el color del texto a gris.
     * 
     * @param evt Evento de mouse.
     */
    private void labelBibliotecaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseExited
        labelBiblioteca.setForeground(Color.gray);
    }//GEN-LAST:event_labelBibliotecaMouseExited

    /**
     * Maneja el evento de clic en el botón "Borrar Playlist".
     * Elimina la playlist seleccionada después de la confirmación del usuario.
     * 
     * @param evt Evento de acción del mouse.
     */
    private void borrarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarPlaylistActionPerformed
        // Obtener el índice de la fila seleccionada
        int selectedRowIndex = tablaPlaylists.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (selectedRowIndex != -1) {
            // Obtener el nombre de la playlist desde la fila seleccionada
            String nombrePlaylist = (String) tablaPlaylists.getValueAt(selectedRowIndex, 0);

            // Mostrar un cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrar la Playlist?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                // El usuario ha confirmado el borrado

                // TODO: Utilizar el nombre de la playlist para borrarla de la base de datos
                boolean eliminada = hibernateHelper.borrarPlaylist(nombrePlaylist);  // Reemplaza con el método real en HibernateHelper

                if (eliminada) {
                    // Si la playlist se elimina correctamente, actualiza la tabla
                    mostrarPlaylistsEnTabla();
                } else {
                    // Manejar el caso en el que falla la eliminación
                    System.out.println("No se pudo borrar la playlist");
                }
            } else {
                // El usuario ha cancelado el borrado
                System.out.println("Borrado cancelado por el usuario");
            }
        } else {
            // Informar al usuario que seleccione una fila antes de intentar la eliminación
            System.out.println("Por favor, selecciona una fila para borrar");
        }
    }//GEN-LAST:event_borrarPlaylistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadirPlaylist;
    private javax.swing.JButton borrarPlaylist;
    private javax.swing.JTextField buscarPlaylist;
    private javax.swing.JPanel fondoPlaylists;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBiblioteca;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelPlaylists;
    private javax.swing.JTable tablaPlaylists;
    // End of variables declaration//GEN-END:variables
}

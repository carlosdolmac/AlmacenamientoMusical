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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Canciones;

/**
 * Panel que muestra una lista de canciones.
 * 
 * @author Carlos de los Dolores Macías
 */
public class ListaDeCanciones extends javax.swing.JPanel {
    HibernateHelper hibernateHelper = new HibernateHelper();
    private PrincipalController principalController;

    
    /**
     * Constructor de la clase ListaDeCanciones.
     * @param principalController Controlador principal para la gestión de eventos.
     */
    public ListaDeCanciones(PrincipalController principalController) {
        this.principalController = principalController;
        initComponents();
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelListaCanciones.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelDescripcion.putClientProperty( "FlatLaf.styleClass", "h4" );
        buscarCancion.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Busca una Canción" ); //Placeholder
        
         // Llenar la tabla con las canciones al inicializar
        llenarTablaCanciones();
        
        //Titulos
        labelBiblioteca.setText(MensajesInternacionales.obtenerMensaje("label.biblioteca"));
        labelListaCanciones.setText(MensajesInternacionales.obtenerMensaje("label.listacanciones"));
        labelDescripcion.setText(MensajesInternacionales.obtenerMensaje("label.descripcionlistacanciones"));
        borrarCancion.setText(MensajesInternacionales.obtenerMensaje("button.borrarcancion"));
        anadirCancion.setText(MensajesInternacionales.obtenerMensaje("button.anadircancion"));
        modificarCancion.setText(MensajesInternacionales.obtenerMensaje("button.modificarcancion"));
        
        // Internacionalizar los encabezados de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaCanciones.getModel();
        model.setColumnIdentifiers(new Object[] {
            MensajesInternacionales.obtenerMensaje("columna.nombrecancion"),
            MensajesInternacionales.obtenerMensaje("columna.idcancion"),
            MensajesInternacionales.obtenerMensaje("columna.artista")
        });
        
        // Agregar el DocumentListener al campo buscarCancion para filtrar la tabla
        buscarCancion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla(buscarCancion.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla(buscarCancion.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla(buscarCancion.getText());
            }
        });
    }

    
    /**
     * Llena la tabla de canciones con la información de la base de datos.
     * Se invoca al inicializar la interfaz y después de agregar/borrar una canción.
     */
    private void llenarTablaCanciones() {
        // Obtener las canciones del usuario actual desde el controlador
        List<Canciones> canciones = hibernateHelper.obtenerCancionesUsuarioActual();

        // Llenar la tabla con los datos de las canciones del usuario actual
        DefaultTableModel model = (DefaultTableModel) tablaCanciones.getModel();
        model.setRowCount(0);  // Limpiar la tabla antes de agregar nuevos datos

        for (Canciones cancion : canciones) {
            // Agregar cada canción como una fila en la tabla
            model.addRow(new Object[] {
                cancion.getNombreCancion(),
                cancion.getIdCancion(),
                cancion.getArtistas().getNombreArtista()  // Ajustar esta línea según tu modelo
            });
        }
    }
    
    /**
     * Filtra la tabla de canciones según el texto ingresado en el campo buscarCancion.
     * 
     * @param texto El texto ingresado para filtrar la tabla.
     */
    private void filtrarTabla(String texto) {
        DefaultTableModel model = (DefaultTableModel) tablaCanciones.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tablaCanciones.setRowSorter(sorter);

        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
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
        modificarCancion = new javax.swing.JButton();

        fondoListaDeCanciones.setBackground(new java.awt.Color(244, 246, 248));

        labelBiblioteca.setForeground(new java.awt.Color(153, 153, 153));
        labelBiblioteca.setText("Biblioteca");
        labelBiblioteca.setToolTipText("Si pulsas te lleva a la Biblioteca");
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

        labelListaCanciones.setText("Lista de Canciones");
        labelListaCanciones.setToolTipText("");

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
                "Nombre Canción", "ID Canción", "Artista"
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
        borrarCancion.setToolTipText("Selecciona una canción de la tabla y al pulsar aquí se borrará");
        borrarCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarCancionActionPerformed(evt);
            }
        });

        anadirCancion.setBackground(new java.awt.Color(139, 243, 204));
        anadirCancion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        anadirCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mas.png"))); // NOI18N
        anadirCancion.setText("Añadir Canción");
        anadirCancion.setToolTipText("Pulsar para ir a la ventana de Añadir Canción");
        anadirCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anadirCancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anadirCancionMouseClicked(evt);
            }
        });

        modificarCancion.setBackground(new java.awt.Color(139, 243, 204));
        modificarCancion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modificarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mas.png"))); // NOI18N
        modificarCancion.setText("Modificar Canción");
        modificarCancion.setToolTipText("Selecciona una canción de la tabla y al pulsar aquí se borrará");
        modificarCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarCancionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoListaDeCancionesLayout = new javax.swing.GroupLayout(fondoListaDeCanciones);
        fondoListaDeCanciones.setLayout(fondoListaDeCancionesLayout);
        fondoListaDeCancionesLayout.setHorizontalGroup(
            fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                        .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescripcion)
                            .addComponent(buscarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))))
        );
        fondoListaDeCancionesLayout.setVerticalGroup(
            fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anadirCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoListaDeCancionesLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelListaCanciones)
                                .addComponent(labelBiblioteca))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoListaDeCancionesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)))
                        .addGap(27, 27, 27)))
                .addGroup(fondoListaDeCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoListaDeCancionesLayout.createSequentialGroup()
                        .addComponent(labelDescripcion)
                        .addGap(16, 16, 16)
                        .addComponent(buscarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(modificarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    /**
     * Acción realizada al entrar al área de 'Biblioteca'.
     * Cambia el color del texto a negro.
     */
    private void labelBibliotecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseEntered
       labelBiblioteca.setForeground(Color.black);
    }//GEN-LAST:event_labelBibliotecaMouseEntered

    /**
     * Acción realizada al salir del área de 'Biblioteca'.
     * Cambia el color del texto a gris.
     */
    private void labelBibliotecaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseExited
        labelBiblioteca.setForeground(Color.gray);
    }//GEN-LAST:event_labelBibliotecaMouseExited

    /**
     * Acción realizada al hacer clic en el área de 'Biblioteca'.
     * Muestra el panel de la biblioteca.
     */
    private void labelBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBibliotecaMouseClicked
        principalController.mostrarBiblioteca();
    }//GEN-LAST:event_labelBibliotecaMouseClicked

    /**
     * Acción realizada al hacer clic en el botón 'Borrar Canción'.
     * Elimina la canción seleccionada de la base de datos.
     */
    private void borrarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarCancionActionPerformed
        // Obtener la fila seleccionada
        int selectedRow = tablaCanciones.getSelectedRow();

        // Verificar si se seleccionó una fila
        if (selectedRow != -1) {
            // Obtener el nombre de la canción en la fila seleccionada
            String nombreCancion = (String) tablaCanciones.getValueAt(selectedRow, 0);

            // Confirmar la eliminación
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrar la canción?", "Confirmar Borrado", javax.swing.JOptionPane.YES_NO_OPTION);
            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                // Intentar borrar la canción en la base de datos
                boolean exito = hibernateHelper.borrarCancion(nombreCancion);

                // Verificar si la eliminación fue exitosa
                if (exito) {
                    // Volver a llenar la tabla después de borrar la canción
                    llenarTablaCanciones();
                    javax.swing.JOptionPane.showMessageDialog(this, "Canción borrada exitosamente.", "Borrado Exitoso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al borrar la canción.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una canción para borrar.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_borrarCancionActionPerformed

    /**
     * Maneja la acción de modificar una canción.
     * Se encarga de obtener los datos de la canción seleccionada en la tabla de ListaDeCanciones
     * y mostrar el panel ModificarCancion con dichos datos. 
     */
    private void modificarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarCancionActionPerformed
         // Obtener la fila seleccionada en la tabla de ListaDeCanciones
        int selectedRow = tablaCanciones.getSelectedRow();

        // Verificar si se seleccionó una fila
        if (selectedRow != -1) {
            // Obtener los datos de la canción seleccionada
            String nombreCancion = (String) tablaCanciones.getValueAt(selectedRow, 0);
            int idCancion = (int) tablaCanciones.getValueAt(selectedRow, 1);
            String nombreArtista = (String) tablaCanciones.getValueAt(selectedRow, 2);

            // Crear una nueva instancia del panel ModificarCancion con los datos de la canción
            principalController.mostrarModificarCancion(nombreCancion, idCancion, nombreArtista);
        } else {
            // Si no se selecciona ninguna canción, mostrar un mensaje de error
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una canción para modificar.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modificarCancionActionPerformed

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
    private javax.swing.JButton modificarCancion;
    private javax.swing.JTable tablaCanciones;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.HibernateHelper;
import controller.MensajesInternacionales;
import controller.PrincipalController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Canciones;

/**
 * Panel de inicio que muestra información estadística y listas de canciones.
 * Incluye el número total de canciones, artistas, tus canciones y tus playlists.
 * Permite navegar a la biblioteca, playlists y ver la lista completa de canciones.
 *
 * @author Carlos de los Dolores Macías
 */
public class Inicio extends javax.swing.JPanel {
    private HibernateHelper sqlHelper;
    private PrincipalController principalController;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        sqlHelper = new HibernateHelper();
        cargarTodasLasCanciones();
        //Tamaños
        jLabelInicio.putClientProperty( "FlatLaf.styleClass", "h1" );
        jLabelDescripcion.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelPlaylists.putClientProperty( "FlatLaf.styleClass", "h4" );
        labelArtistas.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelTotalCanciones.putClientProperty( "FlatLaf.styleClass", "h4" );
        labelNumTotalCanciones.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelTusPlaylists.putClientProperty( "FlatLaf.styleClass", "h3" );
        numTusCanciones.putClientProperty( "FlatLaf.styleClass", "h3" );
        numTusPlaylists.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelNumArtistas.putClientProperty( "FlatLaf.styleClass", "h3" );
        labelNumCancionesArtistas.putClientProperty( "FlatLaf.styleClass", "h3" );
        numTotalArtistas.putClientProperty( "FlatLaf.styleClass", "h3" );
        numTotalCanciones.putClientProperty( "FlatLaf.styleClass", "h3" );
        numTotalCanciones.setText(String.valueOf(sqlHelper.obtenerNumeroCanciones())); // Actualiza el JLabel con el número de canciones
        numTotalArtistas.setText(String.valueOf(sqlHelper.obtenerNumeroArtistas())); // Actualiza el JLabel con el número de artistas
        numTusCanciones.setText(String.valueOf(sqlHelper.obtenerNumeroCancionesPorUsuarioActual())); // Actualiza el JLabel con el número de tus canciones
        numTusPlaylists.setText(String.valueOf(sqlHelper.obtenerNumeroPlaylistsUsuarioActual())); // Actualiza el JLabel con el número de tus playlists
    
        //Titulos
        jLabelInicio.setText(MensajesInternacionales.obtenerMensaje("label.inicio"));
        jLabelDescripcion.setText(MensajesInternacionales.obtenerMensaje("label.descripcionInicio"));
        labelBiblioteca.setText(MensajesInternacionales.obtenerMensaje("label.biblioteca"));
        labelPlaylists.setText(MensajesInternacionales.obtenerMensaje("label.playlists"));
        labelArtistas.setText(MensajesInternacionales.obtenerMensaje("label.artistas"));
        labelTotalCanciones.setText(MensajesInternacionales.obtenerMensaje("label.totalcanciones"));
        labelNumTotalCanciones.setText(MensajesInternacionales.obtenerMensaje("label.numtotalcanciones"));
        labelTusPlaylists.setText(MensajesInternacionales.obtenerMensaje("label.tusplaylists"));
        labelNumArtistas.setText(MensajesInternacionales.obtenerMensaje("label.numartistas"));
        labelNumCancionesArtistas.setText(MensajesInternacionales.obtenerMensaje("label.numcancionesartistas"));
        labelListaCompleta.setText(MensajesInternacionales.obtenerMensaje("label.listacompleta"));
        
        // Internacionalizar los encabezados de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaListaCanciones.getModel();
        model.setColumnIdentifiers(new Object[] {
            MensajesInternacionales.obtenerMensaje("columna.nombrecancion"),
            MensajesInternacionales.obtenerMensaje("columna.idcancion"),
            MensajesInternacionales.obtenerMensaje("columna.artista")
        });
    }

    /**
     * Carga todas las canciones desde la base de datos y actualiza la tabla de lista de canciones.
     */
    private void cargarTodasLasCanciones() {
        // Obtener todas las canciones desde la base de datos
        List<Canciones> canciones = sqlHelper.obtenerTodasLasCanciones();

        // Llenar la tabla con los datos de las canciones
        DefaultTableModel model = (DefaultTableModel) tablaListaCanciones.getModel();
        model.setRowCount(0);  // Limpiar la tabla antes de agregar nuevos datos

        for (Canciones cancion : canciones) {
            // Agregar cada canción como una fila en la tabla
            model.addRow(new Object[] {
                cancion.getNombreCancion(),
                cancion.getIdCancion(),
                cancion.getArtistas().getNombreArtista()  // Corregir esta línea
            });
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

        jPanel1 = new javax.swing.JPanel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        panelLibrary = new javax.swing.JPanel();
        labelBiblioteca = new javax.swing.JLabel();
        labelPlaylists = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        numTusCanciones = new javax.swing.JLabel();
        labelNumTotalCanciones = new javax.swing.JLabel();
        labelTusPlaylists = new javax.swing.JLabel();
        numTusPlaylists = new javax.swing.JLabel();
        panelArtists = new javax.swing.JPanel();
        labelArtistas = new javax.swing.JLabel();
        labelTotalCanciones = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelNumArtistas = new javax.swing.JLabel();
        labelNumCancionesArtistas = new javax.swing.JLabel();
        numTotalArtistas = new javax.swing.JLabel();
        numTotalCanciones = new javax.swing.JLabel();
        labelListaCompleta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaCanciones = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1023, 660));

        jPanel1.setBackground(new java.awt.Color(244, 246, 248));
        jPanel1.setPreferredSize(new java.awt.Dimension(1023, 660));

        jLabelInicio.setText("Inicio");

        jLabelDescripcion.setText("Un vistazo rápido a la biblioteca");

        panelLibrary.setBackground(new java.awt.Color(255, 255, 255));
        panelLibrary.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(139, 243, 204), 2, true));
        panelLibrary.setPreferredSize(new java.awt.Dimension(456, 140));

        labelBiblioteca.setText("Biblioteca");

        labelPlaylists.setText("Playlists");

        jSeparator1.setForeground(new java.awt.Color(139, 243, 204));

        numTusCanciones.setText("0");

        labelNumTotalCanciones.setText("Canciones Guardadas");

        labelTusPlaylists.setText("Tus Playlists");

        numTusPlaylists.setText("0");

        javax.swing.GroupLayout panelLibraryLayout = new javax.swing.GroupLayout(panelLibrary);
        panelLibrary.setLayout(panelLibraryLayout);
        panelLibraryLayout.setHorizontalGroup(
            panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelLibraryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBiblioteca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPlaylists)
                .addContainerGap())
            .addGroup(panelLibraryLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNumTotalCanciones)
                    .addComponent(numTusCanciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTusPlaylists)
                    .addComponent(numTusPlaylists))
                .addGap(53, 53, 53))
        );
        panelLibraryLayout.setVerticalGroup(
            panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibraryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBiblioteca)
                    .addComponent(labelPlaylists))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numTusPlaylists, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numTusCanciones))
                .addGap(18, 18, 18)
                .addGroup(panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumTotalCanciones)
                    .addComponent(labelTusPlaylists))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panelArtists.setBackground(new java.awt.Color(255, 255, 255));
        panelArtists.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(139, 243, 204), 2, true));
        panelArtists.setPreferredSize(new java.awt.Dimension(456, 140));

        labelArtistas.setText("Artistas");

        labelTotalCanciones.setText("Total Canciones");

        jSeparator2.setForeground(new java.awt.Color(139, 243, 204));

        labelNumArtistas.setText("Artistas");

        labelNumCancionesArtistas.setText("Número de canciones");

        numTotalArtistas.setText("0");

        numTotalCanciones.setText("0");

        javax.swing.GroupLayout panelArtistsLayout = new javax.swing.GroupLayout(panelArtists);
        panelArtists.setLayout(panelArtistsLayout);
        panelArtistsLayout.setHorizontalGroup(
            panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(panelArtistsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelArtistas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addComponent(labelTotalCanciones)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArtistsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNumArtistas)
                    .addComponent(numTotalArtistas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numTotalCanciones)
                    .addComponent(labelNumCancionesArtistas))
                .addGap(53, 53, 53))
        );
        panelArtistsLayout.setVerticalGroup(
            panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtistsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArtistas)
                    .addComponent(labelTotalCanciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numTotalArtistas)
                    .addComponent(numTotalCanciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelArtistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumArtistas)
                    .addComponent(labelNumCancionesArtistas))
                .addGap(34, 34, 34))
        );

        labelListaCompleta.setText("Lista Completa de Canciones");

        tablaListaCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Canción", "ID", "Artista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListaCanciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaListaCanciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(labelListaCompleta)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(panelArtists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescripcion)
                            .addComponent(jLabelInicio))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescripcion)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelArtists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelListaCompleta)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelArtistas;
    private javax.swing.JLabel labelBiblioteca;
    private javax.swing.JLabel labelListaCompleta;
    private javax.swing.JLabel labelNumArtistas;
    private javax.swing.JLabel labelNumCancionesArtistas;
    private javax.swing.JLabel labelNumTotalCanciones;
    private javax.swing.JLabel labelPlaylists;
    private javax.swing.JLabel labelTotalCanciones;
    private javax.swing.JLabel labelTusPlaylists;
    private javax.swing.JLabel numTotalArtistas;
    private javax.swing.JLabel numTotalCanciones;
    private javax.swing.JLabel numTusCanciones;
    private javax.swing.JLabel numTusPlaylists;
    private javax.swing.JPanel panelArtists;
    private javax.swing.JPanel panelLibrary;
    private javax.swing.JTable tablaListaCanciones;
    // End of variables declaration//GEN-END:variables
}

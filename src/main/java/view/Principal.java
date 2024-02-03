/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.AppState;
import controller.HibernateHelper;
import controller.MensajesInternacionales;
import controller.PrincipalController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JPanel;

/**
 * Clase que representa el panel principal de la aplicación.
 * 
 * @author Carlos de los Dolores Macías
 */
public class Principal extends javax.swing.JPanel {
    private PrincipalController principalController;
    private HibernateHelper sqlHelper;
    private ResourceBundle resourceBundle;
    private int idUsuario;
    Color colorSeleccion = new Color(185, 253, 228); //Color al entrar en los paneles
    Color colorSeleccion2 = new Color(139,243,204); //Color al salir de los paneles
    Color colorSeleccion3 = new Color(23,205,137); //Color al salir de los paneles
    
    // Variable para controlar el estado de visibilidad del panel desplegable de la biblioteca
    private boolean bibliotecaDesplegada = false;
    
    /**
     * Constructor de la clase Principal.
     * 
     * @param idUsuario Identificador único del usuario.
     */
    public Principal(int idUsuario) {
        initComponents();
        principalController = new PrincipalController(this);
        this.idUsuario = idUsuario;
        sqlHelper = new HibernateHelper();
        
        iconDash.setIcon(new FlatSVGIcon("img/Dashboard.svg"));
        iconLib.setIcon(new FlatSVGIcon("img/biblio.svg"));
        iconArt1.setIcon(new FlatSVGIcon("img/Artist.svg"));
        iconOut1.setIcon(new FlatSVGIcon("img/Logout.svg"));
        iconDesplegable.setIcon(new FlatSVGIcon("img/flechaAbajo.svg"));
        textFieldBusqueda.putClientProperty( FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon( "img/Lupa.svg" ) );
        textFieldBusqueda.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Busca algo aquí" ); //Placeholder
        textFieldBusqueda.putClientProperty( "FlatLaf.style", "arc:10"); //Redondeo
        
        mostrarPanel(new Inicio()); // Mostrar el panel 'Inicio' al inicializar la clase Principal
        panelDesplegable.setVisible(false); //Por defecto se oculta el panelDesplegable
        
        //Tamaños
        labelMusicNocta.putClientProperty( "FlatLaf.styleClass", "h1" );
        jLabelUsername.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelInicio.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelInicio.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelLista.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelArtist.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelPlaylists.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelSalir.putClientProperty( "FlatLaf.styleClass", "h3" );
        jLabelBuenos.putClientProperty( "FlatLaf.styleClass", "h3" );
        
        resourceBundle = ResourceBundle.getBundle("messages", new Locale("es"));
        updateUIWithInternationalization();
    }
    
    /**
     * Método para mostrar los paneles en el contenedor principal.
     * @param p Panel que se quiere mostrar.
     */
    public void mostrarPanel(JPanel p) {
        colocarPaneles.removeAll(); // Elimina todos los componentes hijos del panel para que no haya nada al mostrar el panel que se quiere
        colocarPaneles.setLayout(new BorderLayout()); // Establece el BorderLayout para que el panel se expanda

        colocarPaneles.add(p, BorderLayout.CENTER); // Agrega el panel al centro para que se ajuste al tamaño del contenedor

        colocarPaneles.revalidate(); // Obliga al panel a recalcular su diseño
        colocarPaneles.repaint(); // Solicita al panel que repinte sus componentes
    }
    /**
     * Método para mostrar los paneles en el contenedor del fondo del dashboard.
     * @param p Panel que se quiere mostrar.
     */
    public void mostrarPanel1(JPanel p) {
        fondoDashboard.removeAll(); // Elimina todos los componentes hijos del panel para que no haya nada al mostrar el panel que se quiere
        fondoDashboard.setLayout(new BorderLayout()); // Establece el BorderLayout para que el panel se expanda

        fondoDashboard.add(p, BorderLayout.CENTER); // Agrega el panel al centro para que se ajuste al tamaño del contenedor

        fondoDashboard.revalidate(); // Obliga al panel a recalcular su diseño
        fondoDashboard.repaint(); // Solicita al panel que repinte sus componentes
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoDashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelMusicNocta = new javax.swing.JLabel();
        imgApp = new javax.swing.JLabel();
        panelBiblioteca = new javax.swing.JPanel();
        jLabelBiblioteca = new javax.swing.JLabel();
        iconDesplegable = new javax.swing.JLabel();
        iconLib = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        panelInicio = new javax.swing.JPanel();
        jLabelInicio = new javax.swing.JLabel();
        iconDash = new javax.swing.JLabel();
        panelSalir = new javax.swing.JPanel();
        jLabelSalir = new javax.swing.JLabel();
        iconOut1 = new javax.swing.JLabel();
        panelArtista = new javax.swing.JPanel();
        jLabelArtist = new javax.swing.JLabel();
        iconArt1 = new javax.swing.JLabel();
        panelDesplegable = new javax.swing.JPanel();
        panelListaCanciones = new javax.swing.JPanel();
        jLabelLista = new javax.swing.JLabel();
        iconArt = new javax.swing.JLabel();
        panelPlaylists = new javax.swing.JPanel();
        jLabelPlaylists = new javax.swing.JLabel();
        iconOut = new javax.swing.JLabel();
        colocarPaneles = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        textFieldBusqueda = new javax.swing.JTextField();
        jLabelBuenos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idiomas = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(51, 153, 0));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(139, 243, 204));

        jPanel2.setBackground(new java.awt.Color(23, 205, 137));
        jPanel2.setPreferredSize(new java.awt.Dimension(256, 60));

        labelMusicNocta.setText("Music Nocta");

        imgApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notamusical2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(imgApp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMusicNocta)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(labelMusicNocta))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgApp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelBiblioteca.setBackground(new java.awt.Color(139, 243, 204));
        panelBiblioteca.setToolTipText("Muestra la pantalla de Biblioteca");
        panelBiblioteca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBiblioteca.setPreferredSize(new java.awt.Dimension(256, 46));
        panelBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBibliotecaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBibliotecaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBibliotecaMouseExited(evt);
            }
        });

        jLabelBiblioteca.setText("Biblioteca");

        javax.swing.GroupLayout panelBibliotecaLayout = new javax.swing.GroupLayout(panelBiblioteca);
        panelBiblioteca.setLayout(panelBibliotecaLayout);
        panelBibliotecaLayout.setHorizontalGroup(
            panelBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBibliotecaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(iconLib)
                .addGap(18, 18, 18)
                .addComponent(jLabelBiblioteca)
                .addGap(79, 79, 79)
                .addComponent(iconDesplegable))
        );
        panelBibliotecaLayout.setVerticalGroup(
            panelBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBibliotecaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBiblioteca)
                        .addComponent(iconLib))
                    .addGroup(panelBibliotecaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(iconDesplegable))))
        );

        jLabelUsername.setText("Username");

        panelInicio.setBackground(new java.awt.Color(139, 243, 204));
        panelInicio.setToolTipText("Muestra la pantalla de Inicio");
        panelInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelInicio.setPreferredSize(new java.awt.Dimension(256, 46));
        panelInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelInicioMouseExited(evt);
            }
        });

        jLabelInicio.setText("Inicio");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(iconDash)
                .addGap(18, 18, 18)
                .addComponent(jLabelInicio)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInicio)
                    .addComponent(iconDash))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelSalir.setBackground(new java.awt.Color(139, 243, 204));
        panelSalir.setToolTipText("Cierra la aplicación");
        panelSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelSalir.setPreferredSize(new java.awt.Dimension(256, 46));
        panelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelSalirMouseExited(evt);
            }
        });

        jLabelSalir.setText("Salir");

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconOut1)
                .addGap(26, 26, 26)
                .addComponent(jLabelSalir)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalirLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconOut1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelArtista.setBackground(new java.awt.Color(139, 243, 204));
        panelArtista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelArtista.setPreferredSize(new java.awt.Dimension(256, 46));
        panelArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelArtistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelArtistaMouseExited(evt);
            }
        });

        jLabelArtist.setText("Artista");

        javax.swing.GroupLayout panelArtistaLayout = new javax.swing.GroupLayout(panelArtista);
        panelArtista.setLayout(panelArtistaLayout);
        panelArtistaLayout.setHorizontalGroup(
            panelArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtistaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconArt1)
                .addGap(26, 26, 26)
                .addComponent(jLabelArtist)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        panelArtistaLayout.setVerticalGroup(
            panelArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtistaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconArt1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelArtist))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelDesplegable.setBackground(new java.awt.Color(23, 205, 137));

        panelListaCanciones.setBackground(new java.awt.Color(23, 205, 137));
        panelListaCanciones.setToolTipText("Muestra la pantalla de Lista de Canciones");
        panelListaCanciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelListaCanciones.setPreferredSize(new java.awt.Dimension(256, 46));
        panelListaCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelListaCancionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelListaCancionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelListaCancionesMouseExited(evt);
            }
        });

        jLabelLista.setText("Lista de Canciones");

        javax.swing.GroupLayout panelListaCancionesLayout = new javax.swing.GroupLayout(panelListaCanciones);
        panelListaCanciones.setLayout(panelListaCancionesLayout);
        panelListaCancionesLayout.setHorizontalGroup(
            panelListaCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaCancionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconArt)
                .addGap(26, 26, 26)
                .addComponent(jLabelLista)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        panelListaCancionesLayout.setVerticalGroup(
            panelListaCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaCancionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelListaCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconArt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLista))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelPlaylists.setBackground(new java.awt.Color(23, 205, 137));
        panelPlaylists.setToolTipText("Muestra la pantalla de Playlists");
        panelPlaylists.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelPlaylists.setPreferredSize(new java.awt.Dimension(256, 46));
        panelPlaylists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPlaylistsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelPlaylistsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelPlaylistsMouseExited(evt);
            }
        });

        jLabelPlaylists.setText("Playlists");

        javax.swing.GroupLayout panelPlaylistsLayout = new javax.swing.GroupLayout(panelPlaylists);
        panelPlaylists.setLayout(panelPlaylistsLayout);
        panelPlaylistsLayout.setHorizontalGroup(
            panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlaylistsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconOut)
                .addGap(26, 26, 26)
                .addComponent(jLabelPlaylists)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        panelPlaylistsLayout.setVerticalGroup(
            panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlaylistsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelPlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconOut, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPlaylists))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDesplegableLayout = new javax.swing.GroupLayout(panelDesplegable);
        panelDesplegable.setLayout(panelDesplegableLayout);
        panelDesplegableLayout.setHorizontalGroup(
            panelDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesplegableLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelListaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelDesplegableLayout.setVerticalGroup(
            panelDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesplegableLayout.createSequentialGroup()
                .addComponent(panelListaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabelUsername))
                    .addComponent(panelBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabelUsername)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(panelBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        colocarPaneles.setBackground(new java.awt.Color(244, 246, 248));
        colocarPaneles.setPreferredSize(new java.awt.Dimension(1042, 720));

        javax.swing.GroupLayout colocarPanelesLayout = new javax.swing.GroupLayout(colocarPaneles);
        colocarPaneles.setLayout(colocarPanelesLayout);
        colocarPanelesLayout.setHorizontalGroup(
            colocarPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );
        colocarPanelesLayout.setVerticalGroup(
            colocarPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        textFieldBusqueda.setBackground(new java.awt.Color(227, 236, 227));
        textFieldBusqueda.setPreferredSize(new java.awt.Dimension(440, 38));

        jLabelBuenos.setText("Buenos días");

        jLabel2.setText("fecha");

        jLabel3.setText("hora");

        idiomas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Inglés" }));
        idiomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idiomasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(textFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelBuenos)
                        .addGap(25, 25, 25)))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelBuenos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fondoDashboardLayout = new javax.swing.GroupLayout(fondoDashboard);
        fondoDashboard.setLayout(fondoDashboardLayout);
        fondoDashboardLayout.setHorizontalGroup(
            fondoDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoDashboardLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(colocarPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE))
            .addGroup(fondoDashboardLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoDashboardLayout.setVerticalGroup(
            fondoDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondoDashboardLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(colocarPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método llamado al hacer clic en el panel de la biblioteca.
     * Muestra la biblioteca y actualiza el estado de visibilidad.
     * Actualiza los paneles según el estado.
     */
    private void panelBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBibliotecaMouseClicked
        principalController.mostrarBiblioteca();
        // Cambia el estado de visibilidad y actualiza los paneles
        bibliotecaDesplegada = !bibliotecaDesplegada;
        actualizarPaneles();
    }//GEN-LAST:event_panelBibliotecaMouseClicked

    /**
     * Método llamado al hacer clic en el panel de inicio.
     * Muestra el panel de inicio en el contenedor principal.
     */
    private void panelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInicioMouseClicked
        mostrarPanel(new Inicio());
    }//GEN-LAST:event_panelInicioMouseClicked

    /**
     * Método llamado al entrar con el ratón en el panel de inicio.
     * Cambia el fondo del panel al color de selección.
     */
    private void panelInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInicioMouseEntered
        panelInicio.setBackground(colorSeleccion);
    }//GEN-LAST:event_panelInicioMouseEntered

    /**
     * Método llamado al salir con el ratón del panel de inicio.
     * Restaura el fondo del panel al color original.
     */
    private void panelInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInicioMouseExited
        panelInicio.setBackground(colorSeleccion2);
    }//GEN-LAST:event_panelInicioMouseExited

    /**
     * Método llamado al entrar con el ratón en el panel de biblioteca.
     * Cambia el fondo del panel al color de selección.
     */
    private void panelBibliotecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBibliotecaMouseEntered
        panelBiblioteca.setBackground(colorSeleccion);
    }//GEN-LAST:event_panelBibliotecaMouseEntered

    /**
     * Método llamado al salir con el ratón del panel de biblioteca.
     * Restaura el fondo del panel al color original.
     */
    private void panelBibliotecaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBibliotecaMouseExited
        panelBiblioteca.setBackground(colorSeleccion2);
    }//GEN-LAST:event_panelBibliotecaMouseExited

    /**
     * Método llamado al salir con el ratón del panel de lista de canciones.
     * Restaura el fondo del panel al color original.
     */
    private void panelListaCancionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelListaCancionesMouseExited
        panelListaCanciones.setBackground(colorSeleccion3);
    }//GEN-LAST:event_panelListaCancionesMouseExited

    /**
     * Método llamado al entrar con el ratón en el panel de lista de canciones.
     * Cambia el fondo del panel al color de selección.
     */
    private void panelListaCancionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelListaCancionesMouseEntered
        panelListaCanciones.setBackground(colorSeleccion);
    }//GEN-LAST:event_panelListaCancionesMouseEntered

    /**
     * Método llamado al entrar con el ratón en el panel de playlists.
     * Cambia el fondo del panel al color de selección.
     * También cambia el fondo del panel desplegable al color de selección.
     */
    private void panelPlaylistsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPlaylistsMouseEntered
        panelPlaylists.setBackground(colorSeleccion);
        panelDesplegable.setBackground(colorSeleccion);
    }//GEN-LAST:event_panelPlaylistsMouseEntered

    /**
     * Método llamado al salir con el ratón del panel de playlists.
     * Restaura el fondo del panel y del panel desplegable al color original.
     */
    private void panelPlaylistsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPlaylistsMouseExited
        panelPlaylists.setBackground(colorSeleccion3);
        panelDesplegable.setBackground(colorSeleccion3);
    }//GEN-LAST:event_panelPlaylistsMouseExited

    
    /**
     * Método llamado al salir con el ratón del panel de artista.
     * Restaura el fondo del panel al color original.
     */
    private void panelArtistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelArtistaMouseExited
        panelArtista.setBackground(colorSeleccion2);
    }//GEN-LAST:event_panelArtistaMouseExited

    /**
     * Método llamado al salir con el ratón del panel de salir.
     * Restaura el fondo del panel al color original.
     */
    private void panelSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSalirMouseExited
        panelSalir.setBackground(colorSeleccion2);
    }//GEN-LAST:event_panelSalirMouseExited
 
    /**
     * Método llamado al entrar con el ratón en el panel de artista.
     * Cambia el fondo del panel al color de selección.
     */
    private void panelArtistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelArtistaMouseEntered
        panelArtista.setBackground(colorSeleccion);
    }//GEN-LAST:event_panelArtistaMouseEntered

    /**
     * Método llamado al entrar con el ratón en el panel de salir.
     * Cambia el fondo del panel al color de selección.
     */
    private void panelSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSalirMouseEntered
        panelSalir.setBackground(colorSeleccion);
    }//GEN-LAST:event_panelSalirMouseEntered

    /**
     * Método llamado al hacer clic en el panel de lista de canciones.
     * Muestra la lista de canciones.
     */
    private void panelListaCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelListaCancionesMouseClicked
        principalController.mostrarListaDeCanciones();
    }//GEN-LAST:event_panelListaCancionesMouseClicked

    /**
     * Método llamado al hacer clic en el panel de playlists.
     * Muestra las playlists.
     */
    private void panelPlaylistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPlaylistsMouseClicked
        principalController.mostrarPlaylists();
    }//GEN-LAST:event_panelPlaylistsMouseClicked

    /**
     * Método llamado al hacer clic en el panel de salir.
     * Cierra la aplicación.
     */
    private void panelSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_panelSalirMouseClicked

    /**
     * Método llamado al seleccionar un idioma en el menú desplegable de idiomas.
     * Cambia el idioma de la aplicación y actualiza los textos en la interfaz.
     */
    private void idiomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idiomasActionPerformed
        String idiomaSeleccionado = idiomas.getSelectedItem().toString();
        Locale nuevoLocale;

        if (idiomaSeleccionado.equals("Español")) {
            nuevoLocale = new Locale("es");
        } else if (idiomaSeleccionado.equals("Inglés")) {
            nuevoLocale = new Locale("en");
        } else {
            // Manejar cualquier otro idioma que puedas tener
            nuevoLocale = new Locale("es");
        }

        // Cambiar el idioma a nivel global
        AppState.setCurrentLocale(nuevoLocale);

        // Cambiar el idioma utilizando el nuevo mecanismo en MensajesInternacionales
        MensajesInternacionales.cambiarIdioma(nuevoLocale.getLanguage());

        // Actualizar los textos en la interfaz con los nuevos mensajes internacionales
        updateUIWithInternationalization();
    }//GEN-LAST:event_idiomasActionPerformed
   
    /**
     * Método para actualizar la visibilidad del panel desplegable.
     * Se llama después de cambiar el estado de visibilidad de la biblioteca.
     */
    private void actualizarPaneles() {
        panelDesplegable.setVisible(bibliotecaDesplegada);

        colocarPaneles.revalidate();
        colocarPaneles.repaint();
    }
    
    /**
     * Método para actualizar los textos en la interfaz con los mensajes internacionales.
     */
    private void updateUIWithInternationalization() {
        //Títulos
        jLabelInicio.setText(MensajesInternacionales.obtenerMensaje("label.inicio"));
        jLabelBiblioteca.setText(MensajesInternacionales.obtenerMensaje("label.biblioteca"));
        jLabelLista.setText(MensajesInternacionales.obtenerMensaje("label.listacanciones"));
        jLabelPlaylists.setText(MensajesInternacionales.obtenerMensaje("label.playlists"));
        jLabelArtist.setText(MensajesInternacionales.obtenerMensaje("label.artistas"));
        jLabelSalir.setText(MensajesInternacionales.obtenerMensaje("label.salir"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel colocarPaneles;
    private javax.swing.JPanel fondoDashboard;
    private javax.swing.JLabel iconArt;
    private javax.swing.JLabel iconArt1;
    private javax.swing.JLabel iconDash;
    private javax.swing.JLabel iconDesplegable;
    private javax.swing.JLabel iconLib;
    private javax.swing.JLabel iconOut;
    private javax.swing.JLabel iconOut1;
    private javax.swing.JComboBox<String> idiomas;
    private javax.swing.JLabel imgApp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelArtist;
    private javax.swing.JLabel jLabelBiblioteca;
    private javax.swing.JLabel jLabelBuenos;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JLabel jLabelPlaylists;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelMusicNocta;
    private javax.swing.JPanel panelArtista;
    private javax.swing.JPanel panelBiblioteca;
    private javax.swing.JPanel panelDesplegable;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelListaCanciones;
    private javax.swing.JPanel panelPlaylists;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JTextField textFieldBusqueda;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
//Placeholer para primera entrega
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.HibernateHelper;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Usuarios;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Principal extends javax.swing.JPanel {
    private HibernateHelper sqlHelper;
    private int idUsuario;
    /**
     * Creates new form Dashboard
     */
    public Principal(int idUsuario) {
        initComponents();
        this.idUsuario = idUsuario;
        sqlHelper = new HibernateHelper();
        //numCanciones.setText(String.valueOf(obtenerNumeroCanciones())); // Actualizar el JLabel con el número de canciones
        
        iconDash.setIcon(new FlatSVGIcon("img/Dashboard.svg"));
        iconLib.setIcon(new FlatSVGIcon("img/Library.svg"));
        iconArt.setIcon(new FlatSVGIcon("img/Artist.svg"));
        iconOut.setIcon(new FlatSVGIcon("img/Logout.svg"));
        textFieldBusqueda.putClientProperty( FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon( "img/lupa.svg" ) );
        textFieldBusqueda.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Busca algo aquí" ); //Placeholder
        textFieldBusqueda.putClientProperty( "FlatLaf.style", "arc:10");
        
        mostrarPanel(new Inicio()); // Mostrar el panel 'Inicio' al inicializar la clase Principal
    }
    
    public void mostrarPanel(JPanel p) {
        colocarPaneles.removeAll(); // Elimina todos los componentes hijos del panel para que no haya nada al mostrar el panel que se quiere
        colocarPaneles.setLayout(new BorderLayout()); // Establece el BorderLayout para que el panel se expanda

        colocarPaneles.add(p, BorderLayout.CENTER); // Agrega el panel al centro para que se ajuste al tamaño del contenedor

        colocarPaneles.revalidate(); // Obliga al panel a recalcular su diseño
        colocarPaneles.repaint(); // Solicita al panel que repinte sus componentes
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
        panelLibrary = new javax.swing.JPanel();
        jLabelLibrary = new javax.swing.JLabel();
        iconLib = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        panelDashboard = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        iconDash = new javax.swing.JLabel();
        panelArtist = new javax.swing.JPanel();
        jLabelArtist = new javax.swing.JLabel();
        iconArt = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        iconOut = new javax.swing.JLabel();
        colocarPaneles = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        textFieldBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 153, 0));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(79, 52, 90));

        jPanel2.setBackground(new java.awt.Color(57, 37, 65));
        jPanel2.setPreferredSize(new java.awt.Dimension(256, 60));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelLibrary.setBackground(new java.awt.Color(102, 0, 102));
        panelLibrary.setPreferredSize(new java.awt.Dimension(256, 46));

        jLabelLibrary.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLibrary.setText("Library");

        javax.swing.GroupLayout panelLibraryLayout = new javax.swing.GroupLayout(panelLibrary);
        panelLibrary.setLayout(panelLibraryLayout);
        panelLibraryLayout.setHorizontalGroup(
            panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibraryLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconLib)
                .addGap(26, 26, 26)
                .addComponent(jLabelLibrary)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        panelLibraryLayout.setVerticalGroup(
            panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibraryLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconLib, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLibrary))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("Username");

        panelDashboard.setBackground(new java.awt.Color(102, 0, 102));
        panelDashboard.setPreferredSize(new java.awt.Dimension(256, 46));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dashboard");

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconDash)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconDash, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelArtist.setBackground(new java.awt.Color(102, 0, 102));
        panelArtist.setPreferredSize(new java.awt.Dimension(256, 46));

        jLabelArtist.setForeground(new java.awt.Color(255, 255, 255));
        jLabelArtist.setText("Artist");

        javax.swing.GroupLayout panelArtistLayout = new javax.swing.GroupLayout(panelArtist);
        panelArtist.setLayout(panelArtistLayout);
        panelArtistLayout.setHorizontalGroup(
            panelArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtistLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconArt)
                .addGap(26, 26, 26)
                .addComponent(jLabelArtist)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        panelArtistLayout.setVerticalGroup(
            panelArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtistLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconArt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelArtist))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelLogout.setBackground(new java.awt.Color(102, 0, 102));
        panelLogout.setPreferredSize(new java.awt.Dimension(256, 46));

        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setText("Log Out");

        javax.swing.GroupLayout panelLogoutLayout = new javax.swing.GroupLayout(panelLogout);
        panelLogout.setLayout(panelLogoutLayout);
        panelLogoutLayout.setHorizontalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconOut)
                .addGap(26, 26, 26)
                .addComponent(jLabelLogout)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        panelLogoutLayout.setVerticalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconOut, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLogout))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabelUsername))
            .addComponent(panelArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(81, 81, 81)
                        .addComponent(panelArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(panelLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(panelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(424, Short.MAX_VALUE))
        );

        colocarPaneles.setBackground(new java.awt.Color(204, 255, 204));
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

        textFieldBusqueda.setBackground(new java.awt.Color(204, 255, 204));
        textFieldBusqueda.setPreferredSize(new java.awt.Dimension(440, 38));

        jLabel1.setText("Buenos días");

        jLabel2.setText("fecha");

        jLabel3.setText("hora");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(textFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(textFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3))))
                .addContainerGap(26, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel colocarPaneles;
    private javax.swing.JPanel fondoDashboard;
    private javax.swing.JLabel iconArt;
    private javax.swing.JLabel iconDash;
    private javax.swing.JLabel iconLib;
    private javax.swing.JLabel iconOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelArtist;
    private javax.swing.JLabel jLabelLibrary;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelArtist;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelLibrary;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JTextField textFieldBusqueda;
    // End of variables declaration//GEN-END:variables
}

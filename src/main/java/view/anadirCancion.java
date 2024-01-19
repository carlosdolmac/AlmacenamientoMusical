/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author Alumno
 */
public class anadirCancion extends javax.swing.JPanel {

    /**
     * Creates new form anadirCancion
     */
    public anadirCancion() {
        initComponents();
        labelBiblioteca.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelLista.putClientProperty( "FlatLaf.styleClass", "h1" );
        labelAnadirCancion.putClientProperty( "FlatLaf.styleClass", "h1" );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoAnadirCancion = new javax.swing.JPanel();
        labelBiblioteca = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelLista = new javax.swing.JLabel();
        labelAnadirCancion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        nombreCancion = new javax.swing.JTextField();
        idCancion = new javax.swing.JTextField();
        artista = new javax.swing.JTextField();
        labelArtista = new javax.swing.JLabel();
        labelPlaylist = new javax.swing.JLabel();
        playlist = new javax.swing.JComboBox<>();
        guardarCancion = new javax.swing.JButton();

        fondoAnadirCancion.setBackground(new java.awt.Color(244, 246, 248));

        labelBiblioteca.setForeground(new java.awt.Color(153, 153, 153));
        labelBiblioteca.setText("Biblioteca");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mayor.png"))); // NOI18N

        labelLista.setForeground(new java.awt.Color(153, 153, 153));
        labelLista.setText("Lista de Canciones");

        labelAnadirCancion.setText("Añadir Canción");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mayor.png"))); // NOI18N

        labelNombre.setText("Nombre de la canción");

        labelID.setText("ID de la canción");

        nombreCancion.setBackground(new java.awt.Color(244, 246, 248));
        nombreCancion.setText("jTextField1");
        nombreCancion.setPreferredSize(new java.awt.Dimension(340, 38));

        idCancion.setBackground(new java.awt.Color(244, 246, 248));
        idCancion.setText("jTextField1");
        idCancion.setPreferredSize(new java.awt.Dimension(340, 38));

        artista.setBackground(new java.awt.Color(244, 246, 248));
        artista.setText("jTextField1");
        artista.setPreferredSize(new java.awt.Dimension(340, 38));

        labelArtista.setText("Artista");

        labelPlaylist.setText("Playlist (Opcional)");

        playlist.setBackground(new java.awt.Color(244, 246, 248));
        playlist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        playlist.setPreferredSize(new java.awt.Dimension(340, 38));

        guardarCancion.setBackground(new java.awt.Color(139, 243, 204));
        guardarCancion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        guardarCancion.setText("Guardar Canción");
        guardarCancion.setPreferredSize(new java.awt.Dimension(162, 46));

        javax.swing.GroupLayout fondoAnadirCancionLayout = new javax.swing.GroupLayout(fondoAnadirCancion);
        fondoAnadirCancion.setLayout(fondoAnadirCancionLayout);
        fondoAnadirCancionLayout.setHorizontalGroup(
            fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addComponent(labelBiblioteca)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(labelLista)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(labelAnadirCancion))
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(359, 359, 359)
                        .addComponent(labelID))
                    .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                            .addComponent(nombreCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(125, 125, 125)
                            .addComponent(idCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                            .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelPlaylist)
                                .addComponent(playlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelArtista)
                                .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        fondoAnadirCancionLayout.setVerticalGroup(
            fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelBiblioteca)
                        .addGap(61, 61, 61)
                        .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(labelID))
                        .addGap(18, 18, 18)
                        .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelLista))
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(fondoAnadirCancionLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelAnadirCancion)))
                .addGap(54, 54, 54)
                .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArtista)
                    .addComponent(labelPlaylist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoAnadirCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(guardarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoAnadirCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoAnadirCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artista;
    private javax.swing.JPanel fondoAnadirCancion;
    private javax.swing.JButton guardarCancion;
    private javax.swing.JTextField idCancion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelAnadirCancion;
    private javax.swing.JLabel labelArtista;
    private javax.swing.JLabel labelBiblioteca;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelLista;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPlaylist;
    private javax.swing.JTextField nombreCancion;
    private javax.swing.JComboBox<String> playlist;
    // End of variables declaration//GEN-END:variables
}

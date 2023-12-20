/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import controller.SQLHelper;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Login extends javax.swing.JPanel {
    private Interfaz interfaz;
    /**
     * Creates new form login
     */
    public Login(Interfaz interfaz) {
        this.interfaz = interfaz; // Guardar la referencia a Interfaz
        initComponents();
        
        email.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Email" ); //Placeholder
        passwrd.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, "Password" ); //Placeholder
        signinLabel.putClientProperty( "FlatLaf.styleClass", "h1" );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        signinLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        passwrd = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        signupLabel = new javax.swing.JLabel();
        recoverpassLabel = new javax.swing.JLabel();
        imagelogin = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        fondo.setBackground(new java.awt.Color(139, 243, 204));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 720));

        signinLabel.setText("Sign in");

        email.setPreferredSize(new java.awt.Dimension(575, 47));

        passwrd.setPreferredSize(new java.awt.Dimension(575, 47));

        login.setBackground(new java.awt.Color(91, 134, 229));
        login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.setPreferredSize(new java.awt.Dimension(575, 60));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        signupLabel.setText("Don’t have an account? Signup Here");

        recoverpassLabel.setText("Don’t remember your password? Click Here");

        imagelogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notamusical1.png"))); // NOI18N

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(signinLabel))
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(signupLabel))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(recoverpassLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(imagelogin)
                .addGap(48, 48, 48))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(signinLabel)
                        .addGap(46, 46, 46)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(signupLabel)
                        .addGap(0, 0, 0)
                        .addComponent(recoverpassLabel))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(imagelogin)))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String correo = email.getText();
    String contraseña = passwrd.getText();

    try {
        SQLHelper sqlHelper = new SQLHelper();
        int idUsuario = sqlHelper.obtenerIdUsuario(correo, contraseña); // Método para obtener el ID del usuario

        if (idUsuario != -1) { // Verificar si se encontró un usuario válido
            Dashboard dashboard = new Dashboard(idUsuario); // Pasar el ID del usuario al constructor de Dashboard

            interfaz.mostrarPanel(dashboard); // Mostrar el panel Dashboard
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Por favor, intenta de nuevo.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejo de errores
    }
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel imagelogin;
    private javax.swing.JButton login;
    private javax.swing.JTextField passwrd;
    private javax.swing.JLabel recoverpassLabel;
    private javax.swing.JLabel signinLabel;
    private javax.swing.JLabel signupLabel;
    // End of variables declaration//GEN-END:variables
}

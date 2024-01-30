/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import controller.HibernateHelper;
import controller.MensajesInternacionales;
import controller.SignupController;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.Usuarios;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Signup extends javax.swing.JPanel {
    private Interfaz interfaz;

     /**
     * Inicializa el panel de registro.
     * Configura los placeholders para los campos y guarda la referencia a Interfaz.
     * @param interfaz Instancia de Interfaz para manejar la navegación entre vistas.
     */
    public Signup(Interfaz interfaz) {
        this.interfaz = interfaz; // Guardar la referencia a Interfaz
        initComponents();
        
        name.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.nombre"));
        surname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.apellido"));
        username.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.nombreUsuario"));
        email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.email"));
        passwrd.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.password"));
        createAccountLabel.putClientProperty("FlatLaf.styleClass", "h1");
        accountLabel.setText(MensajesInternacionales.obtenerMensaje("label.account"));
        loginLabel.setText(MensajesInternacionales.obtenerMensaje("label.iniciasesion"));
        createAccountLabel.setText(MensajesInternacionales.obtenerMensaje("label.createaccount"));
        createAccount.setText(MensajesInternacionales.obtenerMensaje("label.createaccount"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fondo = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        createAccountLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        createAccount = new javax.swing.JButton();
        accountLabel = new javax.swing.JLabel();
        imagelogin = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        passwrd = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(139, 243, 204));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new java.awt.GridBagLayout());

        fondo.setBackground(new java.awt.Color(139, 243, 204));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 720));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 580, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 580, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 580, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 580, 20));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 580, 20));

        createAccountLabel.setText("Crea una cuenta");
        fondo.add(createAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 33, -1, -1));

        email.setBackground(new java.awt.Color(139, 243, 204));
        email.setBorder(null);
        email.setPreferredSize(new java.awt.Dimension(575, 47));
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });
        fondo.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 323, -1, -1));

        createAccount.setBackground(new java.awt.Color(91, 134, 229));
        createAccount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        createAccount.setForeground(new java.awt.Color(255, 255, 255));
        createAccount.setText("Regístrate");
        createAccount.setToolTipText("Pulsa para registrarte");
        createAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccount.setPreferredSize(new java.awt.Dimension(575, 60));
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        fondo.add(createAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 502, -1, -1));

        accountLabel.setText("¿Ya tienes una cuenta?");
        fondo.add(accountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 580, -1, -1));

        imagelogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notamusical1.png"))); // NOI18N
        fondo.add(imagelogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 84, -1, -1));

        username.setBackground(new java.awt.Color(139, 243, 204));
        username.setBorder(null);
        username.setPreferredSize(new java.awt.Dimension(575, 47));
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });
        fondo.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 246, -1, -1));

        surname.setBackground(new java.awt.Color(139, 243, 204));
        surname.setBorder(null);
        surname.setPreferredSize(new java.awt.Dimension(575, 47));
        surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                surnameKeyPressed(evt);
            }
        });
        fondo.add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 169, -1, -1));

        name.setBackground(new java.awt.Color(139, 243, 204));
        name.setBorder(null);
        name.setPreferredSize(new java.awt.Dimension(575, 47));
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });
        fondo.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 92, -1, -1));

        loginLabel.setForeground(new java.awt.Color(0, 51, 153));
        loginLabel.setText("Inicia Sesión");
        loginLabel.setToolTipText("Pulsa para ir a la pantalla de Login");
        loginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLabelMouseClicked(evt);
            }
        });
        fondo.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, -1, -1));

        passwrd.setBackground(new java.awt.Color(139, 243, 204));
        passwrd.setBorder(null);
        passwrd.setPreferredSize(new java.awt.Dimension(575, 47));
        passwrd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwrdKeyPressed(evt);
            }
        });
        fondo.add(passwrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 400, 580, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(fondo, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al hacer clic en el botón "Create Account".
     * Obtiene los datos ingresados en los campos y verifica que ninguno esté vacío.
     * Llama al controlador de registro para crear un nuevo usuario.
     * Muestra un mensaje de éxito o error según el resultado.
     */
    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        String nombre = name.getText();
        String apellidos = surname.getText();
        String nombreUsuario = username.getText();
        String correo = email.getText();
        String password = passwrd.getText();

        // Verifica que ninguno de los campos esté vacío
        if (nombre.isEmpty() || apellidos.isEmpty() || nombreUsuario.isEmpty() || correo.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos."); // Muestra un mensaje de error si algún campo está vacío
        } else {
            SignupController signupController = new SignupController(interfaz);
            boolean creado = signupController.crearNuevoUsuario(nombre, apellidos, nombreUsuario, correo, password);

            if (creado) {
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");
            } else {
                // Manejar el caso de error al crear el usuario
                JOptionPane.showMessageDialog(this, "Error al crear el usuario. Por favor, inténtalo de nuevo.");
            }
        }
    }//GEN-LAST:event_createAccountActionPerformed

    /**
     * Acción realizada al hacer clic en el enlace "Login".
     * Muestra el panel de inicio de sesión al hacer clic en el enlace "Login".
     */
    private void loginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLabelMouseClicked
        Login loginPanel = new Login(interfaz); // Crear una instancia del panel de inicio de sesión
        interfaz.mostrarPanel(loginPanel); // Mostrar el panel de inicio de sesión al hacer clic en 'Login'
    }//GEN-LAST:event_loginLabelMouseClicked

    // Métodos para manejar el cambio de foco entre campos al presionar 'Enter':
    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            surname.requestFocus(); // Mueve el foco al campo 'surname'
        }
    }//GEN-LAST:event_nameKeyPressed

    private void surnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surnameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            username.requestFocus(); // Mueve el foco al campo 'username'
        }
    }//GEN-LAST:event_surnameKeyPressed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            email.requestFocus(); // Mueve el foco al campo 'email'
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            passwrd.requestFocus(); // Mueve el foco al campo 'passwrd'
        }
    }//GEN-LAST:event_emailKeyPressed

    private void passwrdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwrdKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            createAccountActionPerformed(new java.awt.event.ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_passwrdKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JButton createAccount;
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JTextField email;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel imagelogin;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField passwrd;
    private javax.swing.JTextField surname;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}

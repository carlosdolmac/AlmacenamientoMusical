/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import controller.HibernateHelper;
import controller.LoginController;
import controller.MensajesInternacionales;
import javax.swing.JOptionPane;

/**
 * Panel para el cambio de contraseña.
 * Permite al usuario cambiar su contraseña proporcionando el correo de recuperación.
 *
 * Autor: Carlos de los Dolores Macías
 */
public class ChangePassword extends javax.swing.JPanel {
    private HibernateHelper hibernateHelper;
    private String correoRecuperacion;
    private LoginController loginController;        
    
    /**
     * Crea un nuevo formulario ChangePassword.
     * @param interfaz La interfaz principal.
     * @param correoRecuperacion El correo electrónico de recuperación.
     * @param loginController El controlador de inicio de sesión.
     */
    public ChangePassword(Interfaz interfaz, String correoRecuperacion, LoginController loginController) {
        initComponents();
        this.correoRecuperacion = correoRecuperacion; // Guarda el correo recuperado en esta clase
        hibernateHelper = new HibernateHelper(); // Inicializa HibernateHelper
        this.loginController = loginController; // Inicializa el loginController
        
        changeLabel.setText(MensajesInternacionales.obtenerMensaje("label.cambia"));
        modificarPass.setText(MensajesInternacionales.obtenerMensaje("button.modificar"));
        newPass.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.password"));
        newPass1.putClientProperty( FlatClientProperties.PLACEHOLDER_TEXT, MensajesInternacionales.obtenerMensaje("placeholder.repitepassword"));
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

        fondoChangePassword = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        modificarPass = new javax.swing.JButton();
        imagelogin = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();
        inicioLabel = new javax.swing.JLabel();
        newPass1 = new javax.swing.JPasswordField();
        newPass = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(139, 243, 204));
        setLayout(new java.awt.GridBagLayout());

        fondoChangePassword.setBackground(new java.awt.Color(139, 243, 204));
        fondoChangePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        fondoChangePassword.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 580, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        fondoChangePassword.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 580, 20));

        modificarPass.setBackground(new java.awt.Color(91, 134, 229));
        modificarPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modificarPass.setForeground(new java.awt.Color(255, 255, 255));
        modificarPass.setText("Modificar");
        modificarPass.setToolTipText("Pulsa para modificar la contraseña");
        modificarPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPassActionPerformed(evt);
            }
        });
        fondoChangePassword.add(modificarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 370, 125, 61));

        imagelogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notamusical1.png"))); // NOI18N
        fondoChangePassword.add(imagelogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 84, -1, -1));

        changeLabel.setText("Cambia tu contraseña");
        fondoChangePassword.add(changeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 158, -1, -1));

        inicioLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inicio (1).png"))); // NOI18N
        inicioLabel.setToolTipText("Al hacer click aquí te llevará a la pantalla de Login");
        inicioLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioLabelMouseClicked(evt);
            }
        });
        fondoChangePassword.add(inicioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 484, -1, -1));

        newPass1.setBackground(new java.awt.Color(139, 243, 204));
        newPass1.setBorder(null);
        newPass1.setPreferredSize(new java.awt.Dimension(575, 47));
        newPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newPass1KeyPressed(evt);
            }
        });
        fondoChangePassword.add(newPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 580, -1));

        newPass.setBackground(new java.awt.Color(139, 243, 204));
        newPass.setBorder(null);
        newPass.setPreferredSize(new java.awt.Dimension(575, 47));
        newPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newPassKeyPressed(evt);
            }
        });
        fondoChangePassword.add(newPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 580, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 153;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(fondoChangePassword, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * Acción realizada al hacer clic en el botón 'Modificar'.
    * Verifica si las contraseñas coinciden y realiza el cambio en la base de datos.
    */
    private void modificarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPassActionPerformed
        String newPassword = newPass.getText();
        String confirmPassword = newPass1.getText();

        if (newPassword.equals(confirmPassword)) {
            try {
                // Actualiza la contraseña para el correo recuperado
                hibernateHelper.actualizarPasswordPorCorreo(correoRecuperacion, newPassword);
                JOptionPane.showMessageDialog(
                    null,
                    "Contraseña cambiada exitosamente.",
                    "Cambio Exitoso",
                    JOptionPane.INFORMATION_MESSAGE
                );
                // Realiza alguna acción adicional si es necesario después del cambio de contraseña
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Hubo un problema al cambiar la contraseña. Por favor, intenta de nuevo.",
                    "Error al Cambiar Contraseña",
                    JOptionPane.ERROR_MESSAGE
                );
                e.printStackTrace(); // Maneja el error adecuadamente
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Las contraseñas no coinciden. Por favor, verifica.",
                "Error de Coincidencia",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_modificarPassActionPerformed
    
    /**
    * Acción realizada al hacer clic en la etiqueta 'Inicio'.
    * Muestra el panel de inicio de sesión al hacer clic en la etiqueta 'Inicio'.
    */
    private void inicioLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioLabelMouseClicked
       loginController.mostrarLogin();
    }//GEN-LAST:event_inicioLabelMouseClicked
    
    /**
    * Acción realizada al presionar una tecla en el campo de texto 'newPass1'.
    * Si la tecla presionada es 'ENTER', se ejecuta el evento para modificar la contraseña.
    */
    private void newPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPass1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            modificarPassActionPerformed(new java.awt.event.ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_newPass1KeyPressed
    
    /**
    * Acción realizada al presionar una tecla en el campo de texto 'newPass'.
    * Si la tecla presionada es 'ENTER', se cambia el foco al campo 'newPass1'.
    */
    private void newPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            newPass1.requestFocus(); // Mueve el foco al campo 'newPass1'
        }
    }//GEN-LAST:event_newPassKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changeLabel;
    private javax.swing.JPanel fondoChangePassword;
    private javax.swing.JLabel imagelogin;
    private javax.swing.JLabel inicioLabel;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton modificarPass;
    private javax.swing.JPasswordField newPass;
    private javax.swing.JPasswordField newPass1;
    // End of variables declaration//GEN-END:variables
}

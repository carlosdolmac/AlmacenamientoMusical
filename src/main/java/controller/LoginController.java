/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuarios;
import org.mindrot.jbcrypt.BCrypt;
import view.Interfaz;
import view.Login;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class LoginController {
    private Interfaz interfaz;

    public LoginController(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    public void mostrarLogin() {
        Login login = new Login(interfaz);
        interfaz.mostrarPanel(login);
    }
        
    public void login(String correo, String contraseña) {
        HibernateHelper hibernateHelper = new HibernateHelper(); 
        Usuarios usuario = hibernateHelper.obtenerUsuarioPorCorreo(correo);

        if (usuario != null) {
            String hashAlmacenado = usuario.getPasswrd();
            if (BCrypt.checkpw(contraseña, hashAlmacenado)) {
                // Contraseña correcta, inicia sesión
                interfaz.mostrarDashboard(usuario.getIdUsuario());
            } else {
                // Contraseña incorrecta
                JOptionPane.showMessageDialog(interfaz, "Contraseña incorrecta. Por favor, intenta de nuevo.");
            }
        } else {
            // Usuario no encontrado
            JOptionPane.showMessageDialog(interfaz, "Usuario no encontrado. Por favor, verifica tus credenciales.");
        }
    }


    public void mostrarSignup() {
        SignupController signupController = new SignupController(interfaz);
        signupController.mostrarSignup();
    }
}

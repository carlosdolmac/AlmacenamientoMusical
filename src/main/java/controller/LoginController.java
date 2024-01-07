/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuarios;
import org.mindrot.jbcrypt.BCrypt;
import view.ChangePassword;
import view.Interfaz;
import view.Login;
import view.Password;

/**
 * Controlador para la gestión del inicio de sesión y las operaciones relacionadas.
 * Se encarga de mostrar los distintos paneles de la interfaz y manejar las operaciones de inicio de sesión.
 *
 * Autor: Carlos de los Dolores Macías
 */
public class LoginController {
    private Interfaz interfaz;

    public LoginController(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    // Método para mostrar el panel de inicio de sesión
    public void mostrarLogin() {
        Login login = new Login(interfaz);
        interfaz.mostrarPanel(login);
    }
    
    // Método para mostrar el panel de ingreso de contraseña
    public void mostrarPassword() {
        Password password = new Password(interfaz, this); // Pasa el LoginController
        interfaz.mostrarPanel(password);
    }

    // Método para mostrar el panel de cambio de contraseña
    public void mostrarChangePassword(String correoRecuperacion) {
        ChangePassword changePasswordPanel = new ChangePassword(interfaz, correoRecuperacion, this); // Pasa el LoginController
        interfaz.mostrarPanel(changePasswordPanel);
    }


    // Método para realizar el inicio de sesión
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

    // Método para mostrar el panel de registro
    public void mostrarSignup() {
        SignupController signupController = new SignupController(interfaz);
        signupController.mostrarSignup();
    }
    
}

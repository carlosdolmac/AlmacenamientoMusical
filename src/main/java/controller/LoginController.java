/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
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
        try {
            SQLHelper sqlHelper = new SQLHelper();
            int idUsuario = sqlHelper.obtenerIdUsuario(correo, contraseña);

            if (idUsuario != -1) {
                // Iniciar sesión correctamente
                interfaz.mostrarDashboard(idUsuario);
            } else {
                // Credenciales incorrectas
                JOptionPane.showMessageDialog(interfaz, "Credenciales incorrectas. Por favor, intenta de nuevo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

    public void mostrarSignup() {
        SignupController signupController = new SignupController(interfaz);
        signupController.mostrarSignup();
    }
}

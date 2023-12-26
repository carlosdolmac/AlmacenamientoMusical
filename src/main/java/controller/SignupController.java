/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.Interfaz;
import view.Signup;
/**
 *
 * @author Carlos de los Dolores Macías
 */

public class SignupController {
    private Interfaz interfaz;

    public SignupController(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    public void mostrarSignup() {
        Signup signupPanel = new Signup(interfaz);
        interfaz.mostrarPanel(signupPanel);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Usuarios;
import view.Interfaz;
import view.Signup;
/**
 * Controlador para la gestión del registro de nuevos usuarios.
 * Se encarga de mostrar el panel de registro y manejar la creación de nuevos usuarios en el sistema.
 *
 * Autor: Carlos de los Dolores Macías
 */

public class SignupController {
    private Interfaz interfaz;

    public SignupController(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    /**
     * Método para mostrar el panel de registro
     */
    public void mostrarSignup() {
        Signup signupPanel = new Signup(interfaz);
        interfaz.mostrarPanel(signupPanel);
    }

    /**
     * Método para crear un nuevo usuario en la base de datos
     * @param nombre nombre real del usuario
     * @param apellidos apellidos del usuario
     * @param nombreUsuario nombre del usuario (username)
     * @param correo correo electrónico del usuario
     * @param password contraseña que quiera poner el usuario
     * @return devuelve la creación del usuario con Hibernate
     */
    public boolean crearNuevoUsuario(String nombre, String apellidos, String nombreUsuario, String correo, String password) {
        HibernateHelper hibernateHelper = new HibernateHelper();
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setNombre(nombreUsuario);
        nuevoUsuario.setEmail(correo);
        nuevoUsuario.setPasswrd(password); // Esta contraseña se encriptará en el método crearUsuario

        // Llamar al método en el HibernateHelper para crear el usuario
        return hibernateHelper.crearUsuario(nuevoUsuario);
    }
}


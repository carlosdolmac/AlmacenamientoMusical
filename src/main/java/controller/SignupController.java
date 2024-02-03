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

    /**
     * Constructor de SignupController.
     * @param interfaz La interfaz asociada al controlador.
     */
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
     * Crea un nuevo usuario en la base de datos.
     *
     * @param nombre           Nombre real del usuario.
     * @param apellidos        Apellidos del usuario.
     * @param nombreUsuario    Nombre del usuario (username).
     * @param correo           Correo electrónico del usuario.
     * @param password         Contraseña que el usuario desea establecer.
     * @return                 Devuelve true si la creación del usuario fue exitosa, false en caso contrario.
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


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Usuarios;

/**
 * Gestiona la sesión del usuario actual.
 * Realiza un seguimiento del usuario actualmente conectado.
 * 
 * @author Carlos de los Dolores Macías
 */
public class SessionManager {
    private static Usuarios usuarioActual;

    /**
     * Obtiene el usuario actualmente conectado.
     *
     * @return El usuario actualmente conectado.
     */
    public static Usuarios getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Establece el usuario actualmente conectado.
     *
     * @param usuario El usuario que se establecerá como el usuario actualmente conectado.
     */
    public static void setUsuarioActual(Usuarios usuario) {
        usuarioActual = usuario;
    }
    
    /**
     * Obtiene el ID del usuario actualmente conectado.
     *
     * @return El ID del usuario actualmente conectado, o null si no hay ningún usuario conectado.
     */
    public static Integer getIdUsuarioActual() {
        return usuarioActual != null ? usuarioActual.getIdUsuario() : null;
    }
}


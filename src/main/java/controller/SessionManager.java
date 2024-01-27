/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Usuarios;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class SessionManager {
    private static Usuarios usuarioActual;

    public static Usuarios getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuarios usuario) {
        usuarioActual = usuario;
    }
    
    public static Integer getIdUsuarioActual() {
        return usuarioActual != null ? usuarioActual.getIdUsuario() : null;
    }
}


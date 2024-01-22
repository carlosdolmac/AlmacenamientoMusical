/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.AnadirCancion1;
import view.ListaDeCanciones;
import view.Principal;

/**
 *
 * @author Alumno
 */
public class PrincipalController {
    private Principal principal;

    public PrincipalController(Principal principal) {
        this.principal = principal;
    }
    /**
     * Método para mostrar la ventana de añadir canción.
     */
    public void mostrarAnadirCancion() {
        AnadirCancion1 anadirCancion = new AnadirCancion1();
        principal.mostrarPanel(anadirCancion);
    }

    /**
     * Método para mostrar la lista de canciones.
     */
    public void mostrarListaDeCanciones() {
        ListaDeCanciones listaDeCanciones = new ListaDeCanciones(this);
        principal.mostrarPanel(listaDeCanciones);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.AnadirCancion1;
import view.Biblioteca;
import view.ListaDeCanciones;
import view.Principal;

/**
 * Controlador para la gestión de la página Principal
 * Se encarga de mostrar los distintos paneles del panel Principal
 *
 * Autor: Carlos de los Dolores Macías
 */
public class PrincipalController {
    private Principal principal;

    /**
     * 
     * @param principal Este argumento es el jpanel Principal
     */
    public PrincipalController(Principal principal) {
        this.principal = principal;
    }
    
    /**
     * Método para mostrar la ventana de añadir canción.
     */
    public void mostrarAnadirCancion() {
        AnadirCancion1 anadirCancion = new AnadirCancion1(this); // Pasa 'this' como argumento
        principal.mostrarPanel(anadirCancion);
    }

    /**
     * Método para mostrar el panel lista de canciones.
     */
    public void mostrarListaDeCanciones() {
        ListaDeCanciones listaDeCanciones = new ListaDeCanciones(this);
        principal.mostrarPanel(listaDeCanciones);
    }
    
    public void mostrarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca(this);
        principal.mostrarPanel(biblioteca);
    }
}

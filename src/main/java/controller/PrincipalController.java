/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.AnadirCancion1;
import view.AnadirPlaylist;
import view.Biblioteca;
import view.ListaDeCanciones;
import view.Playlists;
import view.Principal;

/**
 * Controlador para la gestión de la página Principal
 *
 * Autor: Carlos de los Dolores Macías
 */
public class PrincipalController {
    private Principal principal;

    /**
     * Constructor de la clase PrincipalController.
     *
     * @param principal Panel Principal asociado al controlador.
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
     * Método para mostrar la ventana de añadir playlist.
     */
    public void mostrarAnadirPlaylist() {
        AnadirPlaylist anadirPlaylist = new AnadirPlaylist(this); // Pasa 'this' como argumento
        principal.mostrarPanel(anadirPlaylist);
    }

    /**
     * Método para mostrar el panel lista de canciones.
     */
    public void mostrarListaDeCanciones() {
        ListaDeCanciones listaDeCanciones = new ListaDeCanciones(this);
        principal.mostrarPanel(listaDeCanciones);
    }
    
    /**
     * Método para mostrar el panel de playlists.
     */
    public void mostrarPlaylists() {
        Playlists playlists = new Playlists(this);
        principal.mostrarPanel(playlists);
    }
    
    /**
     * Método para mostrar el panel de la biblioteca.
     */
    public void mostrarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca(this);
        principal.mostrarPanel(biblioteca);
    }
}

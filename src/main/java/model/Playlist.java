/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Playlist {
    private int idPlaylist;
    private String nombrePlaylist;

    public Playlist() {
        // Constructor vacío
    }

    public Playlist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    // Getters y setters para idPlaylist y nombrePlaylist
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }
}

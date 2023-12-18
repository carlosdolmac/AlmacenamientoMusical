/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Cancion {
    private int idCancion;
    private String nombreCancion;
    private int idArtista;
    private int idPlaylist;

    public Cancion() {
        // Constructor vacío
    }

    public Cancion(String nombreCancion, int idArtista, int idPlaylist) {
        this.nombreCancion = nombreCancion;
        this.idArtista = idArtista;
        this.idPlaylist = idPlaylist;
    }

    // Getters y setters para idCancion, nombreCancion, idArtista e idPlaylist
    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
}

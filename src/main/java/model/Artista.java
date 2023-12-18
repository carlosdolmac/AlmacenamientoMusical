/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Carlos de los Dolores Macías
 */
public class Artista {
    private int idArtista;
    private String nombreArtista;
    private int edad;

    public Artista() {
        // Constructor vacío
    }

    public Artista(String nombreArtista, int edad) {
        this.nombreArtista = nombreArtista;
        this.edad = edad;
    }

    // Getters y setters para idArtista, nombreArtista y edad
    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
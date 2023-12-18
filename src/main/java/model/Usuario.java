/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Carlos de los Dolores Macías
 */
import java.sql.Timestamp;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private String email;
    private Timestamp ultimaConexion;
    private String nombre;
    private String apellidos;

    public Usuario() {
        // Constructor vacío
    }

    // Getters y Setters para cada campo

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Timestamp ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}

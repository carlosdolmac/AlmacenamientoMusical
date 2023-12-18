/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Carlos de los Dolores Macías
 */
import java.sql.*;

public class SQLHelper {
    private Connection conn = null;

    public SQLHelper() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión con la BBDD ad_musica
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ad_musica", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Para verificar el usuario en el login
    public int obtenerIdUsuario(String email, String passwrd) throws SQLException {
        int idUsuario = -1; // Valor por defecto si no se encuentra un usuario

        String consulta = "SELECT id_usuario FROM Usuarios WHERE email = ? AND passwrd = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(consulta);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, passwrd);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            idUsuario = resultSet.getInt("id_usuario");
        }

        return idUsuario;
    }
    
    //Número de canciones del Usuario
    public int obtenerNumeroCancionesUsuario(int idUsuario) throws SQLException {
        String consulta = "SELECT COUNT(*) AS num_canciones FROM Canciones WHERE id_usuario = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(consulta);
        preparedStatement.setInt(1, idUsuario);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("num_canciones");
        }

        return 0; // Si no se encuentran canciones para el usuario, devuelve 0
    }
}
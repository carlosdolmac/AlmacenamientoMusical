/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Carlos de los Dolores Macías
 */
import java.util.Locale;
import java.util.ResourceBundle;

public class MensajesInternacionales {
    private static ResourceBundle resourceBundle;
    private static final String BASE_NAME = "messages"; // Nombre base de los archivos de propiedades

    static {
        cambiarIdioma(AppState.getCurrentLocale().getLanguage());
    }

    public static void cambiarIdioma(String codigoIdioma) {
        Locale locale = new Locale(codigoIdioma);
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public static String obtenerMensaje(String clave) {
        try {
            return resourceBundle.getString(clave);
        } catch (Exception e) {
            // Manejar la excepción
            return "???" + clave + "???";
        }
    }
}
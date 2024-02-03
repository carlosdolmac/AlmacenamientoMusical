/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 * Clase que maneja mensajes internacionales para la internacionalización del programa.
 * Se encarga de cargar los mensajes en el idioma especificado y proporcionar métodos
 * para obtener mensajes asociados a claves.
 * 
 * @author Carlos de los Dolores Macías
 */
import java.util.Locale;
import java.util.ResourceBundle;

public class MensajesInternacionales {
    private static ResourceBundle resourceBundle;
    private static final String BASE_NAME = "messages"; // Nombre base de los archivos de propiedades

    /**
     * Inicializa el ResourceBundle con el idioma actual del programa.
     */
    static {
        cambiarIdioma(AppState.getCurrentLocale().getLanguage());
    }

    /**
     * Cambia el idioma de los mensajes internacionales.
     * 
     * @param codigoIdioma Código del idioma a cambiar (por ejemplo, "es" para español).
     */
    public static void cambiarIdioma(String codigoIdioma) {
        Locale locale = new Locale(codigoIdioma);
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    /**
     * Obtiene el mensaje asociado a la clave proporcionada.
     * 
     * @param clave Clave del mensaje.
     * @return Mensaje asociado a la clave, o un mensaje de error si la clave no se encuentra.
     */
    public static String obtenerMensaje(String clave) {
        try {
            return resourceBundle.getString(clave);
        } catch (Exception e) {
            // Manejar la excepción
            return "???" + clave + "???";
        }
    }
}
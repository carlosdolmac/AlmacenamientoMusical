/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 * La clase {@code AppState} representa el estado de la aplicación y gestiona el idioma actual.
 * Proporciona métodos para obtener y establecer el idioma actual con fines de internacionalización.
 * 
 * @author Carlos de los Dolores Macías
 */

import java.util.Locale;

public class AppState {
    private static Locale currentLocale = new Locale("es"); // Establece el idioma predeterminado

    /**
     * Obtiene el idioma actual.
     * 
     * @return El idioma actual.
     */
    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    /**
     * Establece el idioma actual.
     * 
     * @param locale El nuevo idioma a establecer.
     */
    public static void setCurrentLocale(Locale locale) {
        currentLocale = locale;
    }
}


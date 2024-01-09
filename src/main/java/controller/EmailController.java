/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 * Controlador para el manejo de correos electrónicos.
 * Este controlador se encarga de generar códigos aleatorios para recuperación de contraseñas
 * y enviarlos a través del protocolo SMTP utilizando la cuenta de correo electrónico configurada.
 *
 * Autor: Carlos de los Dolores Macías
 */
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailController {
    public static String generarCodigoRecuperacion() {
        /**
        * Genera un código de recuperación aleatorio y único.
        * @return El código de recuperación generado.
        */
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    /**
     * Envía un correo electrónico de recuperación de contraseña a la dirección proporcionada.
     * @param userEmail La dirección de correo electrónico del destinatario.
     * @param codigoRecuperacion El código de recuperación a enviar.
     */
    public static void enviarCorreoRecuperacion(String userEmail, String codigoRecuperacion) {
        // Configuración para el servidor SMTP (en este caso, Gmail)
        final String username = "cdm240715@gmail.com"; 
        final String password = "vcjq wgik jtyw bpwh"; 

        // Configuración de propiedades para la conexión con el servidor SMTP de Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.ssl.trust", "*");

        // Creación de la sesión utilizando la autenticación del usuario y contraseña proporcionados
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
             // Creación y configuración del mensaje a enviar
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Código de recuperación de contraseña");
            message.setText("Tu código de recuperación es: " + codigoRecuperacion);

            // Envío del mensaje utilizando la clase Transport
            Transport.send(message);

            System.out.println("Correo enviado con éxito con el código de recuperación.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo con el código de recuperación.");
        }
    }
}


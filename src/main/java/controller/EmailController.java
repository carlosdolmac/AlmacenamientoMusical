/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Carlos de los Dolores Macías
 */
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailController {
    public static String generarCodigoRecuperacion() {
        // Genera un código de recuperación aleatorio y único
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static void enviarCorreoRecuperacion(String userEmail, String codigoRecuperacion) {
        // Configuración para el servidor SMTP
        final String username = "cdm240715@gmail.com"; 
        final String password = "znab eqnm veji nvqk"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.ssl.trust", "*");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Código de recuperación de contraseña");
            message.setText("Tu código de recuperación es: " + codigoRecuperacion);

            Transport.send(message);

            System.out.println("Correo enviado con éxito con el código de recuperación.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo con el código de recuperación.");
        }
    }
}


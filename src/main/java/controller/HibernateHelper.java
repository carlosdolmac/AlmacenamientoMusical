/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Carlos de los Dolores Macías
 */
import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import model.Usuarios;
import org.mindrot.jbcrypt.BCrypt;

public class HibernateHelper {
    private final SessionFactory sessionFactory;

    public HibernateHelper() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public int obtenerIdUsuario(String email, String passwrdEncriptada) {
        int idUsuario = -1;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            List<Usuarios> usuarios = session.createQuery("FROM Usuarios WHERE email = :email", Usuarios.class)
                    .setParameter("email", email)
                    .getResultList();

            for (Usuarios usuario : usuarios) {
                if (BCrypt.checkpw(passwrdEncriptada, usuario.getPasswrd())) {
                    idUsuario = usuario.getIdUsuario();
                    break;
                }
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idUsuario;
    }
    
    public boolean crearUsuario(Usuarios usuario) {
        boolean creado = false;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Encripta la contraseña antes de guardarla
            String passwordEncriptada = BCrypt.hashpw(usuario.getPasswrd(), BCrypt.gensalt());
            usuario.setPasswrd(passwordEncriptada); // Establece la contraseña encriptada en el objeto Usuario

            // Establece la fecha y hora actual como última conexión
            usuario.setUltimaConexion(new Timestamp(System.currentTimeMillis()));

            session.save(usuario);

            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return creado;
    }

    public Usuarios obtenerUsuarioPorCorreo(String email) {
        Usuarios usuario = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            usuario = (Usuarios) session.createQuery("FROM Usuarios WHERE email = :email")
                    .setParameter("email", email)
                    .uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

}
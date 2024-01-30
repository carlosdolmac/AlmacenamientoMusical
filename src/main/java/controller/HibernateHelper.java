/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 * Clase HibernateHelper para operaciones de Hibernate relacionadas con entidades de usuarios.
 * Esta clase proporciona métodos para autenticación, creación, recuperación y actualización de usuarios.
 *
 * Autor: Carlos de los Dolores Macías
 */
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import javax.swing.JOptionPane;
import model.Artistas;
import model.Canciones;
import model.Playlists;
import model.Usuarios;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

public class HibernateHelper {
    private final SessionFactory sessionFactory;

    // Constructor que inicializa el SessionFactory de Hibernate
    public HibernateHelper() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Método para obtener el ID de usuario basado en el correo electrónico y la contraseña encriptada
     * @param email email del usuario
     * @param passwrdEncriptada contraseña encriptada del usuario
     * @return devuelve el id del usuario
     */
    public int obtenerIdUsuario(String email, String passwrdEncriptada) {
        int idUsuario = -1;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Consulta del usuario con el correo electrónico proporcionado
            List<Usuarios> usuarios = session.createQuery("FROM Usuarios WHERE email = :email", Usuarios.class)
                    .setParameter("email", email)
                    .getResultList();

            // Verificación de coincidencia de contraseña para cada usuario recuperado
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
    
    /**
     * Método para crear un nuevo usuario en la base de datos
     * @param usuario se pasa el usuario que se quiera crear
     * @return devuelve el usuario creado
     */
    public boolean crearUsuario(Usuarios usuario) {
        boolean creado = false;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Encripta la contraseña antes de guardarla
            String passwordEncriptada = BCrypt.hashpw(usuario.getPasswrd(), BCrypt.gensalt());
            usuario.setPasswrd(passwordEncriptada); // Establece la contraseña encriptada en el objeto Usuario

            // Establece la fecha y hora actual como última conexión
            usuario.setUltimaConexion(new Timestamp(System.currentTimeMillis()));

            session.save(usuario); // Guardando el usuario en la base de datos

            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return creado;
    }

    /**
     * Método para recuperar un usuario por su correo electrónico
     * @param email este argumento es el email del usuario
     * @return devuelve el usuario asociado al email
     */
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
    
    /**
     * Método para verificar si un correo electrónico dado existe en la base de datos
     * @param correo este argumento es el correo del usuario
     * @return devuelve si existe el correo
     */
    public boolean existeCorreo(String correo) {
        boolean correoExiste = false;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Usuarios usuario = (Usuarios) session.createQuery("FROM Usuarios WHERE email = :email")
                    .setParameter("email", correo)
                    .uniqueResult();

            // Si se encuentra un usuario con ese correo, significa que el correo existe en la base de datos
            correoExiste = usuario != null;

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return correoExiste;
    }

    /**
     * Método para actualizar la contraseña de un usuario dado su correo electrónico
     * @param correo este argumento es el correo del usuario
     * @param nuevaPassword este argumento es la nueva contraseña
     * @throws Exception en caso de que el correo no exista
     */
    public void actualizarPasswordPorCorreo(String correo, String nuevaPassword) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Usuarios usuario = (Usuarios) session.createQuery("FROM Usuarios WHERE email = :email")
                    .setParameter("email", correo)
                    .uniqueResult();

            if (usuario != null) {
                // Encripta la nueva contraseña antes de guardarla
                String passwordEncriptada = BCrypt.hashpw(nuevaPassword, BCrypt.gensalt());
                usuario.setPasswrd(passwordEncriptada); // Establece la nueva contraseña encriptada

                session.update(usuario); // Actualiza el objeto en la base de datos

                session.getTransaction().commit();
            } else {
                throw new Exception("El usuario con correo " + correo + " no existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * Método para obtener todas las canciones de la base de datos
     * @return Lista de todas las canciones
     */
    public List<Canciones> obtenerTodasLasCanciones() {
        List<Canciones> canciones = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            canciones = session.createQuery("FROM Canciones c JOIN FETCH c.artistas", Canciones.class).list();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return canciones;
    }
    
    public void agregarCancion(String nombreCancion, Integer idPlaylist, String artistaNombre) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Obtener el usuario actual (debes implementar este método según tu lógica)
                Usuarios usuario = obtenerUsuarioActual();

                // Verificar si el artista ya existe
                Artistas artista = obtenerArtistaPorNombre(artistaNombre);
                if (artista == null) {
                    // Si no existe, crea un nuevo artista
                    artista = new Artistas(artistaNombre);
                    session.save(artista);
                }

                // Crear la canción y asignar el idPlaylist si no es null
                Canciones cancion = new Canciones(usuario, idPlaylist != null ? obtenerPlaylistPorId(idPlaylist) : null, artista, nombreCancion);
                session.save(cancion);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private Usuarios obtenerUsuarioActual() {
        return SessionManager.getUsuarioActual();
    }

    private Artistas obtenerArtistaPorNombre(String nombre) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Artistas WHERE nombreArtista = :nombre", Artistas.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Obtiene la lista de nombres de playlists del usuario actual desde la base de datos.
     * @return Lista de nombres de playlists.
     */
    public List<String> obtenerNombresPlaylists() {
        List<String> nombresPlaylists = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Obtener el ID del usuario actual
            Integer idUsuarioActual = SessionManager.getIdUsuarioActual();

            // Agregar la opción "null" como la primera opción
            nombresPlaylists.add(null);

            if (idUsuarioActual != null) {
                // Consulta para obtener los nombres de las playlists del usuario actual
                String queryString = "SELECT p.nombrePlaylist FROM Playlists p WHERE p.usuarios.idUsuario = :idUsuario";
                Query<String> query = session.createQuery(queryString, String.class);
                query.setParameter("idUsuario", idUsuarioActual);

                nombresPlaylists.addAll(query.getResultList());
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nombresPlaylists;
    }

    public Integer obtenerIdPlaylistPorNombre(String nombrePlaylist) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Obtener el ID del usuario actual
            Integer idUsuarioActual = SessionManager.getIdUsuarioActual();

            if (idUsuarioActual != null) {
                // Consulta para obtener el ID de la playlist por su nombre y el ID del usuario
                String queryString = "SELECT p.idPlaylist FROM Playlists p WHERE p.usuarios.idUsuario = :idUsuario AND p.nombrePlaylist = :nombrePlaylist";
                Query<Integer> query = session.createQuery(queryString, Integer.class);
                query.setParameter("idUsuario", idUsuarioActual);
                query.setParameter("nombrePlaylist", nombrePlaylist);

                Integer idPlaylist = query.uniqueResult();

                transaction.commit();
                return idPlaylist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Playlists obtenerPlaylistPorId(Integer idPlaylist) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Consulta para obtener la instancia de Playlists por su idPlaylist
                String queryString = "FROM Playlists p WHERE p.idPlaylist = :idPlaylist";
                Query<Playlists> query = session.createQuery(queryString, Playlists.class);
                query.setParameter("idPlaylist", idPlaylist);

                Playlists playlist = query.uniqueResult();

                transaction.commit();
                return playlist;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Canciones> obtenerCancionesUsuarioActual() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Obtener el usuario actual desde la sesión
                Usuarios usuarioActual = SessionManager.getUsuarioActual();

                // Consultar las canciones asociadas al usuario actual
                String queryString = "SELECT c FROM Canciones c JOIN FETCH c.artistas WHERE c.usuarios = :usuario";
                Query<Canciones> query = session.createQuery(queryString, Canciones.class);
                query.setParameter("usuario", usuarioActual);

                List<Canciones> canciones = query.getResultList();

                transaction.commit();
                return canciones;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Playlists> obtenerPlaylistsUsuarioActual() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Obtaining the current user from the session
                Usuarios usuarioActual = SessionManager.getUsuarioActual();

                // Querying playlists and eagerly fetching the cancioneses collection
                String queryString = "SELECT DISTINCT p FROM Playlists p LEFT JOIN FETCH p.cancioneses WHERE p.usuarios = :usuario";
                Query<Playlists> query = session.createQuery(queryString, Playlists.class);
                query.setParameter("usuario", usuarioActual);

                List<Playlists> playlists = query.getResultList();

                transaction.commit();
                return playlists;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int obtenerNumeroCanciones() {
        try (Session session = sessionFactory.openSession()) {
            // Realizar la consulta para contar el número total de canciones
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Canciones", Long.class);
            Long count = query.uniqueResult();
            
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int obtenerNumeroArtistas() {
        try (Session session = sessionFactory.openSession()) {
            // Realizar la consulta para contar el número total de canciones
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Artistas", Long.class);
            Long count = query.uniqueResult();
            
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int obtenerNumeroCancionesPorUsuarioActual() {
        try (Session session = sessionFactory.openSession()) {
            // Obtener el usuario actual desde la sesión
            Usuarios usuarioActual = SessionManager.getUsuarioActual();

            if (usuarioActual != null) {
                // Realizar la consulta para contar el número total de canciones asociadas al usuario
                Query<Long> query = session.createQuery("SELECT COUNT(c) FROM Canciones c WHERE c.usuarios = :usuario", Long.class);
                query.setParameter("usuario", usuarioActual);
                Long count = query.uniqueResult();

                return count != null ? count.intValue() : 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public int obtenerNumeroPlaylistsUsuarioActual() {
        try (Session session = sessionFactory.openSession()) {
            // Obtener el usuario actual desde la sesión
            Usuarios usuarioActual = SessionManager.getUsuarioActual();

            // Realizar la consulta para contar el número total de playlists asociadas al usuario actual
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Playlists p WHERE p.usuarios = :usuario", Long.class);
            query.setParameter("usuario", usuarioActual);
            Long count = query.uniqueResult();

            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public boolean guardarPlaylist(String nombrePlaylist) {
        boolean guardadoExitoso = false;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Obtener el usuario actual
            Usuarios usuarioActual = obtenerUsuarioActual();

            // Comprobar si ya existe una playlist con el mismo nombre para el usuario actual
            Query<Playlists> query = session.createQuery("FROM Playlists WHERE usuarios = :usuario AND nombrePlaylist = :nombre", Playlists.class);
            query.setParameter("usuario", usuarioActual);
            query.setParameter("nombre", nombrePlaylist);

            if (query.getResultList().isEmpty()) {
                // Si no existe, crear y guardar la nueva playlist
                Playlists nuevaPlaylist = new Playlists(usuarioActual, nombrePlaylist, new HashSet<>());
                session.save(nuevaPlaylist);

                session.getTransaction().commit();
                guardadoExitoso = true;
            } else {
                // Mostrar un mensaje de error si ya existe una playlist con ese nombre
                JOptionPane.showMessageDialog(null, "Ya tienes una playlist con ese nombre.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return guardadoExitoso;
    }
    
    public boolean borrarPlaylist(String nombrePlaylist) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Buscar la playlist por nombre
                String queryString = "FROM Playlists p WHERE p.nombrePlaylist = :nombre";
                Query<Playlists> query = session.createQuery(queryString, Playlists.class);
                query.setParameter("nombre", nombrePlaylist);

                Playlists playlist = query.uniqueResult();

                // Verificar si la playlist existe
                if (playlist != null) {
                    // Eliminar la playlist
                    session.delete(playlist);
                    transaction.commit();
                    return true; // Indicar que la eliminación fue exitosa
                } else {
                    // La playlist no existe
                    System.out.println("Playlist no encontrada");
                    return false;
                }
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                return false; // Indicar que la eliminación falló
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Indicar que la eliminación falló
        }
    }
    
    public boolean borrarCancion(String nombreCancion) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Buscar la canción por nombre
                String queryString = "FROM Canciones WHERE nombreCancion = :nombre";
                Canciones cancion = session.createQuery(queryString, Canciones.class)
                        .setParameter("nombre", nombreCancion)
                        .uniqueResult();

                // Verificar si se encontró la canción
                if (cancion != null) {
                    // Borrar la canción
                    session.delete(cancion);
                    transaction.commit();
                    return true;
                } else {
                    // La canción no existe
                    transaction.rollback();
                    return false;
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
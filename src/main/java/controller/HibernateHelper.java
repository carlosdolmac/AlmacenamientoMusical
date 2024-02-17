/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 * Clase HibernateHelper para operaciones de Hibernate 
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
     *
     * @param email            Email del usuario
     * @param passwrdEncriptada Contraseña encriptada del usuario
     * @return El id del usuario
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
     * Método para crear un nuevo usuario en la base de datos.
     *
     * @param usuario Usuario que se quiere crear
     * @return True si se creó correctamente, False si hubo algún error.
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
     * Método para recuperar un usuario por su correo electrónico.
     * 
     * @param email El correo electrónico del usuario.
     * @return El usuario asociado al correo electrónico o null si no se encuentra.
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
     * 
     * @param correo El correo electrónico a verificar.
     * @return true si el correo existe en la base de datos, false si no existe.
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
     * Método para actualizar la contraseña de un usuario dado su correo electrónico.
     * 
     * @param correo        El correo electrónico del usuario.
     * @param nuevaPassword La nueva contraseña a establecer.
     * @throws Exception     Si el correo no existe en la base de datos.
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
     * 
     * @return Lista de todas las canciones
     */
    public List<Canciones> obtenerTodasLasCanciones() {
        List<Canciones> canciones = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Consulta que recupera todas las canciones junto con la información de los artistas asociados
            canciones = session.createQuery("FROM Canciones c JOIN FETCH c.artistas", Canciones.class).list();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return canciones;
    }
    
    /**
     * Método para agregar una canción a la base de datos
     * @param nombreCancion Nombre de la canción a agregar
     * @param idPlaylist    ID de la playlist a la que se puede asociar la canción (puede ser null).
     * @param artistaNombre Nombre del artista de la canción.     
     */
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

    /**
     * Método privado para obtener el usuario actual desde la sesión.
     * 
     * @return El usuario actual.
     */
    private Usuarios obtenerUsuarioActual() {
        return SessionManager.getUsuarioActual();
    }

    /**
     * Método privado para obtener un artista por su nombre desde la base de datos.
     * 
     * @param nombre El nombre del artista a buscar.
     * @return El objeto Artistas correspondiente al nombre proporcionado, o null si no se encuentra.
     */
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
     * 
     * @return Lista de nombres de playlists, incluyendo la opción "null" como la primera opción.
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

    /**
     * Obtiene el ID de una playlist por su nombre y el ID del usuario actual desde la base de datos.
     * 
     * @param nombrePlaylist El nombre de la playlist a buscar.
     * @return El ID de la playlist correspondiente al nombre proporcionado y al usuario actual, o null si no se encuentra.
     */
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

    /**
     * Obtiene la instancia de Playlists por su ID desde la base de datos.
     * 
     * @param idPlaylist El ID de la playlist a buscar.
     * @return La instancia de Playlists correspondiente al ID proporcionado, o null si no se encuentra.
     */
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
    
    /**
     * Obtiene la lista de canciones asociadas al usuario actual desde la base de datos.
     *
     * @return Lista de canciones asociadas al usuario actual o null si hay algún error.
     */
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
    
    /**
     * Obtiene la lista de playlists asociadas al usuario actual desde la base de datos.
     *
     * @return Lista de playlists asociadas al usuario actual o null si hay algún error.
     */
    public List<Playlists> obtenerPlaylistsUsuarioActual() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Obtener el usuario actual desde la sesión
                Usuarios usuarioActual = SessionManager.getUsuarioActual();

                // Consultar playlists y cargar la colección de canciones de forma ansiosa
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

    /**
     * Obtiene el número total de canciones almacenadas en la base de datos.
     *
     * @return Número total de canciones o 0 si hay algún error.
     */
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
    
    /**
     * Obtiene el número total de artistas almacenados en la base de datos.
     *
     * @return Número total de artistas o 0 si hay algún error.
     */
    public int obtenerNumeroArtistas() {
        try (Session session = sessionFactory.openSession()) {
            // Realiza la consulta para contar el número total de canciones
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Artistas", Long.class);
            Long count = query.uniqueResult();
            
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Obtiene el número total de canciones asociadas al usuario actual almacenadas en la base de datos.
     *
     * @return Número total de canciones asociadas al usuario actual o 0 si hay algún error.
     */
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
    
    /**
     * Obtiene el número total de playlists asociadas al usuario actual almacenadas en la base de datos.
     *
     * @return Número total de playlists asociadas al usuario actual o 0 si hay algún error.
     */
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
    
    /**
     * Guarda una nueva playlist para el usuario actual en la base de datos.
     *
     * @param nombrePlaylist Nombre de la nueva playlist.
     * @return true si el guardado fue exitoso, false si ya existe una playlist con el mismo nombre.
     */
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
    
    /**
     * Elimina una playlist por su nombre de la base de datos.
     *
     * @param nombrePlaylist Nombre de la playlist a eliminar.
     * @return true si la eliminación fue exitosa, false si la playlist no existe.
     */
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
    
    /**
     *  Elimina una canción por su nombre de la base de datos.
     *
     * @param nombreCancion Nombre de la canción a eliminar.
     * @return true si la eliminación fue exitosa, false si la canción no existe.
     */
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
    
    /**
    * Modifica una canción existente en la base de datos.
    *
    * @param idCancion      ID de la canción que se va a modificar.
    * @param nombreCancion  Nuevo nombre para la canción.
    * @param idPlaylist     Nuevo ID de la playlist asociada a la canción (puede ser null si no se cambia).
    * @param nombreArtista  Nuevo nombre del artista de la canción.
    * @return true si la modificación fue exitosa, false si la canción no existe.
    */
   public boolean modificarCancion(int idCancion, String nombreCancion, Integer idPlaylist, String nombreArtista) {
       try (Session session = sessionFactory.openSession()) {
           Transaction transaction = session.beginTransaction();

           // Obtener la canción por su ID
           Canciones cancion = session.get(Canciones.class, idCancion);

           if (cancion != null) {
               // Obtener el artista por su nombre
               Artistas artista = obtenerArtistaPorNombre(nombreArtista);

               // Si el artista no existe, crearlo y guardarlo en la base de datos
               if (artista == null) {
                   artista = new Artistas(nombreArtista);
                   session.save(artista);
               }

               // Actualizar los campos de la canción
               cancion.setNombreCancion(nombreCancion);
               cancion.setArtistas(artista);

               // Asignar la nueva playlist si se proporciona un nuevo ID de playlist
               if (idPlaylist != null) {
                   Playlists playlist = session.get(Playlists.class, idPlaylist);
                   cancion.setPlaylists(playlist);
               }

               // Guardar los cambios en la base de datos
               session.update(cancion);

               transaction.commit();
               return true; // Indicar que la modificación fue exitosa
           } else {
               // La canción no existe
               System.out.println("Canción no encontrada");
               return false;
           }
       } catch (Exception e) {
           e.printStackTrace();
           return false; // Indicar que la modificación falló
       }
   }
}
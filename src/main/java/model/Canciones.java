package model;
// Generated 26 dic 2023 12:32:17 by Hibernate Tools 6.3.1.Final

/**
 * Canciones generated by hbm2java
 */
public class Canciones implements java.io.Serializable {

	private Integer idCancion;
	private Usuarios usuarios;
	private Playlists playlists;
	private Artistas artistas;
	private String nombreCancion;

	public Canciones() {
	}

        
	public Canciones(Usuarios usuarios, Playlists playlists, Artistas artistas, String nombreCancion) {
		this.usuarios = usuarios;
		this.playlists = playlists;
		this.artistas = artistas;
		this.nombreCancion = nombreCancion;
	}

	public Integer getIdCancion() {
		return this.idCancion;
	}

	public void setIdCancion(Integer idCancion) {
		this.idCancion = idCancion;
	}

	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Playlists getPlaylists() {
		return this.playlists;
	}

	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}

	public Artistas getArtistas() {
		return this.artistas;
	}

	public void setArtistas(Artistas artistas) {
		this.artistas = artistas;
	}

	public String getNombreCancion() {
		return this.nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

}

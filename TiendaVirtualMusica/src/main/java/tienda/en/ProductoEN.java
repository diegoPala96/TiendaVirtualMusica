package tienda.en;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProductoEN {

	@Id
	@GeneratedValue
	@Column(name = "producto_id")
	private int idProducto;

	@NotNull
	@Size(min = 4, max = 30)
	private String nombre;

	@NotNull
	private String album;

	@NotNull
	private String artista;

	@NotNull
	private String duracion;

	@NotNull
	private String anio;

	@NotNull
	private double precio;

	private boolean editable;

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "producto [idProducto=" + idProducto + ", nombre=" + nombre + ", album=" + album + ", artista=" + artista
				+ ", duracion=" + duracion + ", anio=" + anio + "]";
	}

}

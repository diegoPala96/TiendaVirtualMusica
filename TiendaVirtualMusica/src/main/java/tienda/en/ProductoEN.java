package tienda.en;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class ProductoEN {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private int idProducto;

	@NotNull
	@Size(min = 4, max = 30)
	private String nombre;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "album" )
	private AlbumEN album;

	@NotNull
	private String artista;

	@NotNull
	private String duracion;

	@NotNull
	private String anio;

	@NotNull
	private double precio;
	
	
	//private byte[] imagen;

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


	public AlbumEN getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEN album) {
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

	
	
	@PostConstruct
	public void init() {

		album = new AlbumEN();
		
		//productosListados = (ArrayList<ProductoEN>) productoON.obtenerListaProducto();

	}

//	public void addAlbum(String  descripcion) {
//		
//		
//			if(album==null)
//				album = new AlbumEN();
//			
//			album.setDescripcion(descripcion);
//			
//		
//		// TODO Auto-generated method stub
//		
//	}

}

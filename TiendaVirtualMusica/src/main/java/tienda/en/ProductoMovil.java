package tienda.en;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




public class ProductoMovil  implements Serializable{


	private int idProducto;


	private String nombre;


	private AlbumEN album;


	private String artista;


	private String duracion;

	
	private String anio;


	private double precio;
	

	

	private String imagenProd;



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



	public String getImagenProd() {
		return imagenProd;
	}

	public void setImagenProd(String imagenProd) {
		this.imagenProd = imagenProd;
	}



	
	
	@Override
	public String toString() {
		return "ProductoMovil [idProducto=" + idProducto + ", nombre=" + nombre + ", album=" + album + ", artista="
				+ artista + ", duracion=" + duracion + ", anio=" + anio + ", precio=" + precio + ", imagenProd="
				+ imagenProd + "]";
	}

	@PostConstruct
	public void init() {

		album = new AlbumEN();
		
		//productosListados = (ArrayList<ProductoEN>) productoON.obtenerListaProducto();

	}


}

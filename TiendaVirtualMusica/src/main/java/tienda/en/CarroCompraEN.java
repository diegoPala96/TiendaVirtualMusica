package tienda.en;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarroCompraEN {

	@Id
	@GeneratedValue
	private int idCarro;

	private List<ProductoEN> listaProducto;

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public List<ProductoEN> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<ProductoEN> listaProducto) {
		this.listaProducto = listaProducto;
	}

	@Override
	public String toString() {
		return "CarroCompraEN [idCarro=" + idCarro + ", listaProducto=" + listaProducto + "]";
	}

}

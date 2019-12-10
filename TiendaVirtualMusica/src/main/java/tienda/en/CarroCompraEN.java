package tienda.en;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarroCompraEN {

	@Id
	@GeneratedValue
	private int idCarro;

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	@Override
	public String toString() {
		return "CarroCompraEN [idCarro=" + idCarro + ", listaProducto=";
	}

}

package tienda.en;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CarroCompraEN {

	@Id
	@GeneratedValue
	private int idCarro;

//	@OneToMany
//	private List<ProductoEN> carroList;

	@OneToOne
	private ClienteEN clienteEN;

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

//	public List<ProductoEN> getCarroList() {
//		return carroList;
//	}
//
//	public void setCarroList(List<ProductoEN> carroList) {
//		this.carroList = carroList;
//	}

	public ClienteEN getClienteEN() {
		return clienteEN;
	}

	public void setClienteEN(ClienteEN clienteEN) {
		this.clienteEN = clienteEN;
	}

	@Override
	public String toString() {
		return "CarroCompraEN [idCarro=" + idCarro + ", listaProducto=";
	}

}

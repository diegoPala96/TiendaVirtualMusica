package tienda.en;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarroCompraEN {

	@Id
	private int idCliente;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProductoEN> carroList;

	@OneToOne
	private ClienteEN clienteEN;

	public List<ProductoEN> getCarroList() {
		return carroList;
	}

	public void setCarroList(List<ProductoEN> carroList) {
		this.carroList = carroList;
	}

	public ClienteEN getClienteEN() {
		return clienteEN;
	}

	public void setClienteEN(ClienteEN clienteEN) {
		this.clienteEN = clienteEN;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "CarroCompraEN [idCliente=" + idCliente + ", carroList=" + carroList + ", clienteEN=" + clienteEN + "]";
	}

	public void addProducto(ProductoEN producto) {
		if (carroList == null) {
			carroList = new ArrayList<>();
			System.out.println("lista1");
		}

		this.carroList.add(producto);

	}
}

package tienda.on;

import java.util.List;

import javax.inject.Inject;

import tienda.dao.ClienteDAO;
import tienda.en.ClienteEN;

public class ClienteON {

	@Inject
	private ClienteDAO clienteDAO;

	public void guardar(ClienteEN c) throws Exception {

		if (c.getNombre().length() < 5)
			throw new Exception("Dimension Corta");

		clienteDAO.create(c);

	}

	public List<ClienteEN> getListarCliente() {
		return clienteDAO.getCliente();
	}

}

package tienda.on;

import javax.inject.Inject;

import tienda.dao.CarroCompraDAO;
import tienda.dao.ClienteDAO;
import tienda.en.CarroCompraEN;
import tienda.en.ClienteEN;

public class CarroCompraON {

	@Inject
	private ClienteDAO clienteDAO;

	@Inject
	private CarroCompraDAO carroCompraDAO;

	public void carrito(String idProducto, String idCliente) {

		CarroCompraEN carroCompraEN = new CarroCompraEN();

		ClienteEN clientEN = clienteDAO.read(Integer.parseInt(idCliente));

		carroCompraEN.setClienteEN(clientEN);

		System.out.println("cliente:" + clientEN);

		carroCompraDAO.create(carroCompraEN);

	}

//	@Inject
//	private ClienteDAO clienteDAO;
//
//	public void guardar(ClienteEN c) throws Exception {
//
//		if (c.getNombre().length() < 5)
//			throw new Exception("Dimension Corta");
//
//		clienteDAO.create(c);
//
//	}
//
//	public List<ClienteEN> getListarCliente() {
//		return clienteDAO.getCliente();
//	}
//	
//	
//	public ClienteEN login(String user, String pass) {
//		
//	ClienteEN cli=	clienteDAO.validarLogin(user, pass);
//		//System.out.println(cli.getNombre()+"yyyyyyyyyyyyyyyyy");
//		
//		
//		return  	cli;
//	}

}

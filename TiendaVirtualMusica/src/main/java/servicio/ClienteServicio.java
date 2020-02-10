package servicio;

import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tienda.en.ClienteEN;
import tienda.on.ClienteON;
/**
 * servicio clieente
 * @author Diego , Rotman
 *
 */

@Path("/cliente")
public class ClienteServicio {

	@Inject
	private ClienteON clienteON;

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ClienteEN> listarCliente() {
		List<ClienteEN> listado = clienteON.getListarCliente();

		return listado;

	}

	@POST
	@Path("/insertarCliente")
	@Consumes("application/json")
	@Produces("application/json")
	public ClienteEN insertar(ClienteEN cliente) {
		try {
			clienteON.guardar(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cliente;
	}

	
	
	
	
	
	
	@POST
	@Path("/logeo/{user}/{pass}")
	@Consumes("application/json")
	@Produces("application/json")
	public ClienteEN login(@PathParam("user") String user, @PathParam("pass") String pass) {

		System.out.println("llega solicitud login cliente: " + "user: " + user + " pass: " + pass);

		return clienteON.login(user, pass);
	}
}

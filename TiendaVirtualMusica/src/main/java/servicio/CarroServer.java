package servicio;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tienda.en.ClienteEN;
import tienda.en.ProductoMovil;
import tienda.on.CarroCompraON;

@Path("/carro")
public class CarroServer {

	@Inject
	private CarroCompraON carroCompraON;

	@POST
	@Path("/insertarCarrito/{idProducto}/{idCliente}")
	@Consumes("application/json")
	@Produces("application/json")
	public ClienteEN crearCarro(@PathParam("idProducto") String idProducto, @PathParam("idCliente") String idCliente) {

		System.out.println("llega solicitud login cliente: " + "user: " + idProducto + " pass: " + idCliente);

		carroCompraON.carrito(idProducto, idCliente);
		// return clienteON.login(user, pass);

		return null;
	}

	@GET
	@Path("/listarCarro")
	@Produces("application/json")
	public List<ProductoMovil> obtenerListaCarro(@QueryParam("idCliente") String idProducto) {
		System.out.println("inica consulr=ta en el server");
		return carroCompraON.getListarCarrito(idProducto);
	}

}

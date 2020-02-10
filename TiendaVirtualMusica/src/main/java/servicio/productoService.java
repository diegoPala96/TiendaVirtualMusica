package servicio;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tienda.en.AlbumEN;
import tienda.en.ProductoEN;
import tienda.en.ProductoMovil;
import tienda.on.ProductoON;

/**
 * servicio para producto listar
 * 
 * @author Diego,Rotman
 *
 */
@Path("/producto")
public class productoService {

	@Inject
	private ProductoON productoON;

	/**
	 * Servicio para obtener un listado completo de los producto
	 * 
	 * @return lista de producto
	 */
	@GET
	@Path("listar")
	@Produces("application/json")
	public List<ProductoEN> getLibros() {

		return productoON.obtenerListaProducto();

	}

	
	/**
	 *  petodo para la busqueda segun el nombre de canciones
	 * @param nombre nombre a buscar
	 * @return una lista de los productos 
	 */
	@GET
	@Path("/listarNombre")
	@Produces("application/json")
	public List<ProductoEN> productoNombre(@QueryParam("nombre") String nombre) {
		return productoON.listarPorNombre(nombre);

	}

	
	/**
	 * metod para pasar los producto al cliente en formato jsons se necesito crear un modelo con string
	 * @return un modelo de productoEN con la imagen codificada
	 */
	@GET
	@Path("listarProducto")
	@Produces("application/json")
	public List<ProductoMovil> getProductos() {
		System.out.println("llega servicio");

		List<ProductoMovil> productosMovil = productoON.obtenerListaProductoMovil();
		System.out.println("fin servicio" + productosMovil);


		return productosMovil;

	}
	
	
	
	

}

package servicio;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tienda.en.AlbumEN;
import tienda.en.ProductoEN;
import tienda.on.ProductoON;

@WebService
public class ProductoServiceSOAP {

	@Inject
	private ProductoON productoON;

	@WebMethod
	public List<ProductoEN> getLibros() {

		return productoON.obtenerListaProducto();

	}

	@WebMethod
	public Respuesta crearProducto(ProductoEN productoEN, AlbumEN albumEN) {
		Respuesta r = new Respuesta();
		try {

			productoON.guardar(productoEN, albumEN);
			r.setNombre("insercion correcta");

		} catch (Exception e) {
			r.setNombre("error al insertar");
		}
		return r;

	}
	
	@WebMethod
	public List<ProductoEN> productoNombre(@QueryParam("nombre") String nombre) {
		System.out.println(nombre+"kkkkkkkkkkkkkkkkk");
		return productoON.listarPorNombre(nombre);

	}

}

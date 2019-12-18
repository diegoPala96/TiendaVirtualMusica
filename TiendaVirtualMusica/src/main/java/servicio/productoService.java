package servicio;

import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tienda.ProductoON;
import tienda.en.ProductoEN;

@Path("/producto")
public class productoService {
	
	@Inject
	private ProductoON productoON;
	
	@GET
	@Path("listar")
	@Produces("application/json")
	public List<ProductoEN> getLibros(){
		
		return productoON.obtenerListaProducto();
		 
		
	}
	
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta crearProducto(ProductoEN productoEN ) {
		Respuesta r = new Respuesta();
		try {
		
			productoON.guardar(productoEN);
			r.setNombre("insercion correcta");
			
		}catch (Exception e) {
			r.setNombre("error al insertar");
		}
		return r;
		
		
		
		
	}
	
		

}

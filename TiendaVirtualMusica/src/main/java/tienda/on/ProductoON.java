package tienda.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tienda.dao.ProductoDao;
import tienda.en.ProductoEN;

@Stateless
public class ProductoON {

	@Inject
	private ProductoDao productoDAO;

	public void guardar(ProductoEN producto) {

		productoDAO.insertar(producto);
	}

	public List<ProductoEN> obtenerListaProducto() {
		return productoDAO.obtenerProducto();
	}

	public void eliminar(int id) throws Exception {
		try {
			productoDAO.borrar(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("error" + e.getMessage());
		}
	}

	public List<ProductoEN> editar(ProductoEN producto) {
		// public void editar( int id , String nombre, String album, String
		// duracion,String anio, double precio) {
//		ProductoEN producto = new ProductoEN();
//		producto.setIdProducto(id);
//		producto.setNombre(nombre);
//		producto.setAlbum(album);
//		producto.setDuracion(duracion);
//		producto.setAnio(anio);
//		producto.setPrecio(precio);
//		producto.setEditable(false);
//		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + producto);

		productoDAO.actualizar(producto);

		return productoDAO.obtenerProducto();
	}

	public List<ProductoEN> listarPorNombre(String nombre) {

		return productoDAO.getProductoPorNombre(nombre);

	}

}

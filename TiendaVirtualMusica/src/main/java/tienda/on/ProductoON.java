package tienda.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import tienda.dao.ProductoDao;
import tienda.en.AlbumEN;
import tienda.en.ProductoEN;

@Stateless
public class ProductoON {

	@Inject
	private ProductoDao productoDAO;
	
	@Inject
	private AlbumON albumON;

	public void guardar(ProductoEN producto , AlbumEN album) {

		albumON.guardar(album);
		
		
		producto.setAlbum(albumON.artista(album.getDescripcion()));
		
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



		productoDAO.actualizar(producto);

		return productoDAO.obtenerProducto();
	}

	public List<ProductoEN> listarPorNombre(String nombre) {

		return productoDAO.getProductoPorNombre(nombre);

	}
	
	public ProductoEN getProducto(int codigo) {
		ProductoEN aux = productoDAO.read(codigo);
		System.out.println(aux);
		return aux;
		
	}
	
	


}

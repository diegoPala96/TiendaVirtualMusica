package tienda.on;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tienda.dao.ProductoDao;
import tienda.en.AlbumEN;
import tienda.en.ProductoEN;
import tienda.en.ProductoMovil;

@Stateless
public class ProductoON {

	@Inject
	private ProductoDao productoDAO;

	@Inject
	private AlbumON albumON;

	public void guardar(ProductoEN producto, AlbumEN album) {

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

	public byte[] getProductoImagen(String codigo) {

		ProductoEN aux = productoDAO.read(Integer.parseInt(codigo));
		System.out.println(aux);

		return aux.getImagenProd();

	}

	public List<ProductoMovil> obtenerListaProductoMovil() {

		List<ProductoEN> productosWeb = productoDAO.obtenerProducto();

		List<ProductoMovil> productosMovil = new ArrayList<>();

		for (ProductoEN producto : productosWeb) {
			ProductoMovil movil = new ProductoMovil();

			movil.setIdProducto(producto.getIdProducto());
			movil.setNombre(producto.getNombre());
			movil.setArtista(producto.getArtista());
//			movil.setAlbum(producto.getAlbum());
			movil.setAnio(producto.getAnio());
			movil.setDuracion(producto.getDuracion());
			movil.setPrecio(producto.getPrecio());

//			String base64Encoded = DatatypeConverter.printBase64Binary(producto.getImagenProd());
			movil.setImagenProd(
					"http://localhost:8080/TiendaVirtualMusica/faces/imagen?id=" + producto.getIdProducto());

			productosMovil.add(movil);
		}

		return productosMovil;
	}

}

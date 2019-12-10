package tienda.vista;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import tienda.dao.ProductoDao;
import tienda.en.ProductoEN;

@ManagedBean
public class productoBeen {

	private ProductoEN producto;

	@Inject
	private ProductoDao pDao;

	@PostConstruct
	public void init() {

		producto = new ProductoEN();

	}

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public String crearProducto() {

		pDao.insertar(producto);

		System.out.println(producto);

		return null;

	}

}

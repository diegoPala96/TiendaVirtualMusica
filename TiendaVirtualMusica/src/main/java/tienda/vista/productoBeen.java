package tienda.vista;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import tienda.ProductoON;
import tienda.en.ProductoEN;

@ManagedBean
@RequestScoped
public class productoBeen {

	private ProductoEN producto;

	@Inject
	private ProductoON productoON;

	private ArrayList<ProductoEN> productosListados;

	@PostConstruct
	public void init() {

		producto = new ProductoEN();
		productosListados = (ArrayList<ProductoEN>) productoON.obtenerListaProducto();

	}

	public ProductoEN getProducto() {
		return producto;
	}

	public void setProducto(ProductoEN producto) {
		this.producto = producto;
	}

	public ArrayList<ProductoEN> getProductosListados() {
		return productosListados;
	}

	public void setProductosListados(ArrayList<ProductoEN> productosListados) {
		this.productosListados = productosListados;
	}

	public String crearProducto() {

		productoON.guardar(producto);

		System.out.println(producto);

		return null;

	}

	public void eliminar(int id) {
		try {

			productoON.eliminar(id);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String guardarCambios() {

//		for (ProductoEN productoEN : productosListados) {
//			System.out.println("llego: ======   " + productoEN.getNombre());
//
//		}
	//	productoON.editar();
		return null;
	}

	public String esEditable(ProductoEN producto) {

		producto.setEditable(true);
		return null;
	}
	
	public String edit() {
		
		
	


		//productoON.editar(id, nombre, album,duracion,anio,precio);
		productoON.editar(producto);
		return null;
	}

	

}

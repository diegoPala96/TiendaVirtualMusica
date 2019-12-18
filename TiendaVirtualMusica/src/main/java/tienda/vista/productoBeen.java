package tienda.vista;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

import tienda.ProductoON;
import tienda.en.ProductoEN;

@ManagedBean
@SessionScoped
public class productoBeen {

	private ProductoEN producto;

	@Inject
	private ProductoON productoON;

	private ArrayList<ProductoEN> productosListados; 



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String nombre;

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
		init();
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



	public String esEditable(ProductoEN producto) {

		producto.setEditable(true);
		return null;
	}

	public String edit() {

		productosListados = (ArrayList<ProductoEN>)productoON.editar(producto);
		init();
		return null;
	}

	public String busqueda(String nombreb) {


		System.out.println("nombre busqueda: "+ nombreb);


		//productoON.editar(id, nombre, album,duracion,anio,precio);
		productosListados = (ArrayList<ProductoEN>)productoON.listarPorNombre(nombreb);
		return null;
	}

	public String  nuevoproducto() {

		producto = new ProductoEN();

		return "nuevoProducto";
	}



}

package tienda.vista;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


import tienda.en.AlbumEN;
import tienda.en.ProductoEN;
import tienda.on.AlbumON;
import tienda.on.ProductoON;

@ManagedBean
@SessionScoped
public class productoBeen {

	private ProductoEN producto;
	private AlbumEN album;
	

	private ArrayList<ProductoEN> productosListados;
	
	private String nombre;
	private String temAlbum;
	
	private int id;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Inject
	private ProductoON productoON;
	
	@Inject
	private AlbumON albumON;

	

	@PostConstruct
	public void init() {

		producto = new ProductoEN();
		album= new AlbumEN();

		productosListados = (ArrayList<ProductoEN>) productoON.obtenerListaProducto();

	}
	
	
//	public String editar(String id) {
//		
//		System.out.println("buscar +"+id);
//	//	return "TipoGeografia?faces-redirect=true&id=" + id;
//		return "editarproducto";
//	}

	
	


	public String crearProducto() {
		//System.out.println("fdfnfgkfd----------------------" + temAlbum);
		//album.setDescripcion(temAlbum);
		
		albumON.guardar(album);
		
		
		producto.setAlbum(albumON.artista(album.getDescripcion()));
		
		// AlbumEN albumm= new AlbumEN();

		// albumm.setDescripcion("albummanytoone");
		// producto.setAlbum(many.setDescripcion("jhjh"));

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
		
		album.setDescripcion(producto.getAlbum().getDescripcion());
		albumON.guardar(album);
		producto.setAlbum(albumON.artista(album.getDescripcion()));
		productosListados = (ArrayList<ProductoEN>) productoON.editar(producto);
		init();
		return null;
	}

	public String busqueda(String nombreb) {

		System.out.println("nombre busqueda: " + nombreb);

		// productoON.editar(id, nombre, album,duracion,anio,precio);
		productosListados = (ArrayList<ProductoEN>) productoON.listarPorNombre(nombreb);
		return null;
	}

	public String nuevoproducto() {

		producto = new ProductoEN();

		return "nuevoProducto";
	}

	public String getTemAlbum() {
		return temAlbum;
	}

	public void setTemAlbum(String temAlbum) {
		this.temAlbum = temAlbum;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AlbumEN getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEN album) {
		this.album = album;
	}
	

	
	public void loadDatos() {
		if(id==0)
			return;
		System.out.println("codigo editar dos " + this.id);
		producto = productoON.getProducto(this.id);
		System.out.println("recupera");
		if(producto == null) {
			producto = new ProductoEN();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Registro no existe", "Información");
			//fc.addMessage(null, msg);
			System.out.println("producto=null");
		}
			
		
		System.out.println(producto);
	}
	
	public String editar(int codigo) {
		//System.out.println("codigo editar " + codigo);
		
		//persona = pON.getPersona(codigo);
		//System.out.println(persona);
		
		return "editarProducto?faces-redirect=true&id="+codigo;
	}
	
	
	
	

}

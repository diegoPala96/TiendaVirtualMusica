package tienda.vista;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.ibm.wsdl.util.IOUtils;

import tienda.en.AlbumEN;
import tienda.en.ProductoEN;
import tienda.on.AlbumON;
import tienda.on.ProductoON;








@ManagedBean
@SessionScoped
//@Named()
//@RequestScoped
public class productoBeen  implements Serializable{

	private ProductoEN producto;
	private AlbumEN album;
	
	@Inject
	private ProductoON productoON;
	
	@Inject
	private AlbumON albumON;

	

	private ArrayList<ProductoEN> productosListados;
	
	private String nombre;
	private String temAlbum;
	
	private String imagenProducto;
	
	public String getImagenProducto() {
		return imagenProducto;
	}


	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	private int id;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	

	@PostConstruct
	public void init() {

		producto = new ProductoEN();
		album= new AlbumEN();

		productosListados = (ArrayList<ProductoEN>) productoON.obtenerListaProducto();

	}
	


	
	


	public String crearProducto() {
		
		
		try (InputStream input = uploadedFile.getInputStream()) {
			producto.setImagenProd(toByteArray(input));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		// AlbumEN albumm= new AlbumEN();

		// albumm.setDescripcion("albummanytoone");
		// producto.setAlbum(many.setDescripcion("jhjh"));

		productoON.guardar(producto, album);

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



	public String edit() {
		
		album.setDescripcion(producto.getAlbum().getDescripcion());
		albumON.guardar(album);
		producto.setAlbum(albumON.artista(album.getDescripcion()));
		productosListados = (ArrayList<ProductoEN>) productoON.editar(producto);
		init();
		return "producto";
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

  
	/**
	 * Metodo para subir imagen al servidor
	 * @param event
	 */
//	public void subirImagen(FileUploadEvent event) {
//		
//		System.out.println("dosss");
//		try {
//			producto.setImagenProd(event.getFile().getContents());
//			imagenProducto=UtilJSF.guardaBlobEnFicheroTemporal(producto.getImagenProd(),
//					event.getFile().getFileName());
//			
//		} catch (Exception e) {
//			System.out.println("error al cargar la imagen productobeen");
//		}
//		
//		
//	}
	
	
	
	

//	public void listener(FileUploadEvent event) throws Exception {
//        UploadedFile item = event.getFile();
//        producto.setImagenProd(item.getContents());
//     System.out.println("imagen");
//       
//
//    }
	

	
	private Part uploadedFile;
	private String folder = "c:\\files";

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	
	public void saveFile(){
		
		try (InputStream input = uploadedFile.getInputStream()) {
//			String fileName = uploadedFile.getSubmittedFileName();
//			System.out.println(folder+"\\"+fileName);
//			String path=folder+"\\"+fileName;
//			
//			
//			
//			//Files.copy(input, new File(folder, fileName).toPath());
//	
//			
//			
//			File fi = new File(path);
//			toByteArray(input);
//			// Files.readAllBytes(Path);
			
	        
	        producto.setImagenProd(toByteArray(input));
	        
	        
	      

	    
	        ByteArrayInputStream bis = new ByteArrayInputStream(producto.getImagenProd());
	        BufferedImage bImage2 = ImageIO.read(bis);
	        ImageIO.write(bImage2, "jpg", new File(folder,"output.jpg") );

	        
	        
	        
	        
	        
	  
	   
	        
	        
	        
	        
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	
	
	}


	public static byte[] toByteArray(InputStream in) throws IOException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
System.out.println("tamano imagen ");
		



//byte[] imageInBytes = IOUtils.toByteArray(in);



		byte[] buffer = new byte[2048];
		
		int len;

		// read bytes from the input stream and store them in buffer
		while ((len = in.read(buffer)) != -1) {
			// write bytes from the buffer into output stream
			os.write(buffer, 0, len);
		}

		return os.toByteArray();
	}
	
	
	
	
	
	
	
	
	

}

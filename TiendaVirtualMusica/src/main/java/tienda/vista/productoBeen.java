package tienda.vista;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import tienda.dao.ProductoDao;
import tienda.en.Producto;

@ManagedBean
public class productoBeen {
	
private Producto producto;

@Inject
private ProductoDao pDao;


@PostConstruct
public void init() {
	
	producto = new Producto();
	
}








public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
}



public String crearProducto() {
	
	pDao.insertar(producto);
	
	System.out.println(producto);
	
	return null;
	
}


}

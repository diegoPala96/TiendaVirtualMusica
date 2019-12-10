package tienda.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import tienda.en.Producto;

//combirtio a un ejb sin estado
@Stateless
public class ProductoDao {

	@Inject
	private EntityManager em;
	
	public void insertar(Producto producto) {
		
		em.persist(producto);

	}
	public void actualizar(Producto producto) {
		em.merge(producto);

	}
	public void borrar(String nombre) {
		em.remove(leer(nombre));

	}
	public Producto leer(String nombre) {
		em.find(Producto.class, nombre);
		
		return null;
	}




}

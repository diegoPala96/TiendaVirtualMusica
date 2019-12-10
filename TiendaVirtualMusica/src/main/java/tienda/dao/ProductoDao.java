package tienda.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import tienda.en.ProductoEN;

//combirtio a un ejb sin estado
@Stateless
public class ProductoDao {

	@Inject
	private EntityManager em;

	public void insertar(ProductoEN producto) {

		em.persist(producto);

	}

	public void actualizar(ProductoEN producto) {
		em.merge(producto);

	}

	public void borrar(String nombre) {
		em.remove(leer(nombre));

	}

	public ProductoEN leer(String nombre) {
		em.find(ProductoEN.class, nombre);

		return null;
	}

}

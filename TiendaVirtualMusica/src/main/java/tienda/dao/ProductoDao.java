package tienda.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		//em.refresh(producto);
		em.merge(producto);

	}

	public ProductoEN leer(int id) {

		return em.find(ProductoEN.class, id);
	}

	public void borrar(int id) {
		em.remove(leer(id));

	}

	public List<ProductoEN> obtenerProducto() {

		String jpql = "SELECT p FROM ProductoEN p";
		Query q = em.createQuery(jpql, ProductoEN.class);

		List<ProductoEN> producto = q.getResultList();

		return producto;
	}

}

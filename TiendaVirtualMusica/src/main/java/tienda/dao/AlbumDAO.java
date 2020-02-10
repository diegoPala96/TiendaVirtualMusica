
package tienda.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import tienda.en.AlbumEN;


//combirtio a un ejb sin estado
@Stateless
public class AlbumDAO {

	@Inject
	private EntityManager em;
	


	public void insertar(AlbumEN album) {
		

		
			em.persist(album);
		

	}
	
	/**
	 * actualizar AlbumEN
	 * @param album
	 */
	public void actualizar(AlbumEN album) {
		// em.refresh(producto);
		em.merge(album);

	}

	public AlbumEN leer(int id) {

		return em.find(AlbumEN.class, id);
	}

//	public void borrar(int id) {
//		em.remove(leer(id));
//
//	}

	public List<AlbumEN> obtenerAlbum() {

		String jpql = "SELECT p FROM AlbumEN p";
		Query q = em.createQuery(jpql, AlbumEN.class);

		List<AlbumEN> album = q.getResultList();

		return album;
	}

	public List<AlbumEN> getArtista(String nombre) {
		String jpql = "SELECT c FROM AlbumEN c WHERE c.descripcion LIKE :nombre ";

		Query q = em.createQuery(jpql, AlbumEN.class);
		q.setParameter("nombre", "%" + nombre + "%");

		List<AlbumEN> producto = q.getResultList();

	
		
		return producto;
	}
	
	public AlbumEN getNombreArtista(String nombre) {
		String jpql = "SELECT c FROM AlbumEN c WHERE c.descripcion = :nombre ";

		Query q = em.createQuery(jpql, AlbumEN.class);
		q.setParameter("nombre", nombre );

		AlbumEN producto =  (AlbumEN) q.getSingleResult();

		
		
		return producto;
	}
	
	


	
}

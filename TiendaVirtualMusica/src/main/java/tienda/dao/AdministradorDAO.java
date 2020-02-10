package tienda.dao;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import tienda.en.AdministradorEN;


/**
 * capa de acceso a datos 
 * @author Diego, Rotman
 *
 */
@Stateless
public class AdministradorDAO {

	@Inject
	private EntityManager em;


	
	/**
	 * permite autentificar el acceso a la plataforma para el administrados
	 * @param usuario 
	 * @param passwd
	 * @return el objeto al la capa de negocio
	 */
	public AdministradorEN autenticar(String usuario, String passwd) {
		String jpql = "SELECT c FROM AdministradorEN c "
				+ " WHERE c.usuario=:usuario AND c.password=:passwd"; 
		Query query = em.createQuery(jpql, AdministradorEN.class);
		query.setParameter("usuario", usuario);
		query.setParameter("passwd", passwd);
		AdministradorEN admin = null;
		try {
			admin=	(AdministradorEN)query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
		
		
		return admin;
	}

	

}

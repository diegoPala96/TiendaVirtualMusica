package tienda.dao;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import tienda.en.AdministradorEN;


//combirtio a un ejb sin estado
@Stateless
public class AdministradorDAO {

	@Inject
	private EntityManager em;


	
	
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

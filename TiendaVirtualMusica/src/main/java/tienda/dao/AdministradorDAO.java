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

	


	

	

	

	public AdministradorEN getUsuarioe(String usuario,String password) {
		String jpql = "SELECT c FROM AdministradorEN c WHERE c.usuario =:usuario AND c.password =:password ";
	
		

		//System.out.println("uno..: "+jpql);

		Query q = em.createQuery(jpql, AdministradorEN.class);
		q.setParameter("usuario",   usuario );
		q.setParameter("password", password  );

		AdministradorEN administrador = (AdministradorEN) q.getSingleResult();
		System.out.println("dos");
		
		return administrador;
	}
	
	
	
	public List<AdministradorEN> autenticar(String usuario, String passwd) {
		String jpql = "SELECT c FROM AdministradorEN c "
				+ " WHERE c.usuario=:usuario AND c.password=:passwd"; 
		Query query = em.createQuery(jpql, AdministradorEN.class);
		query.setParameter("usuario", usuario);
		query.setParameter("passwd", passwd);
		List<AdministradorEN> admin = query.getResultList();
		
		
		return admin;
	}

	

}

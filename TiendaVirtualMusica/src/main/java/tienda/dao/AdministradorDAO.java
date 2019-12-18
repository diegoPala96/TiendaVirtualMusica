package tienda.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import tienda.en.AdministradorEN;
import tienda.en.ProductoEN;

//combirtio a un ejb sin estado
@Stateless
public class AdministradorDAO {

	@Inject
	private EntityManager em;

	


	

	

	

	public List<AdministradorEN> getUsuarioe(String usuario,String password) {
		String jpql = "SELECT c FROM Administrador c WHERE c.usuario = :usuario AND c.password = :password ";
	
		

		System.out.println("uno..: "+jpql);

		Query q = em.createQuery(jpql, AdministradorEN.class);
		q.setParameter("usuario", "%" + usuario + "%");
		q.setParameter("password","%" + password + "%" );

		List<AdministradorEN> administrador = q.getResultList();

		
		return administrador;
	}

}

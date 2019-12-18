package tienda.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import tienda.en.ClienteEN;

@Stateless
public class ClienteDAO {

	@Inject
	private EntityManager em;

	public void create(ClienteEN c) {
		em.persist(c);
	}

	public ClienteEN read(String cedula) {
		return em.find(ClienteEN.class, cedula);
	}

	public void update(ClienteEN c) {
		em.merge(c);
	}

	public void delete(String cedula) {
		ClienteEN c = read(cedula);
		em.remove(c);
	}

	public List<ClienteEN> getCliente() {
		String jpql = "SELECT c FROM ClienteEN c";

		Query q = em.createQuery(jpql, ClienteEN.class);

		List<ClienteEN> cliente = q.getResultList();
		return cliente;
	}

}

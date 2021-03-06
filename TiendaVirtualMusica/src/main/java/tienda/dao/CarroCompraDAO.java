package tienda.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import tienda.en.CarroCompraEN;

@Stateless
public class CarroCompraDAO {

	@Inject
	private EntityManager em;

//	public List<CarroCompraEN> obtenerProducto(int id) {
//
//		String jpql = "SELECT p FROM CarroCompraEN p where clienteEn =: idciente ";
//		Query q = em.createQuery(jpql, ProductoEN.class);
//
//		List<CarroCompraEN> producto = q.getResultList();
//		System.out.println(producto + "------------------------");
//		return producto;
//	}

	public void create(CarroCompraEN c) {
		System.out.println("llama create");
		em.persist(c);
	}

//
	public CarroCompraEN read(int idCarro) {

		return em.find(CarroCompraEN.class, idCarro);
	}

//
	public void update(CarroCompraEN c) {
		System.out.println("llama uodate");
		em.merge(c);
	}

	public void save(CarroCompraEN p) {
		if (this.read(p.getIdCliente()) != null)
			this.update(p);
		else
			this.create(p);

	}

//
//	public void delete(String cedula) {
//		CarroCompraEN c = read(cedula);
//		em.remove(c);
//	}
//
//	public List<CarroCompraEN> getCliente() {
//		String jpql = "SELECT c FROM CarroCompraEN c";
//
//		Query q = em.createQuery(jpql, CarroCompraEN.class);
//
//		List<CarroCompraEN> cliente = q.getResultList();
//		return cliente;
//	}
//
//	public CarroCompraEN obtenerCarro(String user, String pass) {
//
//		String jpql = "SELECT c FROM CarroCompraEN c WHERE c.usuario =:usuario AND c.password =:password";
//
//		System.out.println("llege cliente dao");
//		Query q = em.createQuery(jpql, CarroCompraEN.class);
//		q.setParameter("usuario", user);
//		q.setParameter("password", pass);
//
//		return (ClienteEN) q.getSingleResult();
//
//	}

}

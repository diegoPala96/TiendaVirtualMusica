package tienda.on;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import tienda.dao.CarroCompraDAO;
import tienda.dao.ClienteDAO;
import tienda.dao.ProductoDao;
import tienda.en.CarroCompraEN;
import tienda.en.ClienteEN;
import tienda.en.ProductoEN;
import tienda.en.ProductoMovil;

public class CarroCompraON {

	@Inject
	private ClienteDAO clienteDAO;

	@Inject
	private ProductoDao productoDao;

	@Inject
	private CarroCompraDAO carroCompraDAO;

	private CarroCompraEN carroCompraEN;

	public void carrito(String idProducto, String idCliente) {

		carroCompraEN = new CarroCompraEN();

		ClienteEN clientEN = clienteDAO.read(Integer.parseInt(idCliente)); // cliente
		// System.out.println(clientEN + "cliente nuevo palacios");

		/***
		 * considerar quitar if
		 */
		if (clientEN != null) {

			ProductoEN productoEN = productoDao.leer(Integer.parseInt(idProducto)); // producto
			if (productoEN != null) {

				carroCompraEN = carroCompraDAO.read(Integer.parseInt(idCliente));

				if (carroCompraEN != null) {
					System.out.println("update4");
					carroCompraEN.addProducto(productoEN);

					carroCompraDAO.update(carroCompraEN);

				} else {
					System.out.println("create4");
					carroCompraEN = new CarroCompraEN();

					carroCompraEN.setIdCliente(Integer.parseInt(idCliente));
					// List<ProductoEN> listaProducto = new ArrayList<>();
					carroCompraEN.setClienteEN(clientEN);
					System.out.println("cliente: " + clientEN);
					// System.out.println("producto: " + productoEN);
//
//					List<ProductoEN> listadeProducto = new ArrayList<>();
//					listadeProducto.add(productoEN);
//					carroCompraEN.addProducto(productoEN);

					System.out.println(carroCompraEN + "carro con producto");
//					listaProducto.add(productoEN);
//
//					carroCompraEN.setCarroList(listadeProducto);

					carroCompraDAO.create(carroCompraEN);

//					productoEN = productoDao.leer(Integer.parseInt(idProducto));
//					List<ProductoEN> listadeProducto = new ArrayList<>();
//					listadeProducto.add(productoEN);
//					carroCompraDAO.update(carroCompraEN);
					// carroCompraEN.addProducto(productoEN);
				}

			} else {

				System.out.println("no existe  producto");
			}

		} else {

			System.out.println("no existe cliente");
		}
		// System.out.println("12345" + carroCompraEN);
		// carroCompraDAO.save(carroCompraEN);

	}
	
	public void eliminarCarrito(String idProducto, String idCliente) {

		carroCompraEN = new CarroCompraEN();


				carroCompraEN = carroCompraDAO.read(Integer.parseInt(idCliente));
				
				List<ProductoEN> listaProducto = new ArrayList<>();
			listaProducto=	carroCompraEN.getCarroList();
			
			List<ProductoEN> listaProducto2 = new ArrayList<>();
			for (ProductoEN productoEN : listaProducto) {
			
				if(productoEN.getIdProducto() == 	Integer.parseInt(idCliente)){
					
					System.out.println("igual");
				}
				else {
					listaProducto2.add(productoEN);
					System.out.println("diferente");
					
				}
				
				carroCompraEN.setCarroList(listaProducto2);
				carroCompraDAO.update(carroCompraEN);
				
			}
			
			
			
			
			

//				if (carroCompraEN != null) {
//					System.out.println("update4");
//					carroCompraEN.addProducto(productoEN);
//
//					carroCompraDAO.update(carroCompraEN);
//
//				} else {
//					System.out.println("create4");
//					carroCompraEN = new CarroCompraEN();
//
//					carroCompraEN.setIdCliente(Integer.parseInt(idCliente));
//					// List<ProductoEN> listaProducto = new ArrayList<>();
//					carroCompraEN.setClienteEN(clientEN);
//					System.out.println("cliente: " + clientEN);
//					// System.out.println("producto: " + productoEN);
////
////					List<ProductoEN> listadeProducto = new ArrayList<>();
////					listadeProducto.add(productoEN);
////					carroCompraEN.addProducto(productoEN);
//
//					System.out.println(carroCompraEN + "carro con producto");
////					listaProducto.add(productoEN);
////
////					carroCompraEN.setCarroList(listadeProducto);
//
//					carroCompraDAO.create(carroCompraEN);
//
////					productoEN = productoDao.leer(Integer.parseInt(idProducto));
////					List<ProductoEN> listadeProducto = new ArrayList<>();
////					listadeProducto.add(productoEN);
////					carroCompraDAO.update(carroCompraEN);
//					// carroCompraEN.addProducto(productoEN);
//				}
//
//			} else {
//
//				System.out.println("no existe  producto");
//			}
//
//		} else {
//
//			System.out.println("no existe cliente");
//		}
//		// System.out.println("12345" + carroCompraEN);
//		// carroCompraDAO.save(carroCompraEN);

	}
	

	public List<ProductoMovil> getListarCarrito(String id) {

		// ProductoEN productoEN = new ProductoEN();
		List<ProductoEN> listProductoEN = new ArrayList<>();
		List<ProductoMovil> listProMov = new ArrayList<>();
		System.out.println("creacion array");

		CarroCompraEN carro = carroCompraDAO.read(Integer.parseInt(id));

		if (carro != null) {
			// System.out.println(" existe carro: " + carro)
			System.out.println("llega");

			for (ProductoEN productoEN : carro.getCarroList()) {
				System.out.println("pasar al movil");

				ProductoMovil proMov = new ProductoMovil();
				proMov.setIdProducto(productoEN.getIdProducto());
				proMov.setNombre(productoEN.getNombre());
				// proMov.setAlbum(productoEN.getAlbum());
				proMov.setArtista(productoEN.getAnio());
				proMov.setDuracion(productoEN.getDuracion());
				proMov.setAnio(productoEN.getAnio());
				proMov.setPrecio(productoEN.getPrecio());

				listProMov.add(proMov);
			}

			return listProMov;

		} else {
			System.out.println("no existe carro");
			return null;
		}

	}

}

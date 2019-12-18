package tienda;

import java.util.List;

import javax.inject.Inject;

import tienda.dao.AdministradorDAO;
import tienda.en.AdministradorEN;
import tienda.en.ProductoEN;

public class AdministradorON {
	
	@Inject
	private AdministradorDAO administradorDAO;
	
public List<AdministradorEN> listarPorNombre(String nombre, String password) {
		
	List<AdministradorEN> administrador = administradorDAO.getUsuarioe(nombre, password);
	if (administrador!= null) {
		System.out.println("login nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		
	}
	
		return administradorDAO.getUsuarioe(nombre, password);
		
		
		
	}
	
	
	

}

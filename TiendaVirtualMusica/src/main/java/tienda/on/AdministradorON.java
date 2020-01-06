package tienda.on;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import tienda.dao.AdministradorDAO;
import tienda.en.AdministradorEN;
import tienda.en.ProductoEN;

public class AdministradorON {
	
	@Inject
	private AdministradorDAO administradorDAO;
	
public List<AdministradorEN> listarPorNombre(String nombre, String password) {
	System.out.println("inicio para loging..................................");		
	 AdministradorEN administrador = administradorDAO.getUsuarioe(nombre, password);

	
	if (administrador.getUsuario()!=null) {
		System.out.println("login nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnno");
		
	}
	else {
		
		System.out.println("login si");
	}
	
		return null;
		
		
		
	}
	



public boolean autenticarDocente(String usuario, String passwd){
	
	 List<AdministradorEN> list= administradorDAO.autenticar(usuario, passwd);
	 if (list.size()>0) {
		 System.out.println("login correcto");
		 return true;
		 
	 }else {
		 
		return false;
	 }
	 

	 
	//return administradorDAO.autenticar(usuario, passwd);
	
}


	
	

}

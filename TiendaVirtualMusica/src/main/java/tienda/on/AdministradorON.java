package tienda.on;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import tienda.dao.AdministradorDAO;
import tienda.en.AdministradorEN;


public class AdministradorON {
	
	@Inject
	private AdministradorDAO administradorDAO;
	

	



public AdministradorEN autenticarAdministrador(String usuario, String passwd){
	
	 AdministradorEN list= administradorDAO.autenticar(usuario, passwd);
	return list;
	 

	 
	//return administradorDAO.autenticar(usuario, passwd);
	
}


	
	

}

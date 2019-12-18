package tienda.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import tienda.en.ProductoEN;
import tienda.on.AdministradorON;
import tienda.on.ProductoON;

@ManagedBean
@SessionScoped
public class sesionBeen {
	
	
	@Inject
	private  AdministradorON administradorON;
	
	private String usuario;
	private String password;
	
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String busqueda(String usuario, String password) {
		
		
		System.out.println("nombre busqueda: "+ usuario +password);


		administradorON.listarPorNombre(usuario, password);
		
		return null;
	}
	

	
	

}

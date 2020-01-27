package tienda.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.enterprise.context.control.RequestContextController;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

//import org.primefaces.context.RequestContext;

import tienda.en.AdministradorEN;

import tienda.on.AdministradorON;
import util.SessionUtils;



@ManagedBean
@SessionScoped
public class sesionBeen {
	
	
	@Inject
	private  AdministradorON administradorON;
	
	private AdministradorEN administrador;
	
	
	private FacesContext facesContext;

	
	
	
	
	public AdministradorEN getAdministrador() {
		return administrador;
	}

	public void setAdministrador(AdministradorEN administrador) {
		this.administrador = administrador;
	}

	@PostConstruct
	public void init() {

		administrador = new AdministradorEN();
		

	}
	
	


	public String busqueda() {
		
		
		System.out.println("nombre busqueda: "+ administrador.getUsuario()+ administrador.getPassword());


		administrador= administradorON.autenticarAdministrador(administrador.getUsuario(), administrador.getPassword());
		
		
		 if(administrador != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", administrador.getNombre());
			//return "crear-alumno";
			

			 
			return "producto";
		 }
		 else {
			 administrador= new AdministradorEN();
			 facesContext= FacesContext.getCurrentInstance();
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en clave y/o contrasena", "ERROR");
			facesContext.addMessage(null, m);

			  return null;
			 }
		 
		 
		
		
		
	
	}
	
//	public void login(ActionEvent actionEvent) {
//		
//		
//		// RequestContext context = RequestContext.getCurrentInstance();
//		 
//		 FacesMessage msg = null;
//		 boolean loggedIn = false;
//		 String ruta = "";
//		 
//		 
//		 administrador= administradorON.autenticarAdministrador(administrador.getUsuario(), administrador.getPassword());
//			
//		 if(administrador != null) {
//			 loggedIn= true;
//			 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", administrador.getUsuario());
//			 msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido ",administrador.getNombre());
//			 ruta= "producto.xhtml";
//		 }
//		 else {
//			 loggedIn= false;
//			 msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"logging error.. ","usuario y/o clave incorrecta");
//			 if (administrador== null) {
//				 administrador= new AdministradorEN();
//			 }
//		 }
//		
//		 FacesContext.getCurrentInstance().addMessage(null, msg);
//		// context.addCallBackParam("loggindIN", loggedIn);
//		// context.addCallBackParam("ruta", ruta);
//		 
//		 
//	}

	
	
	
	

	

	
	

}

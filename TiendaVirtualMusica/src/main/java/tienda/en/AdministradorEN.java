package tienda.en;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AttributeOverrides(value = { @AttributeOverride(name = "cedula", column = @Column(name = "cedula_admin")),
		@AttributeOverride(name = "nombre", column = @Column(name = "nombre_admin")),
		@AttributeOverride(name = "apellido", column = @Column(name = "apellido_admin")),
		@AttributeOverride(name = "telefono", column = @Column(name = "telefono_admin")),
		@AttributeOverride(name = "email", column = @Column(name = "email_admin")), })
public class AdministradorEN extends Persona {

	@Id
	private int idAdministrador;

	@NotNull
	private String usuario;

	@NotNull
	private String password;

	public int getId() {
		return idAdministrador;
	}

	public void setId(int id) {
		this.idAdministrador = idAdministrador;
	}

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

}

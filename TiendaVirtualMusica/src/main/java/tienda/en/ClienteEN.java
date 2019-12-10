package tienda.en;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AttributeOverrides(value = { @AttributeOverride(name = "cedula", column = @Column(name = "cedula_cli")),
		@AttributeOverride(name = "nombre", column = @Column(name = "nombre_cli")),
		@AttributeOverride(name = "apellido", column = @Column(name = "apellido_cli")),
		@AttributeOverride(name = "telefono", column = @Column(name = "telefono_cli")),
		@AttributeOverride(name = "email", column = @Column(name = "email_cli")), })
public class ClienteEN extends Persona {

	@Id
	@GeneratedValue
	private int idCliente;

	@NotNull
	private String usuario;

	@NotNull
	private String password;

	private CarroCompraEN carro;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public CarroCompraEN getCarro() {
		return carro;
	}

	public void setCarro(CarroCompraEN carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return "ClienteEN [idCliente=" + idCliente + ", usuario=" + usuario + ", password=" + password + ", carro="
				+ carro + "]";
	}

}

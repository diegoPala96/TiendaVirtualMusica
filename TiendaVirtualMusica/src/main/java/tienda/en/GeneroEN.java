package tienda.en;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class GeneroEN {

	@Id
	@GeneratedValue
	private int idGenero;

	@NotNull
	private String descripcion;

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "GeneroEN [idGenero=" + idGenero + ", descripcion=" + descripcion + "]";
	}

}

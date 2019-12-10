package tienda.en;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ValoracionEN {

	@Id
	private int idValoracion;

	@NotNull
	private String comentario;

	public int getIdValoracion() {
		return idValoracion;
	}

	public void setIdValoracion(int idValoracion) {
		this.idValoracion = idValoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "ValoracionEN [idValoracion=" + idValoracion + ", comentario=" + comentario + "]";
	}

}

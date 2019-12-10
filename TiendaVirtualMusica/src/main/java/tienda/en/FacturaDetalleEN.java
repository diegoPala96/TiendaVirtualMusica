package tienda.en;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class FacturaDetalleEN {

	@Id
	@GeneratedValue
	private int idDetalle;

	@NotNull
	private int cantidad;
}

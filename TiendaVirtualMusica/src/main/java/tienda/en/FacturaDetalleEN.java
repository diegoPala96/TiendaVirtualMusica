package tienda.en;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FacturaDetalleEN {

	@Id
	@GeneratedValue
	private int idDetalle;
	private int cantidad;
}

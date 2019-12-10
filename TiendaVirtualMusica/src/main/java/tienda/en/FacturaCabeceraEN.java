package tienda.en;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class FacturaCabeceraEN {

	@Id
	@GeneratedValue
	private int numFactura;

	@NotNull
	private Date fecha;
}

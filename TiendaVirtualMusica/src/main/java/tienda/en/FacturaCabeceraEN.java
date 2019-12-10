package tienda.en;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FacturaCabeceraEN {

	@Id
	@GeneratedValue
	private int numFactura;
	private Date fecha;
}

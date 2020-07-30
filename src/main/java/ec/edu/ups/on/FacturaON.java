package ec.edu.ups.on;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.FacturaDAO;
import ec.edu.ups.modelo.Deducible;

@Stateless
public class FacturaON {

	@Inject
	private FacturaDAO facturaDAO;
	@Inject
	private DeducibleDAO deducibleDAO;
	@Inject
	private DeducibleON deducibleON;

	public void registrar(int numero) {
		Deducible deducible = deducibleON.read(numero);

		List<Deducible> deducibles = new ArrayList<Deducible>();

	}
}

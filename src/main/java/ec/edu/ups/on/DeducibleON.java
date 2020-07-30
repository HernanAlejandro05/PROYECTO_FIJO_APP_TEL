package ec.edu.ups.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.modelo.Deducible;

@Stateless
public class DeducibleON {

	@Inject
	private DeducibleDAO deDAO;

	public void create(Deducible de) {
		deDAO.create(de);
	}

	public Deducible read(int codigo) {
		return deDAO.leer(codigo);
	}

	public void update(Deducible de) {
		deDAO.update(de);
	}

	public void delete(int codigo) {
		deDAO.delete(codigo);
	}

}

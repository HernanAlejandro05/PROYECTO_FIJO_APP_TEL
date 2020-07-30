package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.objetos.DeducibleTmp;

@Stateless
public class DeducibleDAO {

	@Inject
	private EntityManager em;
	
	public double deducible;

	public void create(Deducible de) {
		em.persist(de);

	}

	public Deducible leer(int codigo) {
		return em.find(Deducible.class, codigo);

	}

	public Deducible leer2(int codigo) {
		Deducible det = em.find(Deducible.class, codigo);
		return det;

	}

	public void delete(int codigo) {

		em.remove(leer(codigo));
	}

	public void update(Deducible de) {
		em.merge(de);

	}
	
	public DeducibleTmp listarMasVendidos() {
		System.out.println("Ruben vales Vrg");
		String sql = "select sum(valordeduciblealimentacion) as alimentacion, sum(valordeducibleeducacion) as educacion, sum(valordeduciblesalud) as salud, sum(valordeduciblealimentacion+valordeducibleeducacion+valordeduciblesalud) as Total from deducible ";
			
		Query q = em.createNativeQuery(sql);
		List<Object[]> lista = q.getResultList();
		DeducibleTmp vt = new DeducibleTmp();
		for (Object item[] : lista) {
			vt.setValorDeducibleAlimentacion(Double.parseDouble(item[0].toString()));
			vt.setValorDeducibleEducacion(Double.parseDouble(item[1].toString()));
			vt.setValorDeducibleSalud(Double.parseDouble(item[2].toString()));
			vt.setTotalDeducible(Double.parseDouble(item[3].toString()));
			System.out.println(item[0]+" "+item[1]+" "+item[2]+" "+item[3]);
			
			//deducible=(Double.parseDouble(item[3].toString()));
		}
		System.out.println("mas ven "+vt.getTotalDeducible());
		//deducible=(vt.getTotalDeducible());
		System.out.println(lista.get(0));
		return vt;
	}
}

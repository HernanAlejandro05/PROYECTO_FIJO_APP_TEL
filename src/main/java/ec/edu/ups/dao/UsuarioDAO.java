package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.IngresosTmp;
import ec.edu.ups.objetos.User;

@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;

	public void create(Usuario u) {
		em.persist(u);

	}

	public Usuario read(String cedula) {
		return em.find(Usuario.class, cedula);

	}

	public void update(Usuario u) {
		em.merge(u);

	}

	public void delete(String cedula) {
		em.remove(read(cedula));
	}

	public List<Usuario> listar() {
		String jpql = "SELECT  u FROM Usuario u ";
		Query q = em.createQuery(jpql, Usuario.class);
		List<Usuario> usuarios = q.getResultList();

		return usuarios;

	}

	public Usuario getUserbyEmailAndPassword(User user) {
		String jpql = "SELECT u FROM Usuario u WHERE u.mail LIKE :mail AND u.clave LIKE :clave";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter("mail", user.getMail());
		q.setParameter("clave", user.getClave());
		Usuario us = (Usuario) q.getSingleResult();
		return us;
	}

	public Usuario getUsuarioPorCedula(String cedula) {
		String jpql = "SELECT u FROM Usuario u WHERE u.cedula LIKE :cedula";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter("cedula", cedula);
		Usuario cliente = (Usuario) q.getSingleResult();
		return cliente;
	}
	
	public IngresosTmp Ingresos() {
		System.out.println("Ruben vales Vrg");
		String sql = "select sum(ue.totalIngresos) from usuario u, usuarioEmpleador ue where u.cedula LIKE ue.usuario_cedula";
			
		Query q = em.createNativeQuery(sql);
		IngresosTmp vt = new IngresosTmp();
		double a = (double) q.getSingleResult();
		System.out.println(a);
		vt.setTotalIngresos((a));
		
		
		return vt;
	}

}

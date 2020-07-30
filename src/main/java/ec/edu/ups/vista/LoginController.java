package ec.edu.ups.vista;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.DeducibleTmp;
import ec.edu.ups.objetos.IngresosTmp;
import ec.edu.ups.objetos.User;
import ec.edu.ups.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class LoginController implements Serializable {
	@Inject
	private UsuarioController usuarioController;
	
	private Usuario usuario;
	private User user;
	
	@Inject
	private DeducibleDAO ddao;
	@Inject
	private UsuarioDAO udao;
	@Inject
	private DeducibleTmp dt;
	@Inject
	private IngresosTmp it;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		user = new User();
		
		
	}

	
	public Deducible listarDeducible() {
		
	    dt = ddao.listarMasVendidos();
		it=udao.Ingresos();
		System.out.println("deducible "+dt.getTotalDeducible()+" ingresos "+it.getTotalIngresos());
		System.out.println("resta "+(it.getTotalIngresos()-dt.getTotalDeducible()));
				
		return null;
	}
	public String login() {
		usuario = usuarioController.login(user);
		if (usuario != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usuario);
			
			return "index";
		} else {
			return null;
		}
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

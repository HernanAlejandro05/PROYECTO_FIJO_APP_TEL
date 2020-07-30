package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Factura implements Serializable {

	@Id
	@NotNull
	private int numero;
	@NotNull
	private Date fecha;
	@NotNull
	private double valor;

	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Proveedor proveedor;
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Deducible> deducibles;

	public Factura() {

	}
	public Factura(int numero) {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Deducible> getDeducibles() {
		return deducibles;
	}

	public void setDeducibles(List<Deducible> deducibles) {
		this.deducibles = deducibles;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", Fecha=" + fecha + ", valor=" + valor + ", usuario=" + usuario
				+ ", proveedor=" + proveedor + ", deducibles=" + deducibles + "]";
	}

}

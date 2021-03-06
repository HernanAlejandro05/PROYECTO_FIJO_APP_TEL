package ec.edu.ups.vista;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.objetos.DeducibleTmp;
import ec.edu.ups.objetos.IngresosTmp;

@ManagedBean
@ViewScoped
public class DatosController implements Serializable {

	private double sueldo;
    private double ingreso;
    private double capital;
    private double utilidad;
    private double alimentacion;
    private double vivienda;
    private double educacion;
    private double vestimenta;
    private double salud;
  
    private int codigo;
    
   
    @Inject
	private UsuarioDAO udao;
    @Inject
	private DeducibleDAO ddao;
    @Inject
	private DeducibleTmp dt;
    @Inject
	private IngresosTmp it;
    @Inject
	private FacesContext facesContext;
  
    public DatosController(){
        this.sueldo=0;
        this.ingreso=0;
        this.capital=0;
        this.utilidad=0;
        this.alimentacion=0;
        this.vivienda=0;
        this.educacion=0;
        this.salud=0;
       
        dt=new DeducibleTmp();
        it= new IngresosTmp();
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public double getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(double alimentacion) {
        this.alimentacion = alimentacion;
    }

    public double getVivienda() {
        return vivienda;
    }

    public void setVivienda(double vivienda) {
        this.vivienda = vivienda;
    }

    public double getEducacion() {
        return educacion;
    }

    public void setEducacion(double educacion) {
        this.educacion = educacion;
    }

    public double getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(double vestimenta) {
        this.vestimenta = vestimenta;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }
    
    public double getTotalIngreso(){
        double total =0;
        total = sueldo + ingreso + capital + utilidad;
        return total;
    }
    
    public double getTotalEgresos(){
        double total=0;
        total = alimentacion + vivienda + educacion + vestimenta + salud;
        return total;
    }
    
    public double getBaseImponible(){
        return getTotalIngreso() - getTotalEgresos();

    }
      
 
    
    
	public DeducibleTmp getDt() {
		return dt;
	}

	public void setDt(DeducibleTmp dt) {
		this.dt = dt;
	}

	public IngresosTmp getIt() {
		return it;
	}

	public void setIt(IngresosTmp it) {
		this.it = it;
	}

	public double getCalculoImpuestoRenta(){
    	
        double res=getBaseImponible();
        double va=0;
        if (res <= 11315) {
            va= 10;
        }else if( res > 11315 && res <= 14416 ){
            va= (res-11315)*0.5;
        }else if( res > 14416 && res <= 18018 ){
            va= ((res-14416)*0.10)+155;
        }else if( res > 18018 && res <= 21639 ){
            va= ((res-18018)*0.12)+515;
          
    }
        System.out.println(va);
        return va;
    }
    
public double getlistarDeducible() {
		
	    dt = ddao.listarMasVendidos();
		it=udao.Ingresos();
		alimentacion=dt.getTotalDeducible();
		System.out.println("deducible "+dt.getTotalDeducible()+" ingresos "+it.getTotalIngresos());
		System.out.println("resta "+(it.getTotalIngresos()-dt.getTotalDeducible()));
		double res=0;
		res=(it.getTotalIngresos()-dt.getTotalDeducible());
		System.out.println("res "+res);
		return res;
	}

		public void cargarDatosProducto() {
			if (codigo == 0)
				return;
			try {
				sueldo=dt.getValorDeducibleSalud();
				
			} catch (Exception e) {
				e.printStackTrace();
				FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
				facesContext.addMessage(null, m);
			}
			
			
		}

		public String editar(DeducibleTmp _deducible) {
			return "dt?faces-redirect=true&valorDeducibleVivienda=" + _deducible.getValorDeducibleVivienda()+"&valorDeducibleAlimentacion="+_deducible.getValorDeducibleAlimentacion();
		}
}

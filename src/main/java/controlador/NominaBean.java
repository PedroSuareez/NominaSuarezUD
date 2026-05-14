package controlador;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import modelo.Nomina;
import service.NominaService;

@Named("nominaBean")
@SessionScoped
public class NominaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id = "";
	private String nombre = "";
	private double salarioBasico = 0.0;
	private int dias = 30;

	private Nomina nominaActual;
	private NominaService service;

	public NominaBean() {
		service = new NominaService();
	}

	public String calcular() {
		nominaActual = service.calcularNomina(id, nombre, salarioBasico, dias);
		return "/resultado.xhtml?faces-redirect=true";
	}

	public String limpiarHistorial() {
		service.limpiarHistorial();
		return "/historial.xhtml?faces-redirect=true";
	}

	public String nuevaNomina() {
		id = "";
		nombre = "";
		salarioBasico = 0.0;
		dias = 30;
		nominaActual = null;
		return "/index.xhtml?faces-redirect=true";
	}

	public List<Nomina> getHistorial() {
		return service.getDao().obtenerTodas();
	}

	public int getTotalNominas() {
		return service.getDao().contar();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalarioBasico() {
		return salarioBasico;
	}

	public void setSalarioBasico(double s) {
		this.salarioBasico = s;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public Nomina getNominaActual() {
		return nominaActual;
	}

	public NominaService getService() {
		return service;
	}
}
package bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import model.Nomina;
import service.NominaService;

/**
 * NominaBean — controlador JSF
 */
@Named("nominaBean")
@SessionScoped
public class NominaBean implements Serializable {
	
	private static final String REGEX_ID     = "\\d+";
	private static final String REGEX_NOMBRE = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+";
	private static final long serialVersionUID = 1L;
	private String mensajeError = "";
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
	    mensajeError = "";

	    if (id == null || !id.trim().matches(REGEX_ID)) {
	        mensajeError = "El ID solo debe contener números.";
	        return null;
	    }

	    if (nombre == null || !nombre.trim().matches(REGEX_NOMBRE)) {
	        mensajeError = "El nombre solo debe contener letras y espacios.";
	        return null;
	    }

	    nominaActual = service.calcularNomina(id.trim(), nombre.trim(), salarioBasico, dias);

	    if (nominaActual == null) {
	        mensajeError = "Ya existe un empleado con ese ID o nombre registrado. Verifique los datos.";
	        return null;
	    }

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
	
	public String eliminarNomina(Nomina nomina) {
	    service.eliminarNomina(nomina.getId());
	    return "/historial.xhtml?faces-redirect=true";
	}
	
	public List<Nomina> getHistorial() {
		return service.obtenerTodas();
	}

	public int getTotalNominas() {
		return service.contarNominas();
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

	public void setSalarioBasico(double salarioBasico) {
		this.salarioBasico = salarioBasico;
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
	public String getMensajeError() {
	    return mensajeError;
	}
}
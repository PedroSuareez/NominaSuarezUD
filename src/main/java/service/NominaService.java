package service;

import java.io.Serializable;
import java.util.List;
import model.Nomina;
import repository.NominaRepository;

/**
 * NominaService — capa de lógica de negocio
 */
public class NominaService implements Serializable {

	private static final long serialVersionUID = 1L;

	private NominaRepository dao;

	public NominaService() {
		dao = new NominaRepository();
	}

	public Nomina calcularNomina(String id, String nombre, double salarioBasico, int dias) {
		if (dao.existePorIdONombre(id, nombre)) {
			return null; // duplicado detectado
		}
		Nomina nomina = new Nomina(id, nombre, salarioBasico, dias);
		dao.agregar(nomina);
		return nomina;
	}

	public void limpiarHistorial() {
		dao.limpiar();
	}

	public List<Nomina> obtenerTodas() {
		return dao.obtenerTodas();
	}

	public int contarNominas() {
		return dao.contar();
	}

	public NominaRepository getDao() {
		return dao;
	}
	public void eliminarNomina(String id) {
	    dao.eliminarPorId(id);
	}
}
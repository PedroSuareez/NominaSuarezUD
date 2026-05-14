package service;

import java.io.Serializable;
import modelo.Nomina;
import modelo.NominaDao;

/**
 * NominaService — capa de lógica de negocio
 */
public class NominaService implements Serializable {

    private static final long serialVersionUID = 1L;

    private NominaDao dao;

    public NominaService() {
        dao = new NominaDao();
    }

    /**
     * Crea una nueva nómina, la calcula y la persiste en el DAO.
     */
    public Nomina calcularNomina(String id, String nombre,
                                  double salarioBasico, int dias) {
        Nomina nomina = new Nomina(id, nombre, salarioBasico, dias);
        dao.agregar(nomina);
        return nomina;
    }

    /** Limpia todo el historial */
    public void limpiarHistorial() {
        dao.limpiar();
    }

    /** Expone el DAO para lectura desde la vista */
    public NominaDao getDao() {
        return dao;
    }
}

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Capa de acceso a datos.
 * Gestiona la lista de nóminas en memoria (ArrayList).
 */
public class NominaDao implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Nomina> nominas;

    public NominaDao() {
        nominas = new ArrayList<>();
        cargarDatosDemostracion();
    }

    /** Agrega una nómina al historial */
    public void agregar(Nomina nomina) {
        if (nomina != null) nominas.add(nomina);
    }

    /** Retorna copia de la lista */
    public List<Nomina> obtenerTodas() {
        return new ArrayList<>(nominas);
    }

    /** Vacía el historial */
    public void limpiar() {
        nominas.clear();
    }

    /** Cantidad de registros */
    public int contar() {
        return nominas.size();
    }

    /** 3 registros de ejemplo precargados */
    private void cargarDatosDemostracion() {
        nominas.add(new Nomina("1010101010", "Ana María Torres",   1_750_905.0, 30));
        nominas.add(new Nomina("2020202020", "Carlos Rodríguez",   3_500_000.0, 25));
        nominas.add(new Nomina("3030303030", "Luisa Fernanda Ríos",2_000_000.0, 15));
    }
}
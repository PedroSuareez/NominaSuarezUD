package modelo;

/**
 * Clase Empleado - extiende Persona
 * Contiene los datos laborales del empleado
 */
public class Empleado extends Persona {
    
    private double salarioBasico;
    private int dias;
    
    public Empleado() {
        super();
    }
    
    public Empleado(String id, String nombre, double salarioBasico, int dias) {
        super(id, nombre);
        this.salarioBasico = salarioBasico;
        this.dias = dias;
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
}

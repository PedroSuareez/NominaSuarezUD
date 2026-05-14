package modelo;

/**
 * Clase Nomina - extiende Empleado
 * Realiza todos los cálculos de nómina según requerimientos:
 * - Salario proporcional a días trabajados (mes = 30 días)
 * - Descuento Salud: 4% sobre salario calculado
 * - Descuento Pensión: 4% sobre salario calculado
 * - Auxilio de transporte: si salario básico <= 2 SMMLV (2 x $1.300.000 = $2.600.000)
 * - SMMLV 2024: $1.300.000 (valor referencia)
 * - Auxilio de transporte 2024: $162.000
 * - Neto = salario - salud - pensión + auxilio de transporte
 */
public class Nomina extends Empleado {
    
    // Constantes legales Colombia 2024
private static final double SMMLV = 1750905.0;
private static final double AUXILIO_TRANSPORTE = 249095.0;
private static final double PORCENTAJE_SALUD = 0.04;
private static final double PORCENTAJE_PENSION = 0.04;
private static final int DIAS_MES = 30;
    public Nomina() {
        super();
    }
    
    public Nomina(String id, String nombre, double salarioBasico, int dias) {
        super(id, nombre, salarioBasico, dias);
    }
    
    /**
     * Calcula el salario proporcional según días trabajados
     * Fórmula: (salarioBasico / 30) * diasTrabajados
     */
    public double calcularSalario() {
        return (getSalarioBasico() / DIAS_MES) * getDias();
    }
    
    /**
     * Retorna el auxilio de transporte si aplica
     * Aplica cuando salario básico <= 2 SMMLV
     */
    public double getAuxilioTransporte() {
    double AUXILIO_TRANSPORTEAUX = (AUXILIO_TRANSPORTE/30)*getDias();
        
        if (getSalarioBasico() <= (2 * SMMLV)) {
            return AUXILIO_TRANSPORTEAUX;
        }
        return 0.0;
    }
    
    /**
     * Calcula el descuento por salud (4% sobre salario calculado)
     */
    public double getSalud() {
        return calcularSalario() * PORCENTAJE_SALUD;
    }
    
    /**
     * Calcula el descuento por pensión (4% sobre salario calculado)
     */
    public double getPension() {
        return calcularSalario() * PORCENTAJE_PENSION;
    }
    
    /**
     * Calcula el neto a pagar
     * Neto = salario - salud - pensión + auxilio de transporte
     */
    public double calcularNeto() {
        return calcularSalario() - getSalud() - getPension() + getAuxilioTransporte();
    }
    
    /**
     * Indica si el empleado tiene auxilio de transporte
     */
    public boolean getTieneAuxilioTransporte() {
        return getSalarioBasico() <= (2 * SMMLV);
    }
}

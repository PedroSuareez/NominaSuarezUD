package model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Empleado extends Persona {

	@Column(name = "salario_basico")
	private double salarioBasico;

	@Column(name = "dias")
	private int dias;

	public Empleado() {
	}

	public Empleado(String id, String nombre, double salarioBasico, int dias) {
		super(id, nombre);
		this.salarioBasico = salarioBasico;
		this.dias = dias;
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
}
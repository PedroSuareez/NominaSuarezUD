package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	public Persona() {
	}

	public Persona(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	public void setNombre(String n) {
		this.nombre = n;
	}
}
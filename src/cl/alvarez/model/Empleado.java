package cl.alvarez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLEADO")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLEADO_SEQ")
	@SequenceGenerator(name = "EMPLEADO_SEQ", sequenceName = "EMPLEADO_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name="ID")
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDO")
	private String apellido;
	@Column(name="COMPANY")
	private String company;
	
	public Empleado() {
		
	}

	public Empleado(String nombre, String apellido, String company) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Id: " + id + "|| Nombre:" + nombre + "|| Apellido:" + apellido + "|| Compañia=" + company + ".";
	}
	
	
}

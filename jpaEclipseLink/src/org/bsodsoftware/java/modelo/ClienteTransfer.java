package org.bsodsoftware.java.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "clientes")
public class ClienteTransfer {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@NotNull
	private String telefono;
	private String direccion;
	
	@Column(name = "dni", nullable = false)
	private String DNI;
	
	// Constructor para hibernate
	public ClienteTransfer() {	}
	
	public ClienteTransfer(String DNI, String nombre, String telefono, String direccion, Integer id) {
		
		this.DNI = DNI;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + " " + DNI + " " + nombre + " " + telefono + " " + direccion;
	}
}

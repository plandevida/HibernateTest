package org.bsodsoftware.java;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="cliente")
public class ClienteTransfer {

	private String nombre, telefono, direccion, DNI;
	
	@Id
	private Integer id;
//	private Departamento departamento;
	
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
	
	
}

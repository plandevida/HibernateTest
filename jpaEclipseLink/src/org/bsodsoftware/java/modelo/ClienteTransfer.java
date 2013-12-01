package org.bsodsoftware.java.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "clientes")
@OptimisticLocking(type = OptimisticLockingType.CHANGED_COLUMNS)
public class ClienteTransfer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@NotNull
	private String telefono;
	private String direccion;
	
	@Column(name = "dni", nullable = false)
	private String DNI;
	
	// Constructor para EclipseLink
	public ClienteTransfer() {	}
	
	public ClienteTransfer(String DNI, String nombre, String telefono, String direccion, Long id) {
		
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + " " + DNI + " " + nombre + " " + telefono + " " + direccion;
	}
}

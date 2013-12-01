package org.bsodsoftware.java.integracion;

import javax.persistence.EntityManager;

import org.bsodsoftware.java.modelo.ClienteTransfer;

public interface DAOinteface {

	public Long crearEntity(ClienteTransfer cliente, EntityManager entity);
	
	public void actualizar(Long id, String DNI, String nombre, String telefono, String direccion, EntityManager entityManager);

	public ClienteTransfer consultar(Long id, EntityManager entityManager);

	public void borrar(Long id, EntityManager entityManager);
}

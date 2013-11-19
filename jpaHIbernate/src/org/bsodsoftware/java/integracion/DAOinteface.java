package org.bsodsoftware.java.integracion;

import javax.persistence.EntityManager;

import org.bsodsoftware.java.modelo.ClienteTransfer;

public interface DAOinteface {

	public Integer crear(String DNI, String nombre, String telefono, String direccion, EntityManager entityManager);

	public void actualizar(Integer id, String DNI, String nombre, String telefono, String direccion, EntityManager entityManager);

	public ClienteTransfer consultar(Integer id, EntityManager entityManager);

	public void borrar(Integer id, EntityManager entityManager);
}

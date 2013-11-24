package org.bsodsoftware.java.integracion.daoimp;

import javax.persistence.EntityManager;

import org.bsodsoftware.java.integracion.DAOinteface;
import org.bsodsoftware.java.modelo.ClienteTransfer;

public class ClienteDAO implements DAOinteface {
	
	@Override
	public Integer crear(String DNI, String nombre, String telefono, String direccion, EntityManager entityManager) {
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, null);
		
		entityManager.persist(cliente);
		
		return cliente.getId();
	}
	
	@Override
	public void actualizar(Integer id, String DNI, String nombre, String telefono, String direccion, EntityManager entityManager) {
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, id);
		
		entityManager.merge(cliente);
	}
	
	@Override
	public ClienteTransfer consultar(Integer id, EntityManager entityManager) {
		
		ClienteTransfer cliente = entityManager.find(ClienteTransfer.class, id);
		
		return cliente;
	}
	
	@Override
	public void borrar(Integer id, EntityManager entityManager) {
		
		ClienteTransfer cliente = consultar(id, entityManager);
		
		entityManager.remove(cliente);
	}
}

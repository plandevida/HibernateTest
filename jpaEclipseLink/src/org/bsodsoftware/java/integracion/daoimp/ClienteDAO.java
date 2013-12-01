package org.bsodsoftware.java.integracion.daoimp;

import javax.persistence.EntityManager;

import org.bsodsoftware.java.integracion.DAOinteface;
import org.bsodsoftware.java.modelo.ClienteTransfer;

public class ClienteDAO implements DAOinteface {
	
	@Override
	public Long crearEntity(ClienteTransfer cliente, EntityManager entity) {
		
		entity.persist(cliente);
		
		return cliente.getId();
	}
	
	@Override
	public void actualizar(Long id, String DNI, String nombre, String telefono, String direccion, EntityManager entityManager) {
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, id);
		
		entityManager.merge(cliente);
	}
	
	@Override
	public ClienteTransfer consultar(Long id, EntityManager entityManager) {
		
		ClienteTransfer cliente = entityManager.find(ClienteTransfer.class, id);
		
		return cliente;
	}
	
	@Override
	public void borrar(Long id, EntityManager entityManager) {
		
		ClienteTransfer cliente = consultar(id, entityManager);
		
		entityManager.remove(cliente);
	}
}

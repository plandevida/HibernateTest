package org.bsodsoftware.java.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bsodsoftware.java.integracion.daoimp.ClienteDAO;

public class SACliente {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public SACliente() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "hibernate-unit" );
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public Integer crear(ClienteTransfer cliente) {
		
		entityManager.getTransaction().begin();
		
		Integer clienteID = new ClienteDAO().crear(cliente.getDNI(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), entityManager);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return clienteID;
	}

	public ClienteTransfer consultar(Integer id) {
		
		entityManager.getTransaction().begin();
		
		ClienteTransfer cliente = new ClienteDAO().consultar(id, entityManager);

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return cliente;
	}

	public void editar(ClienteTransfer cliente) {
		
		entityManager.getTransaction().begin();
		
		new ClienteDAO().actualizar(cliente.getId(), cliente.getDNI(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), entityManager);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void borrar(Integer id) {
		
		entityManager.getTransaction().begin();
		
		new ClienteDAO().borrar(id, entityManager);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

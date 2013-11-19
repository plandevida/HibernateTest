package org.bsodsoftware.java.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bsodsoftware.java.integracion.daoimp.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SACliente {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public SACliente() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "hibernate-unit" );
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public Integer crear(ClienteTransfer cliente) {
		
		entityManager.getTransaction().begin();
		
		Integer clienteID = new ClienteDAO().crear(cliente.getDNI(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), session);
		
		session.getTransaction().commit();
		session.close();
		
		return clienteID;
	}

	public ClienteTransfer consultar(Integer id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ClienteTransfer cliente = new ClienteDAO().consultar(id, session);
		
		session.getTransaction().commit();
		session.close();
		
		return cliente;
	}

	public void editar(ClienteTransfer cliente) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		new ClienteDAO().actualizar(cliente.getId(), cliente.getDNI(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), session);

		session.getTransaction().commit();
		session.close();
	}

	public void borrar(Integer id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		new ClienteDAO().borrar(id, session);
		
		session.getTransaction().commit();
		session.close();
	}
}

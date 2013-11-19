package org.bsodsoftware.java.modelo;

import org.bsodsoftware.java.integracion.daoimp.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SACliente {

	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;
	
	public SACliente() {
		
		Configuration conf = new Configuration();
		conf.configure();
		
		serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		
		sessionFactory = conf.buildSessionFactory(serviceRegistry);
	}
	
	public Integer crear(ClienteTransfer cliente) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
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

package org.bsodsoftware.java.modelo;

import org.bsodsoftware.java.integracion.daoimp.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SACliente {

	SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	public SACliente() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public Integer crear(ClienteTransfer cliente) {
		
		Session session = sessionFactory.openSession();
		
		Integer clienteID = new ClienteDAO().crear(cliente.getDNI(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), session);

		session.close();
		
		return clienteID;
	}

	public ClienteTransfer consultar(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		if ( session == null ) {
			session = sessionFactory.openSession();
			
			System.out.println("AVISO: recreada la sesión");
		}
		
		ClienteTransfer cliente = new ClienteDAO().consultar(id, session);
		
		session.close();
		
		return cliente;
	}

	public void editar(ClienteTransfer cliente) {
		
		Session session = sessionFactory.openSession();
		
		new ClienteDAO().actualizar(cliente.getId(), cliente.getDNI(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), session);

		session.close();
	}

	public void borrar(Integer id) {
		
		Session session = sessionFactory.openSession();
		
		new ClienteDAO().borrar(id, session);
		
		session.close();
	}
}

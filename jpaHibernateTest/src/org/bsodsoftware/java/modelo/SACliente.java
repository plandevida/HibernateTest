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
		
		Integer clienteID = new ClienteDAO().crear(cliente, session);
		
		return clienteID;
	}

	public ClienteTransfer consultar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void editar(ClienteTransfer o) {
		// TODO Auto-generated method stub
		
	}

	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		
	}
}

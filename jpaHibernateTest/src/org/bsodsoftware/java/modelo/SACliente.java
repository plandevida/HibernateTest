package org.bsodsoftware.java.modelo;

import org.bsodsoftware.java.integracion.daoimp.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SACliente implements CRUDinterface {

	SessionFactory sessionFactory;
	
	public SACliente() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@Override
	public Integer crear(Object o) {
		
		Session session = sessionFactory.openSession();
		
		ClienteTransfer cliente = (ClienteTransfer) o;
		
		Integer clienteID = new ClienteDAO().crear(cliente, session);
		
		return clienteID;
	}

	@Override
	public Object consultar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}

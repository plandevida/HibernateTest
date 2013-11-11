package org.bsodsoftware.java.integracion.daoimp;

import org.bsodsoftware.java.integracion.DAOinteface;
import org.bsodsoftware.java.modelo.ClienteTransfer;
import org.hibernate.Session;

public class ClienteDAO implements DAOinteface {
	
	@Override
	public Integer crear(ClienteTransfer cliente, Session session) {
		
		session.beginTransaction();
		session.save( cliente );
		session.getTransaction().commit();
		session.close();
		
		return cliente.getId();
	}
	@Override
	public Integer actualizar(ClienteTransfer cliente, Session session) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ClienteTransfer consultar(Integer id, Session session) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void borrar(Integer id, Session session) {
		// TODO Auto-generated method stub
		
	}
}

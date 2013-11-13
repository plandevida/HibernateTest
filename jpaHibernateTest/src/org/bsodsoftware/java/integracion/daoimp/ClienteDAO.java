package org.bsodsoftware.java.integracion.daoimp;

import java.util.ArrayList;
import java.util.List;

import org.bsodsoftware.java.integracion.DAOinteface;
import org.bsodsoftware.java.modelo.ClienteTransfer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ClienteDAO implements DAOinteface {
	
	@Override
	public Integer crear(String DNI, String nombre, String telefono, String direccion, Session session) {
		
		session.beginTransaction();
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, null);
		
		session.save(cliente);
		
		session.getTransaction().commit();
		
		return cliente.getId();
	}
	
	@Override
	public void actualizar(Integer id, String DNI, String nombre, String telefono, String direccion, Session session) {
		
		session.beginTransaction();
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, id);
		
		session.update( cliente );
		
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClienteTransfer consultar(Integer id, Session session) {
		
		session.beginTransaction();
		
		Criteria query = session.createCriteria(ClienteTransfer.class.getName());
		
		query.add(Restrictions.eq("id", id));
		
		List<ClienteTransfer> lista = (ArrayList<ClienteTransfer>) query.list();
		
		session.getTransaction().commit();
		
		return (lista != null) ? lista.get(0) : null;
	}
	
	@Override
	public void borrar(Integer id, Session session) {
		
		session.beginTransaction();
		
		ClienteTransfer cliente = consultar(id, session);
		
		session.delete( cliente );
		
		session.getTransaction().commit();
	}
}

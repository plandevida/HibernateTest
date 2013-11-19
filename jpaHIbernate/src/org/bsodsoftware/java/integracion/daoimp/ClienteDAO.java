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
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, null);
		
		session.save(cliente);
		
		return cliente.getId();
	}
	
	@Override
	public void actualizar(Integer id, String DNI, String nombre, String telefono, String direccion, Session session) {
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, id);
		
		session.update( cliente );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClienteTransfer consultar(Integer id, Session session) {
		
		Criteria query = session.createCriteria(ClienteTransfer.class.getName());
		
		query.add(Restrictions.eq("id", id));
		
		List<ClienteTransfer> lista = (ArrayList<ClienteTransfer>) query.list();
		
		return (lista != null && !lista.isEmpty()) ? lista.get(0) : null;
	}
	
	@Override
	public void borrar(Integer id, Session session) {
		
		ClienteTransfer cliente = consultar(id, session);
		
		session.delete( cliente );
	}
}

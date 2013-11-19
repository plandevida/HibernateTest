package org.bsodsoftware.java.integracion.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.bsodsoftware.java.integracion.DAOinteface;
import org.bsodsoftware.java.modelo.ClienteTransfer;

public class ClienteDAO implements DAOinteface {
	
	@Override
	public Integer crear(String DNI, String nombre, String telefono, String direccion, EntityManager entityManager) {
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, null);
		
		entityManager.persist(cliente);
		
		return cliente.getId();
	}
	
	@Override
	public void actualizar(Integer id, String DNI, String nombre, String telefono, String direccion, EntityManager entityManager) {
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, id);
		
		entityManager.merge(cliente);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClienteTransfer consultar(Integer id, EntityManager entityManager) {
		
		String queryPura = "SELECT * FROM clientes WHERE id=?";
		
		queryPura.replace("?", String.valueOf(id) );
		
		Query query = entityManager.createQuery(queryPura);
		
		List<ClienteTransfer> lista = query.getResultList();
		
		return (lista != null && !lista.isEmpty() ) ? lista.get(0) : null;
	}
	
	@Override
	public void borrar(Integer id, EntityManager entityManager) {
		
		ClienteTransfer cliente = consultar(id, entityManager);
		
		entityManager.remove(cliente);
	}
}

package org.bsodsoftware.java.integracion;

import org.bsodsoftware.java.modelo.ClienteTransfer;
import org.hibernate.Session;

public interface DAOinteface {

	public Integer crear(ClienteTransfer cliente, Session session);

	public Integer actualizar(ClienteTransfer cliente, Session session);

	public ClienteTransfer consultar(Integer id, Session session);

	public void borrar(Integer id, Session session);
}

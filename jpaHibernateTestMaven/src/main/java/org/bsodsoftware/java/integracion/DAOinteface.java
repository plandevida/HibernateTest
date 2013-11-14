package org.bsodsoftware.java.integracion;

import org.bsodsoftware.java.modelo.ClienteTransfer;
import org.hibernate.Session;

public interface DAOinteface {

	public Integer crear(String DNI, String nombre, String telefono, String direccion, Session session);

	public void actualizar(Integer id, String DNI, String nombre, String telefono, String direccion, Session session);

	public ClienteTransfer consultar(Integer id, Session session);

	public void borrar(Integer id, Session session);
}

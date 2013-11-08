package org.bsodsoftware.java.integracion;

import org.bsodsoftware.java.ClienteTransfer;

public interface DAOinteface {
	
	public Integer crear(ClienteTransfer cliente);
	public Integer actualizar(ClienteTransfer cliente);
	public ClienteTransfer consultar(Integer id);
	public void borrar(Integer id);
}

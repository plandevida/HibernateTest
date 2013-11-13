package org.bsodsoftware.java.modelo;

public interface CRUDclientes extends CRUDinterface {

	public Integer crear(ClienteTransfer cliente);
	public ClienteTransfer consultar(Integer id);
	public void editar(ClienteTransfer cliente);
	public void borrar(Integer id);
}

package org.bsodsoftware.modelo;

public interface CRUDinterface {
	
	public Integer crear(Object o);
	public Object consultar(Integer id);
	public void editar(Object o);
	public void borrar(Integer id);
}

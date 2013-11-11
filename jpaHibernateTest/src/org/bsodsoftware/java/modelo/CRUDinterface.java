package org.bsodsoftware.java.modelo;

public interface CRUDinterface {
	
	public Integer crear(Object o);
	public Object consultar(Integer id);
	public void editar(Object o);
	public void borrar(Integer id);
}

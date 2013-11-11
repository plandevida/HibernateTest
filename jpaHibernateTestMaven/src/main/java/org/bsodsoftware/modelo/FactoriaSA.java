package org.bsodsoftware.modelo;

public class FactoriaSA implements FactoriaSAinterface {

	private static FactoriaSA factoria = null;

	public FactoriaSAinterface getInstance() {
		
		if ( factoria == null ) {
			factoria = new FactoriaSA();
		}
		return factoria;
	}

	public SACliente getSACliente() {
		
		return new SACliente();
	}

}

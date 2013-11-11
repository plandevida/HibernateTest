package org.bsodsoftware.java.modelo;

public class FactoriaSA implements FactoriaSAinterface {

	private static FactoriaSA factoria = null;
	
	@Override
	public FactoriaSAinterface getInstance() {
		
		if ( factoria == null ) {
			factoria = new FactoriaSA();
		}
		return factoria;
	}

	@Override
	public SACliente getSACliente() {
		
		return new SACliente();
	}

}

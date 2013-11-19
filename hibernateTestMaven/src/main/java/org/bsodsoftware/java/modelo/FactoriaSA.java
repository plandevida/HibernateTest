package org.bsodsoftware.java.modelo;

public class FactoriaSA {

	private static FactoriaSA factoria = null;
	
	public static FactoriaSA getInstance() {
		
		if ( factoria == null ) {
			factoria = new FactoriaSA();
		}
		return factoria;
	}

	public SACliente getSACliente() {
		
		return new SACliente();
	}

}

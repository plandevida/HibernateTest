package org.bsodsoftware.java.main;

import java.io.IOException;

import org.bsodsoftware.java.presentacion.Consola;

public class PruebaEclipseLink {

	public static void main(String[] args) {
	
		Consola consola = new Consola();
		
		try {
			consola.iniciar();
			
		} catch (IOException e) {
			System.err.println("La consola no pudo leer del teclado");
			e.printStackTrace();
		}
	}
}

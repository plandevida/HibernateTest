package org.bsodsoftware.java.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bsodsoftware.java.modelo.ClienteTransfer;
import org.bsodsoftware.java.modelo.FactoriaSA;

public class Consola {

	private String ultimoComando;
	private BufferedReader lector;
	private FactoriaSA factoria;
	
	public Consola() {
		
		lector = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void iniciar() throws IOException {
		
		menu();
		
		String accion = "";
		
		while ( accion != null && !"q".equalsIgnoreCase(accion) ) {
			
			accion = lector.readLine();
			
			acciones(accion);
		}
	}
	
	private void menu() {
		
		System.out.println("Acciones:");
		System.out.println("\t c - Crar un cliente");
		System.out.println("\t o - Consultar un cliente");
		System.out.println("\t a - Actualizar un cliente");
		System.out.println("\t b - Borrar un cliente");
		System.out.println("\t r - Repetir última acción");
		System.out.println("\t q - Salir");
	}
	
	private void acciones(String comando) throws IOException {
		
		switch (comando) {
			
		case "c":
			factoria = FactoriaSA.getInstance();
			
			System.out.println("Introduzca el DNI del cliente: ");
			String DNI = lector.readLine();
			
			System.out.println("Introduzca el nombre del cliente: ");
			String nombre = lector.readLine();

			System.out.println("Introduzca el telefono del cliente: ");
			String telefono = lector.readLine();
			
			System.out.println("Introduzca la dirección del cliente: ");
			String direccion = lector.readLine();
			
			ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, null);
			
			factoria.getSACliente().crear(cliente);
		}
	}
}

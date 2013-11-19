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
		System.out.println("\t m - Modificar un cliente");
		System.out.println("\t b - Borrar un cliente");
		System.out.println("\t r - Repetir última acción");
		System.out.println("\t h - Ver este menú");
		System.out.println("\t q - Salir");
	}
	
	private void crearCliente() throws IOException {

		factoria = FactoriaSA.getInstance();
		
		System.out.println("Introduzca el DNI del cliente: ");
		String DNI = lector.readLine();
		
		System.out.println("Introduzca el nombre del cliente: ");
		String nombre = lector.readLine();

		System.out.println("Introduzca el telefono del cliente: ");
		String telefono = lector.readLine();
		
		System.out.println("Introduzca la direcci��n del cliente: ");
		String direccion = lector.readLine();
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, null);
		
		Integer idCliente = factoria.getSACliente().crear(cliente);
		
		System.out.println("CLIENTE CREADO con id: " + idCliente);
	}
	
	private void consultarCliente() throws IOException {
		
		factoria = FactoriaSA.getInstance();
		
		System.out.println("Introduzca el ID del cliente: ");
		String id = lector.readLine();
		
		Integer idCliente = null;
		try {
			idCliente = Integer.valueOf(id);
		}
		catch (NumberFormatException ne) {
			ne.printStackTrace();
		}
		
		ClienteTransfer cliente = factoria.getSACliente().consultar(idCliente);
		
		System.out.println(cliente);
	}
	
	private void modificarCliente() throws IOException {
		
		factoria = FactoriaSA.getInstance();
		
		System.out.println("Introduzca el ID del cliente a modificar: ");
		String id_cadena = lector.readLine();
		
		Integer idCliente = null;
		try {
			idCliente = Integer.valueOf(id_cadena);
		}
		catch (NumberFormatException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("Introduzca el DNI del cliente: ");
		String DNI = lector.readLine();
		
		System.out.println("Introduzca el nombre del cliente: ");
		String nombre = lector.readLine();

		System.out.println("Introduzca el telefono del cliente: ");
		String telefono = lector.readLine();
		
		System.out.println("Introduzca la direcci��n del cliente: ");
		String direccion = lector.readLine();
		
		ClienteTransfer cliente = new ClienteTransfer(DNI, nombre, telefono, direccion, idCliente);
		
		factoria.getSACliente().editar(cliente);
		
		System.out.println("Compruebe que el cliente se ha editado correctamente");
	}
	
	private void borrarCliente() throws IOException {
		
		factoria = FactoriaSA.getInstance();
		
		System.out.println("Introduzca el ID del cliente: ");
		String id = lector.readLine();
		
		Integer idCliente = null;
		try {
			idCliente = Integer.valueOf(id);
		}
		catch (NumberFormatException ne) {
			ne.printStackTrace();
		}
		
		factoria.getSACliente().borrar(idCliente);
		
		System.out.println("Compruebe que el cliente no existe");
	}
	
	private void acciones(String comando) throws IOException {
		
		switch (comando) {
			
		case "c":
			
			crearCliente();
			
			break;
			
		case "o":
			
			consultarCliente();
			
			break;
			
		case "m":
			
			modificarCliente();
			
			break;
			
		case "b":
			
			borrarCliente();
			
			break;
			
		case "r":
			
			acciones(ultimoComando);
			
			break;
			
		case "h":
			
			menu();
			
			break;
		}
		
		ultimoComando = comando;
	}
}

package pojo;

import java.util.ArrayList;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private ArrayList<Pedido> pedidos;


/**
 * Constructor sin el id.
 * @param nombre nombre del cliente
 * @param apellido1 apellido del cliente
 * @param apellido2 segundo apellido del cliente
 * @param edad edad del cliente
 */
	public Cliente(String nombre, String apellido1, String apellido2, int edad) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;

	}
	
	
/**
 * Metodo que contiene todos los atributos.
 * @param id id del cliente
 * @param nombre nombre del cliente
 * @param apellido1 apellido del cliente
 * @param apellido2 segundo apellido del cliente
 * @param edad edad del cliente
 * @param pedidos lista de pedidos del cliente.
 */
	public Cliente(int id,String nombre, String apellido1, String apellido2, int edad, ArrayList<Pedido> pedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.pedidos = pedidos;
	}

	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "\n id:" + id + "\n nombre: " + nombre + "\n apellido1: " + apellido1 + "\n apellido2: " + apellido2
				+ "\n edad: " + edad + "\n pedidos:" + pedidos.toString().replaceAll("[\\[\\]]", "")+"\n" ;
	}

	

}

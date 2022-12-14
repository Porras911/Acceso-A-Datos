package pojo;

public class Pedido {

	private int id;
	private String nombre;
	private int precio;
	private Cliente cliente;

	/**
	 * Constructor con todos los atributos.
	 * 
	 * @param id      id del pedido
	 * @param nombre  nombre del pedido
	 * @param precio  precio del pedido
	 * @param cliente cliente con el que se relaciona el pedido
	 */
	public Pedido(int id, String nombre, int precio, Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cliente = cliente;
	}

	/**
	 * Constructor sin el id
	 * @param id      id del pedido
	 * @param nombre  nombre del pedido
	 * @param precio  precio del pedido
	 * @param cliente cliente con el que se relaciona el pedido
	 */

	public Pedido(String nombre, int precio, Cliente cliente) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cliente = cliente;
	}
	
	/**
	 * Constructor sin el cliente.
	 * @param id      id del pedido
	 * @param nombre  nombre del pedido
	 * @param precio  precio del pedido
	 */

	public Pedido(int id, String nombre, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "id: " + id + "\t Articulo: " + nombre + "\t precio: " + precio + "\t cliente: " + cliente.getNombre()
				+ "";
	}

}

package pojo;

public class Pedido {

	private int id;
	private String nombre;
	private int precio;
	private Cliente cliente;

	public Pedido(int id, String nombre, int precio, Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cliente = cliente;
	}

	public Pedido(String nombre, int precio, Cliente cliente) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cliente = cliente;
	}
	

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
		return "\n\t id: " + id + "\n\t Articulo: " + nombre + "\n\t precio: " + precio + "\n\t cliente: " + cliente.getNombre()+"\n--------------" ;
	}

}

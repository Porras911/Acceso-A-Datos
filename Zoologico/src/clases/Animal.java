package clases;

public class Animal {
	
	private int id;
	private String nombre;
	private String habitat;
	private float peso_aproximado;
	
	
	public Animal(int id, String nombre, String habitat, float peso_aproximado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.habitat = habitat;
		this.peso_aproximado = peso_aproximado;
	}


	public Animal(String nombre, String habitat, float peso_aproximado) {
		super();
		this.nombre = nombre;
		this.habitat = habitat;
		this.peso_aproximado = peso_aproximado;
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


	public String getHabitat() {
		return habitat;
	}


	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}


	public float getPeso_aproximado() {
		return peso_aproximado;
	}


	public void setPeso_aproximado(float peso_aproximado) {
		this.peso_aproximado = peso_aproximado;
	}


	@Override
	public String toString() {
		return "Animal \n id: " + id + 
				"\n nombre: " + nombre +
				"\n habitat: " + habitat 
				+ "\n peso_aproximado: "+ peso_aproximado ;
	}
	
	
	
	
	
	
	
}

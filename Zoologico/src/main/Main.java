package main;

import clases.Animal;
import clases.AnimalDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal a = new Animal("Ardilla","Bosque",0.1f);
		AnimalDao.insertarAnimal(a);
		AnimalDao.deleteAnimal();
	}

}

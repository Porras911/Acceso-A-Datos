package main;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Animal;
import clases.AnimalDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		Animal a = new Animal("Ardilla","Bosque",0.1f);
		Animal a1 = new Animal("Ardillon","Bosque",1.1f);
		AnimalDao.insertarAnimal(a);
		AnimalDao.insertarAnimal(a1);
//		AnimalDao.deleteAnimal();
//		System.out.println("Dime el nombre del animal que quieres borrar");
//		String nombre = sc.nextLine();
//		AnimalDao.deleteAnimalByName("Ardilla");
//		Animal a2 = AnimalDao.findById(18);
//		System.out.println(a2);
		ArrayList<Animal> animales= AnimalDao.findAllAnimales();
		for(int i = 0;i<animales.size();i++ ) {
			System.out.println(animales.get(i)+"\n");
		}
		
	}

}

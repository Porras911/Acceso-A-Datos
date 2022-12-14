package main;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.PedidoDao;
import pojo.Cliente;
import pojo.Pedido;

public class Main {

	public static void main(String[] args) {
		ClienteDao clienteDao = new ClienteDao();
		PedidoDao pedidoDao = new PedidoDao();
		clienteDao.safeBorrar();
		clienteDao.autoincrement();
		pedidoDao.autoincrement();
		
		Cliente cl = new Cliente("porras", "Porras", "Robles", 26);
		Cliente cl2 = new Cliente("Albertinho", "Dos Santos", "Tres Santos", 22);
		Cliente cl3 = new Cliente("Armando", "Bronca", "Segura", 20);


		clienteDao.insertar(cl);
		clienteDao.insertar(cl2);
		clienteDao.insertar(cl3);
		
		Cliente cliente = clienteDao.buscarPorId(1);
		Cliente cliente2 = clienteDao.buscarPorId(2);
		Cliente cliente3 = clienteDao.buscarPorId(3);
		

		Pedido p1 = new Pedido("juego", 50, cliente);
		Pedido p2 = new Pedido("alfombra", 20, cliente2);
		Pedido p3 = new Pedido("tv", 150, cliente3);
		
		
		pedidoDao.insertar(p1);
		pedidoDao.insertar(p2);
		pedidoDao.insertar(p3);
		
		System.out.println("Cambiar el nombre del cliente por Manuel");
		System.out.println("Nombre antiguo: "+cliente.getNombre());
		cliente.setNombre("Manuel");
		clienteDao.modificar(cliente);
		System.out.println("Nombre modificado: "+cliente.getNombre());
		
		Pedido pedido = pedidoDao.buscarPorId(1);
		System.out.println("\nCambiar nombre del pedido por Spider-man.");
		System.out.println("Nombre antiguo: "+pedido.getNombre());
		pedido.setNombre("Spider-man");
		pedidoDao.modificar(pedido);
		System.out.println("Nombre antiguo: "+pedido.getNombre());
		
		
		System.out.println("\nEl pedido con el precio minimo es "+pedidoDao.precioMinimo()+"€");
		
		System.out.println("\n-----------------------\n");
		System.out.println("Clientes y sus pedidos");
		ArrayList<Cliente > clientes = clienteDao.buscarTodos();
		
		for (Cliente clienteFOR: clientes) {
			System.out.println(clienteFOR);
		}
		System.out.println("\n-----------------------\n");
		System.out.println("Todos los pedidos");
		ArrayList<Pedido> pedidos = pedidoDao.buscarTodos();
		for (Pedido pedidoFor: pedidos) {
			System.out.println(pedidoFor);
		}
		
		
		
	    clienteDao.borrar(cliente);
	    clienteDao.borrar(cliente2);
	    clienteDao.borrar(cliente3);
	    System.out.println("\n-----------------------\n");
		System.out.println("\nClientes y pedidos despues de borrar");
		System.out.println("\n-----------------------\n");
		System.out.println("Clientes y sus pedidos\n");
		ArrayList<Cliente > clientes2 = clienteDao.buscarTodos();
		
		for (Cliente clienteFOR: clientes2) {
			System.out.println(clienteFOR);
		}
		
		System.out.println("\n-----------------------\n");
		System.out.println("Todos los pedidos\n");
		
		ArrayList<Pedido> pedidos2 = pedidoDao.buscarTodos();
		
		for (Pedido pedidoFor: pedidos2) {
			System.out.println(pedidoFor);
		}
		
		clienteDao.autoincrement();
		pedidoDao.autoincrement();
		

 }

}

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
		
		
		Cliente cl = new Cliente("porras", "Porras", "Robles", 26);
		Cliente cl2 = new Cliente("Carlos", "Martin", "dos santos", 22);
		Cliente cl3 = new Cliente("Javi", "Vaquero", "garcia", 20);


		clienteDao.insertar(cl);
		clienteDao.insertar(cl2);
		clienteDao.insertar(cl3);
//		
		Cliente cliente = clienteDao.buscarPorId(1);
		Cliente cliente2 = clienteDao.buscarPorId(2);
		Cliente cliente3 = clienteDao.buscarPorId(3);
//		
//		

		Pedido p1 = new Pedido("juego", 50, cliente);
		Pedido p2 = new Pedido("alfombra", 20, cliente2);
		Pedido p3 = new Pedido("tv", 150, cliente3);
		
//		
		pedidoDao.insertar(p1);
		pedidoDao.insertar(p2);
		pedidoDao.insertar(p3);
//		
//		System.out.println(cliente);
		cliente.setNombre("Manuel");
		clienteDao.modificar(cliente);
//		System.out.println(cliente);
		
		Pedido pedido = pedidoDao.buscarPorId(1);
//		System.out.println(pedido);
		pedido.setNombre("Spider-man");
		pedidoDao.modificar(pedido);
//		System.out.println(pedido);
//		
		
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
//		pedidoDao.borrar(pedido);
		System.out.println("Clientes y pedidos despues de borrar");
		System.out.println("\n-----------------------\n");
		System.out.println("Clientes y sus pedidos");
		ArrayList<Cliente > clientes2 = clienteDao.buscarTodos();
		
		for (Cliente clienteFOR: clientes2) {
			System.out.println(clienteFOR);
		}
		System.out.println("\n-----------------------\n");
		System.out.println("Todos los pedidos");
		ArrayList<Pedido> pedidos2 = pedidoDao.buscarTodos();
		for (Pedido pedidoFor: pedidos2) {
			System.out.println(pedidoFor);
		}
		
		
//		System.out.println(cliente);
//		System.out.println(cl);
//		System.out.println(cl3);
//		
	
//		
//		
//		System.out.println(clienteDao.buscarPorId(1));
//		

//		
//		System.out.println(clienteDao.buscarPorId(1));
		

 }

}

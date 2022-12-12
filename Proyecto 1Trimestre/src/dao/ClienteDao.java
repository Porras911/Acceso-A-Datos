package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Cliente;
import pojo.Pedido;

public class ClienteDao extends ObjetoDao implements InterfazDao<Cliente> {

	private static Connection connection;

	public ClienteDao() {

	}

	@Override
	public ArrayList<Cliente> buscarTodos() {
		connection = openConnection();
		ArrayList<Cliente> clientes = new ArrayList<>();

		String query = "SELECT * FROM clientes";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

				Cliente cliente = new Cliente(rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido1"),						
						rs.getString("apellido2"),
						rs.getInt("edad"),
						null );
				cliente.setPedidos(obtenerPedidos(cliente));

//				String queryPedidos = "select * from pedidos where cliente_id = ?";
//				PreparedStatement psPedidos = connection.prepareStatement(queryPedidos);
//				psPedidos.setInt(1, rs.getInt("id"));
//				ResultSet rsPedidos = psPedidos.executeQuery();
//
//				while (rsPedidos.next()) {
//					Pedido pedido = new Pedido(
//							rs.getInt("id"),
//							rs.getString("nombre"),
//							rs.getInt("precio"),
//							cliente
//							);
//
//					pedidos.add(pedido);
//				}
//
//				cliente.setPedidos(pedidos);
				

				clientes.add(cliente);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		closeConnection();

		return clientes;
	}

	@Override
	public Cliente buscarPorId(int id) {
		connection = openConnection();
		Cliente cliente = null;

		String query = "select * from clientes where id = ?";

		try {
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cliente = new Cliente(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido1"),
						rs.getString("apellido2"),
						rs.getInt("edad"),
						null);
				cliente.setPedidos(obtenerPedidos(cliente));
			}
		

		} catch (SQLException e) {

			e.printStackTrace();
		}
//		 closeConnection();

		return cliente;

	}

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
//		autoincrement();
//		safeBorrar();
		connection = openConnection();

		String query = "insert into clientes (nombre, apellido1, apellido2, edad)" + " values (?, ?, ?, ?)";

		try {


			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido1());
			ps.setString(3, cliente.getApellido2());
			ps.setInt(4, cliente.getEdad());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
//		

	}

	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		connection = openConnection();
		int id = cliente.getId();
		String nombre = cliente.getNombre();
		String apellido1 = cliente.getApellido1();
		String apellido2 = cliente.getApellido2();
		int edad = cliente.getEdad();

		String query = "UPDATE clientes SET nombre = ?, apellido1 = ? , apellido2 = ?, edad = ?" + " WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, apellido1);
			ps.setString(3, apellido2);
			ps.setInt(4, edad);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	@Override
	public void borrar(Cliente t) {
		safeBorrar();
		
		int cliente_id = t.getId();

		PedidoDao pedidoDao = new PedidoDao();
		pedidoDao.borrarPedidoPorCliente(cliente_id);

		connection = openConnection();

		String query = "DELETE FROM clientes WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
//		resetID();

	}

	public ArrayList<Pedido> obtenerPedidos(Cliente cliente) {
		ArrayList<Pedido> pedidos = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM pedidos WHERE cliente_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pedido pedido = new Pedido(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("precio"),
						cliente);
				pedidos.add(pedido);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		closeConnection();

		return pedidos;
	}

	public void autoincrement() {
		connection = openConnection();

		String query3 = "ALTER TABLE clientes AUTO_INCREMENT=0;";
		try {
			PreparedStatement ps2 = connection.prepareStatement(query3);
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	public void safeBorrar() {
		connection = openConnection();

		String query2 = "SET SQL_SAFE_UPDATES = 0;";
		try {
			PreparedStatement ps2 = connection.prepareStatement(query2);
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
//	public void resetID() {
//		connection = openConnection();
//
//		String query2 = "UPDATE clientes SET id = id - 1;";
//		try {
//			PreparedStatement ps2 = connection.prepareStatement(query2);
//			ps2.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		closeConnection();
//	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Cliente;
import pojo.Pedido;

public class PedidoDao extends ObjetoDao implements InterfazDao<Pedido> {

	private static Connection connection;

	public PedidoDao() {

	}

	@Override
	public ArrayList<Pedido> buscarTodos() {
		// TODO Auto-generated method stub
		connection = openConnection();
		ArrayList<Pedido> pedidos = new ArrayList<>();

		String query = " SELECT * FROM pedidos";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("id"), rs.getString("nombre"), rs.getInt("precio"),
						obtenerCliente(rs.getInt("cliente_id")));

				pedidos.add(pedido);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		closeConnection();
		return pedidos;
	}

	@Override
	public Pedido buscarPorId(int id) {
		connection = openConnection();

		Pedido pedido = null;

		String query = "select * from pedidos where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pedido = new Pedido(rs.getInt("id"), rs.getString("nombre"), rs.getInt("precio"), null

				);
				pedido.setCliente(obtenerCliente(rs.getInt("cliente_id")));
				;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		closeConnection();

		return pedido;
	}

	@Override
	public void insertar(Pedido t) {
		// TODO Auto-generated method stub

//		autoincrement();
//		safeBorrar();
		connection = openConnection();

		String query = "insert into pedidos (nombre, precio, cliente_id) values (?, ?, ?)";

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setInt(2, t.getPrecio());
			ps.setInt(3, t.getCliente().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Pedido t) {
		int id = t.getId();
		String nombre = t.getNombre();
		int precio = t.getPrecio();

		connection = openConnection();
		String query = "UPDATE pedidos SET nombre = ?, precio = ?  WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, nombre);
			ps.setInt(2, precio);
			ps.setInt(3, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void borrar(Pedido t) {
		connection = openConnection();

		int id = t.getId();

		String query = "DELETE FROM pedidos WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	public void borrarPedidoPorCliente(int cliente_id) {
		connection = openConnection();

		String query = "DELETE FROM pedidos WHERE cliente_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	public Cliente obtenerCliente(int cliente_id) {
		Cliente cliente = null;
		connection = openConnection();
		String query = "SELECT * FROM clientes WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getInt("edad"), null);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return cliente;
	}

	public void autoincrement() {
		connection = openConnection();

		String query3 = "ALTER TABLE pedidos AUTO_INCREMENT=0;";
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
//		String query2 = "UPDATE pedidos SET id = id - 1;";
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

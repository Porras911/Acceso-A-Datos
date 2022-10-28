package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import utilsBD.DatabaseConexion;

public class TemporadaDao implements Dao<Temporada> {
	private static Connection connection;

	@Override
	public void insertar(Temporada t) {
		
	}
	

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscarPorId(int i) {
		// TODO Auto-generated method stub
		
	}
	private static Connection openConnection() {
		DatabaseConexion dbConnection = new DatabaseConexion();
		connection = dbConnection.getConnection();
		return connection;

	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = null;
	}


}

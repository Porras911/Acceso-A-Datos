package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import utilsBD.DatabaseConexion;

public class SerieDao implements Dao<Serie> {
	
	
	private static Connection connection;
	
	
	public void SerieDao() {
		
	}
	@Override
	public void insertar(Serie t) {
		connection = openConnection();
		
		String query = "insert into series(titulo, edad, plataforma)"
				+"values (?, ?, ?)";
		
		try {
			PreparedStatement smt = connection.prepareStatement(query);
			
			smt.setString(1, t.getTitulo());
			smt.setInt(2, t.getEdad());
			smt.setString(3, t.getPlataforma());
			smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
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

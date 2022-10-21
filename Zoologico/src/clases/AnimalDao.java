package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilsDB.DatabaseConexion;

public abstract class AnimalDao {

	private static Connection connection;
	
	public static Animal findById(int id) {
		Animal a= null;
		connection= openConnection();
		String query = "select * from animales where id = ?";
		try {
			PreparedStatement smt = connection.prepareStatement(query);
			
			smt.setInt(1, id);
			ResultSet rs = smt.executeQuery();
			while(rs.next()) {
				 a = new Animal(rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("habitat"),
						rs.getFloat("peso_aprox"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
		
	}
	
	public static void deleteAnimalByName(String nombre) {
		connection = openConnection();
		String query ="delete from animales where nombre = ?";
		try {
			PreparedStatement smt = connection.prepareStatement(query);
			smt.setString(1, nombre);
			smt.executeUpdate();
			System.out.println("animal borrado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		}

	public static void insertarAnimal(Animal animal) {
		connection = openConnection();
		String query = "insert into animales(nombre, habitat, peso_aprox) " 
		+ "values (?,?,?)";
		try {

			PreparedStatement smt = connection.prepareStatement(query);
			smt.setString(1, animal.getNombre());
			smt.setString(2, animal.getHabitat());
			smt.setFloat(3, animal.getPeso_aproximado());
			smt.execute();
		//	System.out.println("Correcto");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public static void deleteAnimal() {
		connection = openConnection();
		
		String query = "delete from animales";
		
		try {
			Statement smt = connection.createStatement();
			smt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
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

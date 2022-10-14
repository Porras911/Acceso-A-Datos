package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utilsDB.DatabaseConexion;

public abstract class AnimalDao {

	private static Connection connection;

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
			System.out.println("Correcto");
			

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

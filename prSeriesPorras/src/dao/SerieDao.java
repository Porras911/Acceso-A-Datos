package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
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
	public void modificar(Serie serie) {
		int id = serie.getId();
		String titulo = serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();
		
		connection = openConnection();
		
		String query = "update series set titulo=?,edad=?,plataforma=?"
				+ "where id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.setInt(4, serie.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(Serie t) {
		int serie_id=t.getId();
		TemporadaDao  temporadaDao= new TemporadaDao();
		temporadaDao.borrarPorSerie(serie_id);
		
		connection = openConnection();
		String query=" delete from series where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Serie> series= new ArrayList<Serie>();
		connection = openConnection();
		String query = "select * from series";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			
			while(r.next()) {
				Serie serie = new Serie(
						r.getInt("id"),
						r.getString("titulo"),
						r.getInt("edad"),
						r.getString("plataforma"),
						null);
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return series;
	}

	@Override
	public Serie buscarPorId(int i) {
		Serie s= null;
		connection= openConnection();
		String query = "select * from series where id = ?";
		try {
			PreparedStatement smt = connection.prepareStatement(query);
			
			smt.setInt(1, i);
			ResultSet rs = smt.executeQuery();
			while(rs.next()) {
				 s = new Serie(rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null);
						 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		return s;
		
		
	}
	public ArrayList<Temporada> obtenerTemporadas(Serie serie){
		ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
		connection = openConnection();
		
		String query = "select * from temporadas where serie_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			
			ps.setInt(1, serie.getId());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Temporada temporada = new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo"),
						serie);
						temporadas.add(temporada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return temporadas;
		
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

package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		
		Serie serie = new Serie("Los Simpsons",7,"Disney Plus");
		Serie serie1 = new Serie("The Mandalorian",7,"Disney Plus");

		SerieDao serieDao = new SerieDao();
		serieDao.insertar(serie);
		serieDao.insertar(serie1);
		Serie s = serieDao.buscarPorId(13);
		Serie s1 = serieDao.buscarPorId(14);
		TemporadaDao temporadaDao = new TemporadaDao();
		Temporada t1 = new Temporada(1,"The Simpsons S1",s);
		Temporada t2 = new Temporada(2,"The Simpsons S2",s);
		Temporada t3 = new Temporada(3,"The Mandalorian S1",s1);
		Temporada t4 = new Temporada(4,"The Mandalorian S2",s1);
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		temporadaDao.insertar(t3);
		temporadaDao.insertar(t4);
		
		
//		serieDao.borrar(s1);
	



		

		
		
		
//		Serie s = serieDao.buscarPorId(2);
		
//		
//		Temporada t1 = new Temporada(1,"The Mandalorian S1",s);
//		Temporada t2 = new Temporada(2,"The Mandalorian S2",s);
//		Temporada t3 = new Temporada(3,"The Mandalorian Final S",s);
//		temporadaDao.insertar(t1);
//		temporadaDao.insertar(t2);
//		temporadaDao.insertar(t3);

//		temporadaDao.borrarPorSerie(2);
		
		
	}

}

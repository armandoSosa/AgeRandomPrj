package com.example.agerandomprj;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	
	String[] civilizaciones ={"Bizantinos","Aztecas","Bizantinos","Celtas","Chinos","Coreanos","Espa–oles","Francos","Godos","Hunos","Ingleses","Japoneses","Mayas","Mongoles","Persas","Sarracenos","Teutones","Turcos","Vikingos"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int cantidadJugadores = 8;
		ArrayList<Integer> equipos = generarEquiposRandom(cantidadJugadores);
		ArrayList<Integer> civilizaciones = generarCivilizacionesRandom(cantidadJugadores);
		for(int i=0;i<cantidadJugadores;i++){
			System.out.println("Civilizaci—n: "+this.civilizaciones[civilizaciones.get(i)]+" equipo: "+equipos.get(i));
		} 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public ArrayList<Integer> generarEquiposRandom(int numeroJugadores){
		ArrayList<Integer> equipos = new ArrayList<Integer>();
		int suma1 = 0;
		int suma2 = 0;
		int mitad = numeroJugadores/2;
		
		for(int i=0; i<numeroJugadores; i++){
			int equipo = generarRandom(1,2);
			
			if(equipo ==1){
				if(suma1<mitad){
					equipos.add(equipo);
					suma1++;
				}else{
					equipos.add(2);
				}
			}else{
				if(suma2<mitad){
					equipos.add(equipo);
					suma2++;
				}else{
					equipos.add(1);
				}
			}
		}
		return equipos;
	}
	
	public ArrayList<Integer> generarCivilizacionesRandom(int numeroJugadores){
		ArrayList<Integer> civilizaciones = new ArrayList<Integer>();
		
		for(int i=0; i<numeroJugadores; i++){
			int numero = generarRandom(0,(this.civilizaciones.length-1));
			
			while(civilizaciones.contains(numero)){
				numero = generarRandom(0,(this.civilizaciones.length-1));
			}
			civilizaciones.add(numero);
		}
		
		return civilizaciones;
	}
	
	public int generarRandom(int min, int max){
		Random r = new Random();
		return (r.nextInt(max - min + 1) + min);
	}

}

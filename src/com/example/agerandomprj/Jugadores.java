package com.example.agerandomprj;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Jugadores extends Activity {

	String[] civilizaciones ={"Bizantinos","Aztecas","Bizantinos","Celtas","Chinos","Coreanos","Espa–oles","Francos","Godos","Hunos","Ingleses","Japoneses","Mayas","Mongoles","Persas","Sarracenos","Teutones","Turcos","Vikingos"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jugadores);
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		TextView textView3 = (TextView) findViewById(R.id.textView3);
		TextView textView4 = (TextView) findViewById(R.id.textView4);
		TextView textView5 = (TextView) findViewById(R.id.textView5);
		TextView textView6 = (TextView) findViewById(R.id.textView6);
		TextView textView7 = (TextView) findViewById(R.id.textView7);
		TextView textView8 = (TextView) findViewById(R.id.textView8);
		TextView textView9 = (TextView) findViewById(R.id.textView9);
		
		
		Bundle bundle = getIntent().getExtras();
		int cantidadJugadores = bundle.getInt("cantidadJugadores");
		
		ArrayList<Integer> equipos = generarEquiposRandom(cantidadJugadores);
		ArrayList<Integer> civilizaciones = generarCivilizacionesRandom(cantidadJugadores);
		for(int i=0;i<cantidadJugadores;i++){
			String texto = "Jugador: "+ (i+1) + "\n Civilizaci—n: "+this.civilizaciones[civilizaciones.get(i)]+" equipo: "+equipos.get(i) + "\n";
			if(i==0){
				textView2.setText(texto);
			}else if(i==1){
				textView3.setText(texto);
			}else if(i==2){
				textView4.setText(texto);
			}else if(i==3){
				textView5.setText(texto);
			}else if(i==4){
				textView6.setText(texto);
			}else if(i==5){
				textView7.setText(texto);
			}else if(i==6){
				textView8.setText(texto);
			}else if(i==7){
				textView9.setText(texto);
			}
			
			System.out.println("Civilizaci—n: "+this.civilizaciones[civilizaciones.get(i)]+" equipo: "+equipos.get(i));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jugadores, menu);
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

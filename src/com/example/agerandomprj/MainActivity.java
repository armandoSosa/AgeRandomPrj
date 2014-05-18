package com.example.agerandomprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private Spinner spinner1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
        String []opciones={"1","2","3","4","5","6","7","8"};        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void operar(View view) {
        String selec=spinner1.getSelectedItem().toString();
        int cantidadJugadores = Integer.parseInt(selec);
        final Intent i = new Intent(this,Jugadores.class);
        i.putExtra("cantidadJugadores", cantidadJugadores);
        startActivity(i);
    }   

}

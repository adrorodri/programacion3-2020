package com.upb.programacion32020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class PersonasSpinnerActivity extends AppCompatActivity {

    ArrayList<Persona> listaPersonas = new ArrayList<>();
    ArrayList<String> listaProductos = new ArrayList<>();

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas_spinner);

        spinner = findViewById(R.id.spPersonas);

        listaPersonas.add(new Persona("Sergio", R.drawable.persona1));
        listaPersonas.add(new Persona("Gustavo", R.drawable.persona2));
        listaPersonas.add(new Persona("Keanu Reeves", R.drawable.persona3));

        listaProductos.add("Aspirina");
        listaProductos.add("Ibuprofeno");
        listaProductos.add("Vitamina C");
        listaProductos.add("Ensure");

        // Spinner de Strings
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProductos);

        // Spinner de Objetos personalizados
        PersonasBaseAdapter adapter = new PersonasBaseAdapter(this, listaPersonas);
        spinner.setAdapter(adapter);
    }
}

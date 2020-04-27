package com.upb.programacion32020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PersonasListViewActivity extends AppCompatActivity {

    ArrayList<Persona> listaPersonas = new ArrayList<>();

    ListView listViewUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas_list_view);

        listViewUsuarios = findViewById(R.id.lvUsuarios);

        listaPersonas.add(new Persona("Sergio", R.drawable.persona1));
        listaPersonas.add(new Persona("Gustavo", R.drawable.persona2));
        listaPersonas.add(new Persona("Keanu Reeves", R.drawable.persona3));

        PersonasAdapter adapter = new PersonasAdapter(this, listaPersonas);
        listViewUsuarios.setAdapter(adapter);
    }
}

package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class PersonasRecyclerActivity extends AppCompatActivity {

    ArrayList<Persona> listaPersonas = new ArrayList<>();

    RecyclerView recyclerViewPersonas;

    SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas_recycler);

        recyclerViewPersonas = findViewById(R.id.rvPersonas);

        sharedPreferencesManager = new SharedPreferencesManager(this);

        listaPersonas.add(new Persona("Sergio", R.drawable.persona1));
        listaPersonas.add(new Persona("Gustavo", R.drawable.persona2));
        listaPersonas.add(new Persona("Keanu Reeves", R.drawable.persona3));

        for(int i = 0; i < 1500; i++) {
            listaPersonas.add(new Persona("Keanu Reeves " + i, R.drawable.persona3));
        }

        PersonasRecyclerAdapter adapter = new PersonasRecyclerAdapter(this, listaPersonas);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Persona persona) {
                Toast.makeText(PersonasRecyclerActivity.this, persona.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PersonasRecyclerActivity.this, DetallesPersonaActivity.class);
                intent.putExtra("persona", persona);
                startActivity(intent);
            }
        });
        recyclerViewPersonas.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewPersonas.setAdapter(adapter);

        String username = sharedPreferencesManager.getUser().getUsername();
        Toast.makeText(this, "El Usuario guardado es: " + username, Toast.LENGTH_SHORT).show();
    }
}

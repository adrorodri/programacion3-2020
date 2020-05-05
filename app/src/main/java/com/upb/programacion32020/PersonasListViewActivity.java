package com.upb.programacion32020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        for (int i = 0; i < 1500; i++) {
            listaPersonas.add(new Persona("Keanu Reeves " + i, R.drawable.persona3));
        }

        PersonasAdapter adapter = new PersonasAdapter(this, listaPersonas);
        listViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(PersonasListViewActivity.this, listaPersonas.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PersonasListViewActivity.this, DetallesPersonaActivity.class);
                intent.putExtra("persona", listaPersonas.get(position));
                startActivity(intent);
            }
        });
        listViewUsuarios.setAdapter(adapter);



        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                Toast.makeText(this, intent.getStringExtra(Intent.EXTRA_TEXT), Toast.LENGTH_SHORT).show();
            }
        } else {
            // Manejar otro tipo de intent actions, MAIN, CALL, DIAL, SEND_MULTIPLE, etc...
        }
    }
}

package com.upb.programacion32020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class UsuariosActivity extends AppCompatActivity {

    ListView listViewUsuarios;

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        listViewUsuarios = findViewById(R.id.lvUsuarios);

        listaUsuarios.add(new Usuario("Sergio", R.drawable.persona1));
        listaUsuarios.add(new Usuario("Gustavo", R.drawable.persona2));
        listaUsuarios.add(new Usuario("Keanu Reeves", R.drawable.persona3));

        UsuariosAdapter adapter = new UsuariosAdapter(this, listaUsuarios);
        listViewUsuarios.setAdapter(adapter);
    }
}

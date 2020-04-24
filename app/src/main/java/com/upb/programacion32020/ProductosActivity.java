package com.upb.programacion32020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

    ArrayList<String> listaProductos = new ArrayList<>();

    ListView listViewProductos;
    Button buttonUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        listViewProductos = findViewById(R.id.lvProductos);
        buttonUsuarios = findViewById(R.id.btUsuarios);

        listaProductos.add("Aspirina");
        listaProductos.add("Ibuprofeno");
        listaProductos.add("Vitamina C");
        listaProductos.add("Ensure");

        for (int i = 0; i < 60; i++) {
            listaProductos.add("Producto " + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProductos);
        listViewProductos.setAdapter(adapter);

        buttonUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductosActivity.this, UsuariosActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

    ArrayList<String> listaProductos = new ArrayList<>();

    ListView listViewProductos;
    Button buttonPersonas;
    Button buttonPersonasSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        listViewProductos = findViewById(R.id.lvProductos);
        buttonPersonas = findViewById(R.id.btPersonas);
        buttonPersonasSpinner = findViewById(R.id.btPersonasSpinner);

        listaProductos.add("Aspirina");
        listaProductos.add("Ibuprofeno");
        listaProductos.add("Vitamina C");
        listaProductos.add("Ensure");

        for (int i = 0; i < 60; i++) {
            listaProductos.add("Producto " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProductos);
        listViewProductos.setAdapter(adapter);

        buttonPersonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductosActivity.this, PersonasListViewActivity.class);
                startActivity(intent);
            }
        });

        buttonPersonasSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductosActivity.this, PersonasSpinnerActivity.class);
                startActivity(intent);
            }
        });
    }
}

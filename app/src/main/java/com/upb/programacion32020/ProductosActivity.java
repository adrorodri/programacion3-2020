package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

//    ArrayList<String> listaProductos = new ArrayList<>();
    ArrayList<Product> listaProductos = new ArrayList<>();

    ListView listViewProductos;
    Button buttonPersonas;
    Button buttonPersonasSpinner;
    Button buttonPersonasRecycler;
    Button buttonNotifications;
    ImageButton ibCart;
    ImageButton ibShare;
    TextView tvTotal;

    CartSharedPreferencesManager cartSharedPreferencesManager;
    FileManager fileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        cartSharedPreferencesManager = new CartSharedPreferencesManager(this);
        fileManager = new FileManager(this);

        listViewProductos = findViewById(R.id.lvProductos);
        buttonPersonas = findViewById(R.id.btPersonas);
        buttonPersonasSpinner = findViewById(R.id.btPersonasSpinner);
        buttonPersonasRecycler = findViewById(R.id.btPersonasRecycler);
        buttonNotifications = findViewById(R.id.btNotifications);
        ibCart = findViewById(R.id.ibCart);
        ibShare = findViewById(R.id.ibShare);
        tvTotal = findViewById(R.id.tvTotal);

//        listaProductos.add("Aspirina");
//        listaProductos.add("Ibuprofeno");
//        listaProductos.add("Vitamina C");
//        listaProductos.add("Ensure");
//
//        for (int i = 0; i < 1500; i++) {
//            listaProductos.add("Producto " + i);
//        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProductos);

        listaProductos.add(new Product("Alcohol en Gel", R.drawable.product_alcohol_gel, 20));
        listaProductos.add(new Product("Barbijos", R.drawable.product_barbijo, 30));
        listaProductos.add(new Product("Guantes", R.drawable.product_guantes, 25));
        listaProductos.add(new Product("Lentes", R.drawable.product_lentes, 15));

        ProductsAdapter adapter = new ProductsAdapter(this, listaProductos);

        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                cartSharedPreferencesManager.addToCart(listaProductos.get(position));
                updateTotal();
            }
        });

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

        buttonPersonasRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductosActivity.this, PersonasRecyclerActivity.class);
                startActivity(intent);
            }
        });

        buttonNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductosActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        updateTotal();

        ibCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductosActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        ibShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Product> products = cartSharedPreferencesManager.getProducts();
                Gson gson = new Gson();
                fileManager.writeToFile(gson.toJson(products));
                Toast.makeText(ProductosActivity.this, "Archivo creado correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTotal();
    }

    private void updateTotal() {
        tvTotal.setText("Bs. " + cartSharedPreferencesManager.getTotal());
    }
}

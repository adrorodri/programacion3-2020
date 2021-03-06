package com.upb.programacion32020;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {

    RecyclerView rvShoppingCart;
    CartSharedPreferencesManager cartSharedPreferencesManager;
    FileManager fileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        rvShoppingCart = findViewById(R.id.rvShoppingCart);

        cartSharedPreferencesManager = new CartSharedPreferencesManager(this);
        fileManager = new FileManager(this);

        ArrayList<Product> products = cartSharedPreferencesManager.getProducts();
        final ShoppingCartRecyclerAdapter adapter = new ShoppingCartRecyclerAdapter(this, products);

        adapter.setOnShoppingCartClickListener(new OnShoppingCartClickListener() {
            @Override
            public void onDeleteItemClick(Product product) {
                cartSharedPreferencesManager.deleteFromCart(product);
                adapter.updateProducts(cartSharedPreferencesManager.getProducts());
            }
        });

        rvShoppingCart.setAdapter(adapter);
        rvShoppingCart.setLayoutManager(new LinearLayoutManager(this));

        // Read from file
        String productosString = fileManager.readFromFile();
        if (productosString != null) {
            Toast.makeText(this, productosString, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Archivo no existe", Toast.LENGTH_SHORT).show();
        }
    }
}

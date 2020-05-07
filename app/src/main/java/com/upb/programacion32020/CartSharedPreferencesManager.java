package com.upb.programacion32020;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CartSharedPreferencesManager {

    private Context context;

    public CartSharedPreferencesManager(Context context) {
        this.context = context;
    }

    public void addToCart(Product product) {
        ArrayList<Product> currentProducts = getProducts();
        currentProducts.add(product);

        SharedPreferences sharedPreferences = context.getSharedPreferences("ShoppingCart", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Simple
        Gson gson = new Gson();
        String productString = gson.toJson(currentProducts);

        editor.putString("products", productString);
        editor.apply();

        Toast.makeText(context, "Producto agregado al carrito correctamente", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Product> getProducts() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShoppingCart", Context.MODE_PRIVATE);
        String productosString = sharedPreferences.getString("products", "[]");

        // Simple
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
        ArrayList<Product> productos = gson.fromJson(productosString, listType);

        return productos;
    }

    public int getTotal() {
        int total = 0;
        for (Product product : getProducts()) {
            total += product.price;
        }
        return total;
    }
}

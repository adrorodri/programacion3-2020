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
        writeToSharedPreferences(currentProducts);
        Toast.makeText(context, "Producto agregado al carrito correctamente", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Product> getProducts() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShoppingCart", Context.MODE_PRIVATE);
        String productosString = sharedPreferences.getString("products", "[]");

        // Simple
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        ArrayList<Product> productos = gson.fromJson(productosString, listType);

        return productos;
    }

    public void deleteFromCart(Product product) {
        ArrayList<Product> products = getProducts();
        int position = -1;
        for (int i = 0; i < products.size(); i++) {
            if(product.name.equals(products.get(i).name)) {
                position = i;
                break;
            }
        }
        if(position > -1) {
            products.remove(position);
        }

        writeToSharedPreferences(products);
        Toast.makeText(context, "Producto eliminado del carrito correctamente", Toast.LENGTH_SHORT).show();
    }

    public void writeToSharedPreferences(ArrayList<Product> products) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShoppingCart", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Simple
        Gson gson = new Gson();
        String productString = gson.toJson(products);

        editor.putString("products", productString);
        editor.apply();
    }

    public int getTotal() {
        int total = 0;
        for (Product product : getProducts()) {
            total += product.price;
        }
        return total;
    }
}

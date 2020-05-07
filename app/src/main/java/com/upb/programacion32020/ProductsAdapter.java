package com.upb.programacion32020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> products;

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        super(context, R.layout.list_item_product, products);
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_product, null);

        ImageView ivProduct = view.findViewById(R.id.ivProduct);
        TextView tvProductName = view.findViewById(R.id.tvProductName);
        TextView tvProductPrice = view.findViewById(R.id.tvProductPrice);

        ivProduct.setImageResource(products.get(position).getImage());
        tvProductName.setText(products.get(position).getName());
        tvProductPrice.setText(String.valueOf(products.get(position).getPrice()));

        return view;
    }
}

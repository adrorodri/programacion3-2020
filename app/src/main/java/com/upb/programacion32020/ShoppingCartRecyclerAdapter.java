package com.upb.programacion32020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingCartRecyclerAdapter extends RecyclerView.Adapter<ShoppingCartRecyclerAdapter.ShoppingCartViewHolder> {

    private Context context;
    private ArrayList<Product> products;
    private OnShoppingCartClickListener onShoppingCartClickListener;

    public ShoppingCartRecyclerAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    public void setOnShoppingCartClickListener(OnShoppingCartClickListener onShoppingCartClickListener) {
        this.onShoppingCartClickListener = onShoppingCartClickListener;
    }

    public void updateProducts(ArrayList<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShoppingCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_shopping_cart, null);
        return new ShoppingCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartViewHolder holder, final int position) {
        holder.onBind(products.get(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onShoppingCartClickListener.onDeleteItemClick(products.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ShoppingCartViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        ImageButton button;

        public ShoppingCartViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tvProductName);
            imageView = itemView.findViewById(R.id.ivProductImage);
            button = itemView.findViewById(R.id.ibDelete);
        }

        public void onBind(Product product) {
            textView.setText(product.getName());
            imageView.setImageResource(product.getImage());
        }
    }
}
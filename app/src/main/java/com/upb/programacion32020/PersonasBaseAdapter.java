package com.upb.programacion32020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;

import java.util.ArrayList;

public class PersonasBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Persona> personas;

    public PersonasBaseAdapter(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View newView = LayoutInflater.from(context).inflate(R.layout.list_item_personas, null);

        ImageView ivUsuario = newView.findViewById(R.id.ivUsuario);
        TextView tvName = newView.findViewById(R.id.tvName);

        ivUsuario.setImageResource(personas.get(position).getImage());
        tvName.setText(personas.get(position).getNombre());

        return newView;
    }
}

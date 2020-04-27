package com.upb.programacion32020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonasAdapter extends ArrayAdapter<Persona> {

    private ArrayList<Persona> personas;

    public PersonasAdapter(Context context, ArrayList<Persona> personas) {
        super(context, R.layout.list_item_personas, personas);
        this.personas = personas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_personas, null);

        ImageView ivUsuario = view.findViewById(R.id.ivUsuario);
        TextView tvName = view.findViewById(R.id.tvName);

        ivUsuario.setImageResource(personas.get(position).getImage());
        tvName.setText(personas.get(position).getNombre());

        return view;
    }
}

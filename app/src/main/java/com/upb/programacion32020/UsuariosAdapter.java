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

public class UsuariosAdapter extends ArrayAdapter<Usuario> {

    private ArrayList<Usuario> usuarios;

    public UsuariosAdapter(Context context, ArrayList<Usuario> objects) {
        super(context, 0, objects);
        usuarios = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_usuarios, null);

        ImageView ivUsuario = view.findViewById(R.id.ivUsuario);
        TextView tvName = view.findViewById(R.id.tvName);

        ivUsuario.setImageResource(usuarios.get(position).getImage());
        tvName.setText(usuarios.get(position).getNombre());

        return view;
    }
}

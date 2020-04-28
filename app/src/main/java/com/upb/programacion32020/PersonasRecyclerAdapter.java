package com.upb.programacion32020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonasRecyclerAdapter extends RecyclerView.Adapter<PersonasRecyclerAdapter.PersonasViewHolder> {

    private Context context;
    private ArrayList<Persona> personas;
    private OnItemClickListener onItemClickListener;

    public PersonasRecyclerAdapter(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PersonasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_personas_staggered, null);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonasViewHolder holder, final int position) {
        holder.onBind(personas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(personas.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public PersonasViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.ivUsuario);
        }

        public void onBind(Persona persona) {
            textView.setText(persona.getNombre());
            imageView.setImageResource(persona.getImage());
        }
    }
}
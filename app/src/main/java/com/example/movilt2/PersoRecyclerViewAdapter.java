package com.example.movilt2;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movilt2.databinding.PersoCardviewBinding;

import java.util.ArrayList;

public class PersoRecyclerViewAdapter extends RecyclerView.Adapter<PersoViewHolder> {


    private final ArrayList<PersoMarioData> personajes;
    private final Context context;

    public PersoRecyclerViewAdapter(ArrayList<PersoMarioData> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    //Método creador de ViewHolder
    @NonNull
    @Override
    public PersoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersoCardviewBinding binding = PersoCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new PersoViewHolder(binding);
    }

    //Método para enlazar los datos del personaje con el viewHolder
    @Override
    public void onBindViewHolder(@NonNull PersoViewHolder holder, int position) {
        PersoMarioData currentPerso=this.personajes.get(position);
        holder.bind(currentPerso);

        //Manejar el evento clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentPerso,view));
    }

    //método para el clic
    private void itemClicked(PersoMarioData currentPerso, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        //((MainActivity) context).gameClicked(currentPerso, view);
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }
}

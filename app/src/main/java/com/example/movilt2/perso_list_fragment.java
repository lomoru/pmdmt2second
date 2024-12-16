package com.example.movilt2;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movilt2.databinding.PersoListFragmentBinding;

import java.util.ArrayList;


public class perso_list_fragment extends Fragment {

    private PersoListFragmentBinding binding;
    private ArrayList<PersoMarioData> personajes;
    private PersoRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding=PersoListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadPerso(); // Cargar los personajes

        // Configurar el RecyclerView

        adapter=new PersoRecyclerViewAdapter(personajes,getActivity());
        binding.persoRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.persoRecyclerview.setAdapter(adapter);

    }

    // Método para cargar personajes
    private void loadPerso() {
        personajes = new ArrayList<PersoMarioData>();
        personajes.add(new PersoMarioData(
                "@drawable/mario",
                "Mario"
        ));

        personajes.add(new PersoMarioData(
                "@drawable/peach",
                "Peach"
        ));

        personajes.add(new PersoMarioData(
                "@drawable/toad",
                "Toad"
        ));

        personajes.add(new PersoMarioData(
                "@drawable/luigi",
                "Luigi"
        ));


    }

    @Override
    public void onStart() {
        super.onStart();
        // OOOOOOOOOJJJJJJJJJJJJJJJJJJJJOOOOOOOOOOOOOOOO
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Lista de personajes");
        }
    }
}
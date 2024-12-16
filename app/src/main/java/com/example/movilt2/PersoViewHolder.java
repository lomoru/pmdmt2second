package com.example.movilt2;

import android.annotation.SuppressLint;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movilt2.databinding.PersoCardviewBinding;

public class PersoViewHolder extends RecyclerView.ViewHolder {

    private final PersoCardviewBinding binding;

    public PersoViewHolder(PersoCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (PersoMarioData perso){
        // Obtener el nombre de la imagen desde el objeto PersoMarioData
        String nombreImagen = perso.getImage();

        // Obtener el id del recurso en base al nombre de la imagen
        @SuppressLint("DiscouragedApi") int imageResId = binding.getRoot().getContext().getResources().getIdentifier(
                nombreImagen, "drawable", binding.getRoot().getContext().getPackageName()
        );

        // Establecer la imagen en el ImageView si el recurso existe
        if (imageResId != 0) {
            binding.image.setImageResource(imageResId);
        } else {
            // Manejar el caso en que la imagen no se encuentre (recurso no existe)
            binding.image.setImageResource(R.drawable.mario); // Imagen de Mario por defecto si no existe
        }

        //bindear el texto del nombre
        binding.name.setText(perso.getName());

        //Asegura que los cambios se apliquen de inmediato
        binding.executePendingBindings();

    }
}

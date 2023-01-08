package com.example.pokemon.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemon.R
import com.example.pokemon.models.Pokemon

class ViewHolderResultadoItem(inflate: View):RecyclerView.ViewHolder(inflate) {
    private val binding = com.example.pokemon.databinding.ListResultitemBinding.bind(inflate)

    fun render(item: Pokemon) {

        if (item.win == true){
            binding.cartaResultado.setBackgroundResource(R.color.purple_200)
        }else{
            binding.cartaResultado.setBackgroundResource(R.color.purple_500)
        }

        binding.nombre.text = item.nombre
        binding.vida.text = item.vida.toString()
        binding.tipo.text = item.tipo.toString()
        Glide.with(binding.imageView.context).load(item.url).into(binding.imageView)

    }

}
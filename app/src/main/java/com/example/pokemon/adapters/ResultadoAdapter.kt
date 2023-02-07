package com.example.pokemon.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.holders.ViewHolderResultadoItem
import com.example.pokemon.models.Pokemon
import com.example.pokemon.providers.PokemonProvider

class ResultadoAdapter(context: Context, listaPokemons:List<Pokemon>): RecyclerView.Adapter<ViewHolderResultadoItem>() {
    private val inflater = LayoutInflater.from(context)
    private var items:List<Pokemon> = listaPokemons


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderResultadoItem {
        return ViewHolderResultadoItem(inflater.inflate(R.layout.list_resultitem, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderResultadoItem, position: Int) {
        val item = items[position]

        holder.render(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

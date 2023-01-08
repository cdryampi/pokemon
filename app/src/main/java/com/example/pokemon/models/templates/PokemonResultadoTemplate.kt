package com.example.pokemon.models.templates

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.pokemon.MainActivity
import com.example.pokemon.R
import com.example.pokemon.adapters.ResultadoAdapter
import com.example.pokemon.controllers.PokemonControllerBattle
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.databinding.ActivityPokemonResultadoBinding
import com.example.pokemon.enums.PokemonAtaque
import com.example.pokemon.models.Pokemon

class PokemonResultadoTemplate {
    lateinit var binding: ActivityPokemonResultadoBinding
    lateinit var context: Context
    lateinit var listaPokemos: List<Pokemon>

    fun render(context: Context,intentPadre:Intent): ViewGroup {
        // Inicializar el binding
        binding = ActivityPokemonResultadoBinding.inflate(LayoutInflater.from(context))
        this.context = context

        val pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()
        val pokemonControllerBattle = PokemonControllerBattle()
        var intentVolver = Intent(this.context, MainActivity::class.java)

        var pokemonAtacante = intentPadre.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intentPadre.getParcelableExtra<PokemonBase>("pokemonDefensor")





        if (pokemonAtacante != null && pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)

            var auxList = pokemoncontrollerBattleDataAD.getAtaquante()
                ?.let { pokemonControllerBattle.battlePokemon(it,
                    pokemoncontrollerBattleDataAD.getDefensor()!!,
                    PokemonAtaque.BASICO,
                    PokemonAtaque.BASICO)
                }
            if (auxList != null) {
                listaPokemos = auxList
            }
            println()
            //println("pokemon atacante: ${auxAtacante?.nombre} - vida: ${auxAtacante?.vida}")
            //println("pokemon defensor: ${auxDefensor?.nombre} - vida: ${auxDefensor?.vida}")


        }




        binding.volver.setOnClickListener {
            this.context.startActivity(intentVolver)
        }
        initRecyclerView()
        return binding.root
    }
    fun initRecyclerView(){
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ResultadoAdapter(this.context, listaPokemos)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this.context)
    }
}
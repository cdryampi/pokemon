package com.example.pokemon.models.templates

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.pokemon.MainActivity
import com.example.pokemon.R
import com.example.pokemon.controllers.PokemonControllerBattle
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.enums.PokemonAtaque
import com.example.pokemon.models.Pokemon

class PokemonResultadoTemplate {

    lateinit var context: Context

    fun render(context: Context,intentPadre:Intent): ViewGroup {
        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var viewGroup = inflater.inflate(R.layout.activity_pokemon_resultado, null) as ViewGroup

        val pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()
        val pokemonControllerBattle = PokemonControllerBattle()
        var intentVolver = Intent(this.context, MainActivity::class.java)

        var pokemonAtacante = intentPadre.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intentPadre.getParcelableExtra<PokemonBase>("pokemonDefensor")
        var volver: Button = viewGroup.findViewById(R.id.volver)


        var nombreGanadorPokemonResultado: TextView = viewGroup.findViewById(R.id.nombreDefensorPokemonResultado)
        var tipoGanadorPokemonResultado: TextView = viewGroup.findViewById(R.id.tipoDefensorPokemonResultado)
        var vidaGanadorPokemonResultado: TextView = viewGroup.findViewById(R.id.vidaDefensorPokemonResultado)



        if (pokemonAtacante != null && pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)

            var auxList = pokemoncontrollerBattleDataAD.getAtaquante()
                ?.let { pokemonControllerBattle.battlePokemon(it,
                    pokemoncontrollerBattleDataAD.getDefensor()!!,
                    PokemonAtaque.BASICO,
                    PokemonAtaque.BASICO)
                }
            var auxAtacante: Pokemon? = auxList?.get(0)
            var auxDefensor: Pokemon? = auxList?.get(1)
            //println("pokemon atacante: ${auxAtacante?.nombre} - vida: ${auxAtacante?.vida}")
            //println("pokemon defensor: ${auxDefensor?.nombre} - vida: ${auxDefensor?.vida}")

            if (pokemoncontrollerBattleDataAD.getAtaquante()?.vida ?:0  > 0) {
                nombreGanadorPokemonResultado.text = pokemoncontrollerBattleDataAD.getAtaquante()?.nombre ?: "nulo"
                tipoGanadorPokemonResultado.text = pokemoncontrollerBattleDataAD.getAtaquante()?.tipo.toString()
                vidaGanadorPokemonResultado.text = pokemoncontrollerBattleDataAD.getAtaquante()?.vida.toString()
            } else {
                nombreGanadorPokemonResultado.text = pokemoncontrollerBattleDataAD.getDefensor()?.nombre ?: "nulo"
                tipoGanadorPokemonResultado.text = pokemoncontrollerBattleDataAD.getDefensor()?.tipo.toString()
                vidaGanadorPokemonResultado.text = pokemoncontrollerBattleDataAD.getDefensor()?.vida.toString()
            }
        }








        volver.setOnClickListener {
            this.context.startActivity(intentVolver)
        }
        return viewGroup
    }
}
package com.example.pokemon.models.templates

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.pokemon.PokemonResultado
import com.example.pokemon.R
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.enums.PokemonTipo

class PokemonBattleTemplate {

    lateinit var context: Context

    fun render(context: Context, intentPadre:Intent):ViewGroup{
        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var viewGroup = inflater.inflate(R.layout.activity_pokemon_battle, null) as ViewGroup


        this.context = context
        var pokemonAtacante = intentPadre.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intentPadre.getParcelableExtra<PokemonBase>("pokemonDefensor")
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()

        var intentPokemonResultado = Intent(this.context, PokemonResultado::class.java)


        if (pokemonAtacante != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
        }
        if (pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)
        }


        var nombrePokemonBattleAtacante: TextView = viewGroup.findViewById(R.id.nombrePokemonBattleAtacante)
        var nombrePokemonBattleDefensor: TextView = viewGroup.findViewById(R.id.nombreDefensorPokemonResultado)
        var tipoPokemonAtaque: TextView = viewGroup.findViewById(R.id.tipoPokemonBattleAtacante)
        var tipoPokemonDefensor: TextView = viewGroup.findViewById(R.id.tipoDefensorPokemonResultado)
        var vidaPokemonAtaque: TextView = viewGroup.findViewById(R.id.vidaPokemonBattleAtacante)
        var vidaPokemonDefensor: TextView = viewGroup.findViewById(R.id.vidaDefensorPokemonResultado)


        var atacarButton: Button = viewGroup.findViewById(R.id.atacarPokemonBattle)

        // atacante datos
        nombrePokemonBattleAtacante.text =
            pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable()?.nombre ?: "nulo"
        tipoPokemonAtaque.text =
            (pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable()?.tipo ?: PokemonTipo.FUEGO).toString()
        vidaPokemonAtaque.text =
            pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable()?.vida.toString()
        // defensor datos
        nombrePokemonBattleDefensor.text =
            pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable()?.nombre ?: "nulo"
        tipoPokemonDefensor.text =
            (pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable()?.tipo ?: PokemonTipo.FUEGO).toString()
        vidaPokemonDefensor.text =
            pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable()?.vida.toString()

        atacarButton.setOnClickListener {

            intentPokemonResultado.putExtra("pokemonAtacante", pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
            intentPokemonResultado.putExtra("pokemonDefensor", pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)
            context.startActivity(intentPokemonResultado)

        }
        println("intentData: ${pokemoncontrollerBattleDataAD.getAtaquante()}" )
        println("intentData: ${pokemoncontrollerBattleDataAD.getDefensor()}")

        return viewGroup
    }
}
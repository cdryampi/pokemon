package com.example.pokemon.models.templates

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.pokemon.BatallaTurno
import com.example.pokemon.PokemonResultado
import com.example.pokemon.R
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.enums.PokemonTipo

class PokemonBattleTemplate {

    lateinit var context: Context
    private lateinit var binding: com.example.pokemon.databinding.ActivityPokemonBattleBinding

    fun render(intentPadre:Intent):ViewGroup{

        // Inicializar el binding
        binding = com.example.pokemon.databinding.ActivityPokemonBattleBinding.inflate(LayoutInflater.from(context))

        //this.context = context
        // coger los datos del intentPadre
        var pokemonAtacante = intentPadre.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intentPadre.getParcelableExtra<PokemonBase>("pokemonDefensor")
        // inicializar el controlador de la batalla
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()
        // inistanciar los controlador de vistas
        var intentPokemonResultado = Intent(this.context, PokemonResultado::class.java)
        var intentBatallaTurno = Intent(this.context, BatallaTurno::class.java)

        // añadir los datos de los pokemon al controlador de la batalla
        if (pokemonAtacante != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
        }
        if (pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)
        }



        // atacante datos
        binding.nombrePokemonBattleAtacante.text = pokemoncontrollerBattleDataAD.getAtaquante()?.nombre ?: "No hay pokemon"
        binding.vidaPokemonBattleAtacante.text = pokemoncontrollerBattleDataAD.getAtaquante()?.vida.toString() ?: "No hay pokemon"
        binding.tipoPokemonBattleAtacante.text = pokemoncontrollerBattleDataAD.getAtaquante()?.tipo.toString() ?: "No hay pokemon"

        // defensor datos
        binding.nombreDefensorPokemonResultado.text = pokemoncontrollerBattleDataAD.getDefensor()?.nombre ?: "No hay pokemon"

        binding.vidaDefensorPokemonResultado.text = pokemoncontrollerBattleDataAD.getDefensor()?.vida.toString() ?: "No hay pokemon"
        binding.tipoDefensorPokemonResultado.text = pokemoncontrollerBattleDataAD.getDefensor()?.tipo.toString() ?: "No hay pokemon"


        // boton de atacar

        binding.atacarPokemonBattle.setOnClickListener {

            //intentPokemonResultado.putExtra("pokemonAtacante", pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
            //intentPokemonResultado.putExtra("pokemonDefensor", pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)
            intentPokemonResultado.putExtra("pokemonAtacante", pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
            intentPokemonResultado.putExtra("pokemonDefensor", pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)
            context.startActivity(intentPokemonResultado)
            //context.startActivity(intentPokemonResultado)

        }
        println("intentData: ${pokemoncontrollerBattleDataAD.getAtaquante()}" )
        println("intentData: ${pokemoncontrollerBattleDataAD.getDefensor()}")

        return this.binding.root
    }
}
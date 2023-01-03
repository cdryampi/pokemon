package com.example.pokemon.models.templates

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pokemon.PokemonBattle
import com.example.pokemon.R
import com.example.pokemon.controllers.PokemonControllerList
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.models.Pokemon
import com.example.pokemon.models.fragments.TestFragment

class Principal() {
    // context invoker

    lateinit var context: Context

    fun render(context:Context): ViewGroup {
        // call Inflate
        var inflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var viewGroup = inflate.inflate(R.layout.activity_main, null) as ViewGroup
        val intentPokemonBattle = Intent(this.context, PokemonBattle::class.java)

        // instanciar variables de la vista

        val POKEMON_ATACANTE = "pokemonAtacante"
        val POKEMON_DEFENSOR = "pokemonDefensor"

        var spinnerAtacante: Spinner = viewGroup.findViewById(R.id.spinnerAtacanteMainActivity)
        var spinnerDefensor: Spinner = viewGroup.findViewById(R.id.spinnerDefensorMainActivity)
        var buttonBatallar = viewGroup.findViewById<View>(R.id.buttonBatallarMainActivity)

        var pokemonControllerList = PokemonControllerList()
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()


        pokemonControllerList.genPokemons()

        var adapter1 = ArrayAdapter(this.context, android.R.layout.simple_spinner_item, pokemonControllerList.getPokemonList())
        var adapter2 = ArrayAdapter(this.context, android.R.layout.simple_spinner_item, pokemonControllerList.getPokemonList())

        spinnerAtacante.adapter = adapter1

        spinnerDefensor.adapter = adapter2

        spinnerAtacante.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // On selecting a spinner item
                val item = parent.getItemAtPosition(position) as Pokemon
                // Showing selected spinner item

                pokemoncontrollerBattleDataAD.setAtaquante(item)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                println("saliendo del spinner")
            }
        }
        spinnerDefensor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // On selecting a spinner item
                val item = parent.getItemAtPosition(position) as Pokemon
                // Showing selected spinner item

                pokemoncontrollerBattleDataAD.setDefensor(item)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                println("saliendo del spinner")
            }
        }
        buttonBatallar.setOnClickListener {
            intentPokemonBattle.putExtra(POKEMON_ATACANTE, pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
            intentPokemonBattle.putExtra(POKEMON_DEFENSOR, pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)
            startActivity(this.context, intentPokemonBattle, null)
        }


        return viewGroup
    }


}
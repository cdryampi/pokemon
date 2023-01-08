package com.example.pokemon.models.templates

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat.startActivity
import com.example.pokemon.PokemonBattle
import com.example.pokemon.controllers.PokemonControllerList
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.models.Pokemon

class Principal() {
    // context invoker
    private lateinit var binding: ActivityMainBinding
    lateinit var context: Context

    fun render(): ViewGroup {

        // inflate principal
        binding = ActivityMainBinding.inflate(this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)

        // call Inflate

        val intentPokemonBattle = Intent(this.context, PokemonBattle::class.java)

        // instanciar variables de la vista

        val POKEMON_ATACANTE = "pokemonAtacante"
        val POKEMON_DEFENSOR = "pokemonDefensor"


        var pokemonControllerList = PokemonControllerList()
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()


        pokemonControllerList.genPokemons()

        var adapter1 = ArrayAdapter(this.context, android.R.layout.simple_spinner_item, pokemonControllerList.getPokemonList())
        var adapter2 = ArrayAdapter(this.context, android.R.layout.simple_spinner_item, pokemonControllerList.getPokemonList())

        binding.spinnerAtacanteMainActivity.adapter = adapter1

        binding.spinnerDefensorMainActivity.adapter = adapter2

        binding.spinnerAtacanteMainActivity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        binding.spinnerDefensorMainActivity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        binding.buttonBatallarMainActivity.setOnClickListener {
            intentPokemonBattle.putExtra(POKEMON_ATACANTE, pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
            intentPokemonBattle.putExtra(POKEMON_DEFENSOR, pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)
            startActivity(this.context, intentPokemonBattle, null)
        }


        return this.binding.root
    }


}
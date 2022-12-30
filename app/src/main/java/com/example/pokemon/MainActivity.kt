package com.example.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.pokemon.controllers.PokemonControllerList
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.models.Pokemon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentPokemonBattle = Intent(this, PokemonBattle::class.java)
        val POKEMON_ATACANTE = "pokemonAtacante"
        val POKEMON_DEFENSOR = "pokemonDefensor"

        var spinnerAtacante:Spinner = findViewById(R.id.spinnerAtacanteMainActivity)
        var spinnerDefensor:Spinner = findViewById(R.id.spinnerDefensorMainActivity)
        var buttonBatallar = findViewById<View>(R.id.buttonBatallarMainActivity)

        var pokemonControllerList = PokemonControllerList()
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()


        pokemonControllerList.genPokemons()

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemonControllerList.getPokemonList())
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemonControllerList.getPokemonList())

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

                Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG)
                    .show()
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

                Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG)
                    .show()
                pokemoncontrollerBattleDataAD.setDefensor(item)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                println("saliendo del spinner")
            }
        }
        buttonBatallar.setOnClickListener {
            intentPokemonBattle.putExtra(POKEMON_ATACANTE, pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
            intentPokemonBattle.putExtra(POKEMON_DEFENSOR, pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)
            startActivity(intentPokemonBattle)
        }

        //pokemoncontrollerBattleDataAD.setDefensor(pokemonControllerList.getPokemonList()[3])


        //println(pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable())
        //println(pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable())

        //startActivity(intentPokemonBattle)
    }
}
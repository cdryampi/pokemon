package com.example.pokemon

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pokemon.controllers.PokemonControllerBattle
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.enums.PokemonAtaque
import com.example.pokemon.models.Pokemon

class PokemonResultado : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_resultado)


        val pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()
        val pokemonControllerBattle = PokemonControllerBattle()
        var intentVolver = Intent(this, MainActivity::class.java)
        var pokemonAtacante = intent.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intent.getParcelableExtra<PokemonBase>("pokemonDefensor")
        var volver:Button = findViewById(R.id.volver)


        var nombreGanadorPokemonResultado: TextView = findViewById(R.id.nombreGanadorPokemonResultado)
        var tipoGanadorPokemonResultado:TextView = findViewById(R.id.tipoGanadorPokemonResultado)
        var vidaGanadorPokemonResultado:TextView = findViewById(R.id.vidaGanadorPokemonResultado)



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
            println("pokemon atacante: ${auxAtacante?.nombre} - vida: ${auxAtacante?.vida}")
            println("pokemon defensor: ${auxDefensor?.nombre} - vida: ${auxDefensor?.vida}")

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
            startActivity(intentVolver)
        }

    }
}
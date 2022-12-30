package com.example.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.enums.PokemonTipo

class PokemonBattle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_battle)

        var pokemonAtacante = intent.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intent.getParcelableExtra<PokemonBase>("pokemonDefensor")
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()

        var intentPokemonResultado = Intent(this, PokemonResultado::class.java)


        if (pokemonAtacante != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
        }
        if (pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)
        }


        var nombrePokemonBattleAtacante:TextView = findViewById(R.id.nombrePokemonBattle)
        var nombrePokemonBattleDefensor:TextView = findViewById(R.id.nombreGanadorPokemonResultado)
        var tipoPokemonAtaque:TextView = findViewById(R.id.tipoPokemonBattle)
        var tipoPokemonDefensor:TextView = findViewById(R.id.tipoGanadorPokemonResultado)
        var vidaPokemonAtaque:TextView = findViewById(R.id.vidaPokemonBattle)
        var vidaPokemonDefensor:TextView = findViewById(R.id.vidaGanadorPokemonResultado)


        var atacarButton:Button = findViewById(R.id.atacarPokemonBattle)

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
            startActivity(intentPokemonResultado)

        }
        println("intentData: ${pokemoncontrollerBattleDataAD.getAtaquante()}" )
        println("intentData: ${pokemoncontrollerBattleDataAD.getDefensor()}")
    /*
        while (pokemoncontrollerBattleDataAD.getAtaquante()?.vida ?:0  > 0 && pokemoncontrollerBattleDataAD.getDefensor()?.vida ?: 0 > 0) {
            pokemoncontrollerBattleDataAD.getAtaquante()
                ?.let { pokemonControllerBattle.battlePokemon(it,
                    pokemoncontrollerBattleDataAD.getDefensor()!!,
                    PokemonAtaque.ESPECIAL,
                    PokemonAtaque.BASICO)
                }
        }
    */

    }


}
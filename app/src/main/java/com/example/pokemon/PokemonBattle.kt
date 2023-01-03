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
import com.example.pokemon.models.templates.PokemonBattleTemplate

class PokemonBattle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pokemonBattle = PokemonBattleTemplate()
        pokemonBattle.context = this
        setContentView(pokemonBattle.render(this, intent))



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
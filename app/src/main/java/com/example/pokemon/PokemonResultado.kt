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
import com.example.pokemon.models.templates.PokemonResultadoTemplate

class PokemonResultado : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pokemonResultadoTemplate = PokemonResultadoTemplate()
        pokemonResultadoTemplate.context = this
        setContentView(pokemonResultadoTemplate.render(this,intent))

    }
}
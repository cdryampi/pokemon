package com.example.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pokemon.interfaces.OnFragmentActionsListener
import com.example.pokemon.models.templates.Principal

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        // invocar todo
        var principalTemplate = Principal()
        principalTemplate.context = this
        setContentView(principalTemplate.render())


        //pokemoncontrollerBattleDataAD.setDefensor(pokemonControllerList.getPokemonList()[3])


        //println(pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable())
        //println(pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable())

        //startActivity(intentPokemonBattle)
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "Fragment button clicked", Toast.LENGTH_SHORT).show()
    }
}
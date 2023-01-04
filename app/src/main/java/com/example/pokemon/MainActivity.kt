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
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pokemon.controllers.PokemonControllerList
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.interfaces.OnFragmentActionsListener
import com.example.pokemon.models.Pokemon
import com.example.pokemon.models.fragments.TestFragment
import com.example.pokemon.models.fragments.fragment2
import com.example.pokemon.models.templates.Principal

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        // invocar todo
        var principalTemplate = Principal()
        principalTemplate.context = this
        var viewGroup = principalTemplate.render(principalTemplate.context)
        setContentView(viewGroup)




        //pokemoncontrollerBattleDataAD.setDefensor(pokemonControllerList.getPokemonList()[3])


        //println(pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable())
        //println(pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable())

        //startActivity(intentPokemonBattle)
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "Fragment button clicked", Toast.LENGTH_SHORT).show()
    }
}
package com.example.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.interfaces.OnFragmentActionsListener
import com.example.pokemon.models.Pokemon
import com.example.pokemon.models.fragments.GanadorBatallaTurno
import com.example.pokemon.models.fragments.GanadorBatallaTurno.Companion.newInstance
import com.example.pokemon.models.fragments.TestFragment
import com.example.pokemon.models.fragments.fragment2

class BatallaTurno : AppCompatActivity(), OnFragmentActionsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batalla_turno)


        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()
        //var pokemonAtacante = intent.getParcelableExtra<PokemonBase>("pokemonAtacante")
        //var pokemonDefensor = intent.getParcelableExtra<PokemonBase>("pokemonDefensor")

        var pokemonAtacante = intent.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intent.getParcelableExtra<PokemonBase>("pokemonDefensor")

        if (pokemonAtacante != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
        }
        if (pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)
        }
        newInstance(pokemoncontrollerBattleDataAD!!)


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<GanadorBatallaTurno>(R.id.fragmentBatallaTurno)
        }

    }




    override fun onClickFragmentButton() {
        //var intent = Intent(this, PokemonBattle::class.java)
        var intentBatallaTurno = Intent(this, PokemonBattle::class.java)
        var pokemoncontrollerBattleDataAD = PokemoncontrollerBattleDataAD()
        //var pokemonAtacante = intent.getParcelableExtra<PokemonBase>("pokemonAtacante")
        //var pokemonDefensor = intent.getParcelableExtra<PokemonBase>("pokemonDefensor")

        var pokemonAtacante = intent.getParcelableExtra<PokemonBase>("pokemonAtacante")
        var pokemonDefensor = intent.getParcelableExtra<PokemonBase>("pokemonDefensor")

        if (pokemonAtacante != null) {
            pokemoncontrollerBattleDataAD.setPokemonAtacanteParcelable(pokemonAtacante)
        }
        if (pokemonDefensor != null) {
            pokemoncontrollerBattleDataAD.setPokemonDefensorParcelable(pokemonDefensor)
        }

        //println("Batalla turno: ${intent.getParcelableExtra<PokemonBase>("pokemonAtacante")}")
        //println("Batalla turno: ${intent.getParcelableExtra<PokemonBase>("pokemonDefensor")}")

        intentBatallaTurno.putExtra("pokemonAtacante", pokemoncontrollerBattleDataAD.getPokemonAtacanteParcelable() as Parcelable)
        intentBatallaTurno.putExtra("pokemonDefensor", pokemoncontrollerBattleDataAD.getPokemonDefensorParcelable() as Parcelable)

        startActivity(intentBatallaTurno)
    }
}
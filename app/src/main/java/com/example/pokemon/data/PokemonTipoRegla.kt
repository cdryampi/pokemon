package com.example.pokemon.data

import com.example.pokemon.enums.PokemonTipo

data class PokemonTipoRegla(val efectivo:PokemonTipo, val noEfectivo:PokemonTipo){


    fun esEfectivo(tipo:PokemonTipo):Boolean{
        return tipo == efectivo
    }

    fun esNoEfectivo(tipo:PokemonTipo):Boolean{
        return tipo == noEfectivo
    }

}

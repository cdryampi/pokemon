package com.example.pokemon.models

import com.example.pokemon.data.PokemonBase

import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.interfaces.PokemonAtaque
import com.example.pokemon.interfaces.PokemonDefensa

open class ResumenPokemon{
    open fun estado():String{
        return "vivo"
    }
}

abstract class PokemonMain : ResumenPokemon(), PokemonDefensa, PokemonAtaque {
    abstract val nombre: String
    abstract val tipo: PokemonTipo
    abstract var vida: Int
    abstract var defensa: Int
    abstract var ataque: Int
    abstract var url: String
    abstract var win: Boolean
    override fun estado(): String {
        return if (vida > 0) "vivo" else "muerto"
    }
}

class Pokemon(
    override var nombre: String,
    override var tipo: PokemonTipo,
    override var vida: Int,
    override var ataque: Int,
    override var defensa: Int,
    override var url: String,
    override var win: Boolean



) : PokemonMain() {


    override fun defensaBasica() {
        TODO("Not yet implemented")
    }

    override fun ataqueBasico() {
        TODO("Not yet implemented")
    }

    override fun ataqueEspecial() {
        TODO("Not yet implemented")
    }

    override fun ataqueUnico() {
        TODO("Not yet implemented")
    }
    override fun toString(): String {
        return nombre
    }
}
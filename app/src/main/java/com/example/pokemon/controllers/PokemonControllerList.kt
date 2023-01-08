package com.example.pokemon.controllers

import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.models.Pokemon
import com.example.pokemon.providers.PokemonProvider

class PokemonControllerList {
    var pokemonList = mutableListOf<Pokemon>()



    fun addPokemon(pokemon:Pokemon){
        pokemonList.add(pokemon)
    }

    @JvmName("getPokemonList1")
    fun getPokemonList():MutableList<Pokemon>{
        return pokemonList
    }

    fun genPokemons(){
        pokemonList  = PokemonProvider.coleccion_pokemons as MutableList<Pokemon>
    }
}
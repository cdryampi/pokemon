package com.example.pokemon.controllers

import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.models.Pokemon

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

        addPokemon(Pokemon("Pikachu",PokemonTipo.TRUENO, 1035, 40, 56))
        addPokemon(Pokemon("Charmander",PokemonTipo.FUEGO, 1035, 40, 56))
        addPokemon(Pokemon("Squirtle",PokemonTipo.AGUA, 1035, 40, 56))
        addPokemon(Pokemon("Bulbasaur",PokemonTipo.HIERBA, 1035, 40, 56))
        addPokemon(Pokemon("Pidgey",PokemonTipo.HIERBA, 1035, 40, 56))
        addPokemon(Pokemon("Rattata",PokemonTipo.HIERBA, 1035, 40, 56))
        addPokemon(Pokemon("Caterpie",PokemonTipo.HIERBA, 1035, 40, 56))
        addPokemon(Pokemon("Weedle",PokemonTipo.HIERBA, 1035, 40, 56))
        addPokemon(Pokemon("Pidgeotto",PokemonTipo.TRUENO, 1035, 40, 56))
        addPokemon(Pokemon("Pidgeot",PokemonTipo.AGUA, 1035, 40, 56))
        addPokemon(Pokemon("Raticate",PokemonTipo.FUEGO, 1035, 40, 56))
    }
}
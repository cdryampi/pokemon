package com.example.pokemon.providers

import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.models.Pokemon

class PokemonProvider {
    companion object {
        val coleccion_pokemons = listOf<Pokemon>(
                    Pokemon("Pikachu", PokemonTipo.TRUENO, 1035, 40, 56,"https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",false),
                    Pokemon("Charmander", PokemonTipo.FUEGO, 1035, 40, 56,"https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",false),
                    Pokemon("Squirtle", PokemonTipo.AGUA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",false),
                    Pokemon("Bulbasaur", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",false),
                    Pokemon("Pidgey", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/016.png",false),
                    Pokemon("Rattata", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/019.png",false),
                    Pokemon("Caterpie", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/010.png",false),
                    Pokemon("Weedle", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/013.png",false),
                    Pokemon("Pidgeotto", PokemonTipo.TRUENO, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/017.png",false),
                    Pokemon("Pidgeot", PokemonTipo.AGUA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/018.png",false),
                    Pokemon("Raticate", PokemonTipo.FUEGO, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/020.png",false),
                    Pokemon("Spearow", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/021.png",false),
                    Pokemon("Fearow", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/022.png",false),
                    Pokemon("Ekans", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/023.png",false),
                    Pokemon("Arbok", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/024.png",false),
                    Pokemon("Raichu", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/026.png",false),
                    Pokemon("Sandshrew", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/027.png",false),
        )
    }
}
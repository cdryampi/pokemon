package com.example.pokemon.providers

import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.models.Pokemon

class PokemonProvider {
    companion object {
        val coleccion_pokemons = listOf<Pokemon>(
                    Pokemon("Pikachu", PokemonTipo.TRUENO, 1035, 40, 56,"https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png"),
                    Pokemon("Charmander", PokemonTipo.FUEGO, 1035, 40, 56,"https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png"),
                    Pokemon("Squirtle", PokemonTipo.AGUA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png"),
                    Pokemon("Bulbasaur", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"),
                    Pokemon("Pidgey", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/016.png"),
                    Pokemon("Rattata", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/019.png"),
                    Pokemon("Caterpie", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/010.png"),
                    Pokemon("Weedle", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/013.png"),
                    Pokemon("Pidgeotto", PokemonTipo.TRUENO, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/017.png"),
                    Pokemon("Pidgeot", PokemonTipo.AGUA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/018.png"),
                    Pokemon("Raticate", PokemonTipo.FUEGO, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/020.png"),
                    Pokemon("Spearow", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/021.png"),
                    Pokemon("Fearow", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/022.png"),
                    Pokemon("Ekans", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/023.png"),
                    Pokemon("Arbok", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/024.png"),
                    Pokemon("Raichu", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/026.png"),
                    Pokemon("Sandshrew", PokemonTipo.HIERBA, 1035, 40, 56, "https://assets.pokemon.com/assets/cms2/img/pokedex/full/027.png"),
        )
    }
}
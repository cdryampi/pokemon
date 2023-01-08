package com.example.pokemon.controllers

import com.example.pokemon.data.PokemonBase
import com.example.pokemon.models.Pokemon
import com.example.pokemon.models.PokemonMain

class PokemoncontrollerBattleDataAD(var ataquante: Pokemon? = null, var defensor: Pokemon? = null) {

        var pokemonAtacanteParcelable:PokemonBase? = null
        var pokemonDefensorParcelable:PokemonBase? = null

        @JvmName("setAtaquante1")
        fun setAtaquante(ataquante: Pokemon) {
            this.ataquante = ataquante
            this.pokemonAtacanteParcelable =
                PokemonBase(
                    ataquante.nombre,
                    ataquante.tipo,
                    ataquante.vida,
                    ataquante.defensa,
                    ataquante.ataque,
                    ataquante.url,
                    ataquante.win

                )

        }

        @JvmName("setPokemonAtacanteParcelable1")
        fun setPokemonAtacanteParcelable(pokemonAtacanteParcelable: PokemonBase) {
            this.pokemonAtacanteParcelable = pokemonAtacanteParcelable
            this.ataquante= Pokemon(
                this.pokemonAtacanteParcelable!!.nombre,
                this.pokemonAtacanteParcelable!!.tipo,
                this.pokemonAtacanteParcelable!!.vida,
                this.pokemonAtacanteParcelable!!.defensa,
                this.pokemonAtacanteParcelable!!.ataque,
                this.pokemonAtacanteParcelable!!.url,
                this.pokemonAtacanteParcelable!!.win
            )
        }

        @JvmName("setPokemonDefensorParcelable1")
        fun setPokemonDefensorParcelable(pokemonDefensorParcelable: PokemonBase) {
            this.pokemonDefensorParcelable = pokemonDefensorParcelable
            this.defensor = Pokemon(
                this.pokemonDefensorParcelable!!.nombre,
                this.pokemonDefensorParcelable!!.tipo,
                this.pokemonDefensorParcelable!!.vida,
                this.pokemonDefensorParcelable!!.defensa,
                this.pokemonDefensorParcelable!!.ataque,
                this.pokemonDefensorParcelable!!.url,
                this.pokemonDefensorParcelable!!.win
            )
        }

        @JvmName("setDefensor1")
        fun setDefensor(defensor: Pokemon) {
            this.defensor = defensor

            this.pokemonDefensorParcelable =
                PokemonBase(
                    defensor.nombre,
                    defensor.tipo,
                    defensor.vida,
                    defensor.defensa,
                    defensor.ataque,
                    defensor.url,
                    defensor.win
                )

        }

        @JvmName("getAtaquante1")
        fun getAtaquante(): Pokemon? {
            return ataquante
        }

        @JvmName("getDefensor1")
        fun getDefensor(): Pokemon? {
            return defensor
        }

        @JvmName("getPokemonAtacanteParcelable1")
        fun getPokemonAtacanteParcelable():PokemonBase?{
            return pokemonAtacanteParcelable
        }

        @JvmName("getPokemonDefensorParcelable1")
        fun getPokemonDefensorParcelable():PokemonBase?{
            return pokemonDefensorParcelable
        }
        fun reset() {
            ataquante = null
            defensor = null
        }
}
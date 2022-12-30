package com.example.pokemon.controllers

import com.example.pokemon.data.PokemonTipoRegla
import com.example.pokemon.enums.PokemonAtaque
import com.example.pokemon.enums.PokemonAtaqueClase
import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.models.Pokemon

class PokemonControllerBattle {
    var battleDescriptor = mapOf(
        PokemonTipo.AGUA to listOf(
            PokemonTipoRegla(PokemonTipo.FUEGO, PokemonTipo.HIERBA)
        ),
        PokemonTipo.FUEGO to listOf(
            PokemonTipoRegla(PokemonTipo.HIERBA, PokemonTipo.AGUA)
        ),
        PokemonTipo.HIERBA to listOf(
            PokemonTipoRegla(PokemonTipo.AGUA, PokemonTipo.FUEGO)
        ),
        PokemonTipo.TRUENO to listOf(
            PokemonTipoRegla(PokemonTipo.AGUA, PokemonTipo.HIERBA)
        )
    )
    fun battlePokemon(atacante:Pokemon, defensor:Pokemon, ataque: PokemonAtaque, defensa:PokemonAtaque):ArrayList<Pokemon>{

        var resultado = ArrayList<Pokemon>()

        while (atacante?.vida ?:0  > 0 && defensor?.vida ?: 0 > 0) {
            var efectividad = 1.0

            if (atacante.vida > 0 && defensor.vida >0) {

                if (battleDescriptor[atacante.tipo]!!.any { it.esEfectivo(defensor.tipo) }) {
                    efectividad = 2.0
                } else if (battleDescriptor[atacante.tipo]!!.any { it.esNoEfectivo(defensor.tipo) }) {
                    efectividad = 0.5

                } else {
                    efectividad = 1.0
                }
                if (defensor.vida>0){
                    var diferencia = 0

                    diferencia = ((10..50).random()) +((defensor.ataque / atacante.defensa) * efectividad.toInt()).toInt()
                    defensor.vida -= diferencia


                    println("vida atacante ${atacante.vida}")
                    println("vida defensor ${defensor.vida}")

                    if (defensor.vida<0){
                        defensor.vida = 0
                        resultado.add(atacante)
                        resultado.add(defensor)
                        println("Pokemon defensor ${defensor.nombre} ha sido derrotado")
                        return resultado
                    }
                }

                if (battleDescriptor[defensor.tipo]!!.any { it.esEfectivo(atacante.tipo) }) {
                    efectividad = 0.5
                } else if (battleDescriptor[defensor.tipo]!!.any { it.esNoEfectivo(atacante.tipo) }) {
                    efectividad = 2.0

                } else {
                    efectividad = 1.0
                }


                if (atacante.vida>0){
                    var diferencia = 0

                    diferencia = ((10..50).random()) +((defensor.ataque / atacante.defensa) * efectividad.toInt()).toInt()
                    atacante.vida -= diferencia


                    println("vida atacante ${atacante.vida}")
                    println("vida defensor ${defensor.vida}")


                    if (atacante.vida<0){
                        atacante.vida = 0
                        resultado.add(atacante)
                        resultado.add(defensor)
                        println("Pokemon atacante ${atacante.nombre} ha sido derrotado")
                        return resultado
                    }
                }

        }






        }
        resultado.add(atacante)
        resultado.add(defensor)
        return resultado
    }
}
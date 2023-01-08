package com.example.pokemon.models.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pokemon.R
import com.example.pokemon.controllers.PokemoncontrollerBattleDataAD
import com.example.pokemon.data.PokemonBase
import com.example.pokemon.enums.PokemonTipo
import com.example.pokemon.interfaces.OnFragmentActionsListener
import com.example.pokemon.models.Pokemon



private var ARG_GANADOR:Pokemon = Pokemon(
    "Ganador",
    PokemonTipo.TRUENO,
    0,
    0,
    0,
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
)

class GanadorBatallaTurno : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnFragmentActionsListener? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listener = it.getSerializable("listener") as OnFragmentActionsListener
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionsListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentActionsListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.buttonVolver).setOnClickListener {
            listener?.onClickFragmentButton()
        }
        // pintando datos del pokemon ganador
        view.findViewById<TextView>(R.id.ganadorTurno).text = ARG_GANADOR.nombre
        view.findViewById<TextView>(R.id.GanadorVida).text = ARG_GANADOR.vida.toString()
        view.findViewById<TextView>(R.id.ganadorMensaje).text = "tu pokemon ha ganado el turno"
        var image = view.findViewById<ImageView>(R.id.ImagePokemon)
        Glide.with(this).load(ARG_GANADOR.url).into(image)

    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_ganador_batalla_turno, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GanadorBatallaTurno.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: PokemoncontrollerBattleDataAD) =
            GanadorBatallaTurno().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_GANADOR, param1)
                }


            }

        private fun putSerializable(argGanador: Pokemon, param1: PokemoncontrollerBattleDataAD) {
            argGanador.nombre = param1.getAtaquante()?.nombre ?: "picachu"
            argGanador.vida = param1.getAtaquante()?.vida ?: 0
            argGanador.ataque = param1.getAtaquante()?.ataque ?: 0
            argGanador.defensa = param1.getAtaquante()?.defensa ?: 0
            argGanador.tipo = param1.getAtaquante()?.tipo ?: PokemonTipo.TRUENO
            argGanador.url = param1.getAtaquante()?.url ?: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
        }


    }
}
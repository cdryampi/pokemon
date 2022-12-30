package com.example.pokemon.data

import android.os.Parcel
import android.os.Parcelable
import com.example.pokemon.enums.PokemonTipo

data class PokemonBase(val nombre:String, val tipo:PokemonTipo, val vida:Int, val ataque:Int, val defensa:Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        PokemonTipo.valueOf(parcel.readString().toString()),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(tipo.name)
        parcel.writeInt(vida)
        parcel.writeInt(ataque)
        parcel.writeInt(defensa)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonBase> {
        override fun createFromParcel(parcel: Parcel): PokemonBase {
            return PokemonBase(parcel)
        }

        override fun newArray(size: Int): Array<PokemonBase?> {
            return arrayOfNulls(size)
        }
    }
}

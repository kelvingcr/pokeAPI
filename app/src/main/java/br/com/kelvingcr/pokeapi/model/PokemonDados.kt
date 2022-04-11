package br.com.kelvingcr.pokeapi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PokemonDados (

    @SerializedName("name")
    var name : String,
    @SerializedName("sprites")
    var sprites : Sprites,
    @SerializedName("types")
    var types : List<Types>
) : Serializable

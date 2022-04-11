package br.com.kelvingcr.pokeapi.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sprites (

    @SerializedName("front_default")
    var front_default : String,
) : Serializable


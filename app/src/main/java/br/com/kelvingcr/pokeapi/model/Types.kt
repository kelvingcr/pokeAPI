package br.com.kelvingcr.pokeapi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Types (

    @SerializedName("slot")
    var slot : Int,
    @SerializedName("type")
    var type : Type,
) : Serializable

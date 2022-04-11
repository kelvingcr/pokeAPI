package br.com.kelvingcr.pokeapi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results (

    @SerializedName("name")
    var name : String,
    @SerializedName("url")
    var url : String
) : Serializable
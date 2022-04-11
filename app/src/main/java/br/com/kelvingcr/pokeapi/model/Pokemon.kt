package br.com.kelvingcr.pokeapi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pokemon (
    @SerializedName("results")
    var count: List<Results>
) : Serializable
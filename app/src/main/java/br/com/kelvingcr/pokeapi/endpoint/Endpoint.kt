package br.com.kelvingcr.pokeapi.endpoint

import br.com.kelvingcr.pokeapi.model.Pokemon
import br.com.kelvingcr.pokeapi.model.PokemonDados
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    /*
    Container do tipo Call para processar as requisições em uma Thread separada e de forma assincrona.
     */

    @GET("pokemon")
    fun getPokemon() : Call<Pokemon>

    @GET("pokemon/{name}")
    fun getPokemonDados(@Path("name") id: String): Call<PokemonDados>
}
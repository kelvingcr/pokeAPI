package br.com.kelvingcr.pokeapi.endpoint

import br.com.kelvingcr.pokeapi.model.Pokemon
import br.com.kelvingcr.pokeapi.model.PokemonDados
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface Endpoint {

    /*
    Container do tipo Call para processar as requisições em uma Thread separada e de forma assincrona.
     */

    @GET("pokemon?offset=0&limit=20")
    fun getPokemon() : Call<Pokemon>

    @GET("pokemon?offset=0&limit=40")
    fun getPokemonLimit() : Call<Pokemon>

    @GET("pokemon/{name}")
    fun getPokemonDados(@Path("name") id: String): Call<PokemonDados>

    @GET("pokemon")
    fun getPokemonDados2(@Query("offset") offset: Int,
                         @Query("limit") limit: Int): Call<Pokemon>
}
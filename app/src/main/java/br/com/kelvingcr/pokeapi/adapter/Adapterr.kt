package br.com.kelvingcr.pokeapi.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.pokeapi.endpoint.Endpoint
import br.com.kelvingcr.pokeapi.InfoPokeActivity
import br.com.kelvingcr.pokeapi.NetworkUtils
import br.com.kelvingcr.pokeapi.databinding.AdapterPokemonsBinding
import br.com.kelvingcr.pokeapi.model.Pokemon
import br.com.kelvingcr.pokeapi.model.PokemonDados
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable


class Adapterr(
    private val context: Context,
    private val pokeList: List<Pokemon>,
) : RecyclerView.Adapter<Adapterr.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            AdapterPokemonsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val task = pokeList[position]

        val retrofitClient = NetworkUtils.getRetrofitInstance("https://pokeapi.co/api/v2/")
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPokemonDados(task.count[position].name)


        callback.enqueue(object : Callback<PokemonDados> {

            override fun onFailure(call: Call<PokemonDados>, t: Throwable) {

            }

            override fun onResponse(call: Call<PokemonDados>, response: Response<PokemonDados>) {
                val poke = response.body();
                Picasso.get().load(poke?.sprites?.front_default.toString())
                    .into(holder.binding.imagem);

                holder.binding.imagem.setOnClickListener {
                    val intent = Intent( holder.binding.imagem.context, InfoPokeActivity::class.java)
                    intent.putExtra("pokeDados", poke as Serializable)
                    holder.binding.imagem.context.startActivity(intent)
                }
            }
        })
    }



    override fun getItemCount() = pokeList.size

    inner class MyViewHolder(val binding: AdapterPokemonsBinding) :
        RecyclerView.ViewHolder(binding.root)

}
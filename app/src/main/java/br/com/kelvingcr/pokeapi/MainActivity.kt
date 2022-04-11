package br.com.kelvingcr.pokeapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.pokeapi.databinding.ActivityMainBinding
import br.com.kelvingcr.pokeapi.model.Pokemon
import br.com.kelvingcr.pokeapi.endpoint.Endpoint
import br.com.kelvingcr.pokeapi.adapter.Adapterr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val list = arrayListOf<Pokemon>()
    private lateinit var pokeAdapter: Adapterr
    private val pokeList = mutableListOf<Pokemon>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        initAdapter()
    }

       fun getData() {
       val retrofitClient = NetworkUtils.getRetrofitInstance("https://pokeapi.co/api/v2/")

       val endpoint = retrofitClient.create(Endpoint::class.java)
       val callback = endpoint.getPokemon()

       callback.enqueue(object : Callback<Pokemon> {
           override fun onFailure(call: Call<Pokemon>, t: Throwable) {
               Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
               println(t.message)
           }

           override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
               val poke = response.body();
               println(poke?.count?.get(0)?.name)
                    for(i in 0 until poke?.count?.size!!){
                        pokeList.add(poke)
                  }

               pokeAdapter.notifyDataSetChanged()
           }
       })

   }

    private fun initAdapter() {
        binding.rvTask.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvTask.setHasFixedSize(true)
        pokeAdapter = Adapterr(this, pokeList)
        binding.rvTask.adapter = pokeAdapter
    }
}
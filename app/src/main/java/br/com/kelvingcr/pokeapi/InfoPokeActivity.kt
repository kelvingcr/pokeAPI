package br.com.kelvingcr.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.kelvingcr.pokeapi.databinding.ActivityInfoPokeBinding
import br.com.kelvingcr.pokeapi.databinding.ActivityMainBinding
import br.com.kelvingcr.pokeapi.model.PokemonDados
import br.com.kelvingcr.pokeapi.model.Types
import com.squareup.picasso.Picasso

class InfoPokeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInfoPokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPokeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
            val poke = intent.extras?.get("pokeDados") as PokemonDados

            Picasso.get().load(poke?.sprites?.front_default.toString())
                .into(binding.imagem);

            binding.nomePoke.text = poke.name
            if(poke?.types?.size == 2) {
                binding.txtTypes.text = poke?.types?.get(0)?.type.name + " e " + poke?.types?.get(1)?.type.name
            }else{
                binding.txtTypes.text = poke?.types?.get(0)?.type.name
            }

        }
    }


}
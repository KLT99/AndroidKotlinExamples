package com.klt.androidkotlinexamples.supeheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.klt.androidkotlinexamples.databinding.ActivitySuperHeroListBinding
import com.klt.androidkotlinexamples.supeheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://superheroapi.com/
//Access token fd30b57487d58126977915f06e349f67
class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        retrofit = getRetrofit()
        initUI()

    }

    private fun initUI() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            //realiza consulta cuando da en el boton buscar
            override fun onQueryTextSubmit(query: String?): Boolean {
                //envia texto vacio
                searchByName(query.orEmpty())
                return false
            }

            //Realice la consulta cuando cambia el texto
            override fun onQueryTextChange(newText: String?) = false

        })

        adapter = SuperHeroAdapter(){
            superheroId -> navigateToDetail(superheroId)
        }
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter

    }

    //muestra
    private fun searchByName(query: String) {

        binding.progressBar.isVisible = true

        //Corrutinas Hilo Secundario //IO hilo secundario para procesos muy largos
        CoroutineScope(Dispatchers.IO).launch { 
            val myResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes(query)

            if (myResponse.isSuccessful){
                val response: SuperHeroDataResponse? = myResponse.body()

                if(response != null){
                    Log.i("Couroutine", response.toString())

                    runOnUiThread{ //corre en hilo principal
                        adapter.updateList(response.superHeroes)
                        binding.progressBar.isVisible = false
                    }
                }

            } else {
                Log.i("Couroutine", "no funciona")
            }
        }
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") //url para acceder a la api
            .addConverterFactory(GsonConverterFactory.create()) //convertir
            .build()

    }

    private fun navigateToDetail(id: String){

        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)

    }
}
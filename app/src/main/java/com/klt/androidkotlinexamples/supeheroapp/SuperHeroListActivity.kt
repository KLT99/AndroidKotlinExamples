package com.klt.androidkotlinexamples.supeheroapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.klt.androidkotlinexamples.databinding.ActivitySuperHeroListBinding
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

    }

    //muestra
    private fun searchByName(query: String) {

        //Corrutinas Hilo Secundario //IO para procesos muy largos
        CoroutineScope(Dispatchers.IO).launch { 
            val myResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful){
                val response: SuperHeroDataResponse? = myResponse.body()

                if(response != null){

                    Log.i("Couroutine", response.toString())
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
}
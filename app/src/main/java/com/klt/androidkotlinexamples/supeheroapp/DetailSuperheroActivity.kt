package com.klt.androidkotlinexamples.supeheroapp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.klt.androidkotlinexamples.R
import com.klt.androidkotlinexamples.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()

        getSuperheroInformation(id)

    }

    private fun getSuperheroInformation(id: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            if (superheroDetail.body() != null) {

                runOnUiThread { createUI(superheroDetail.body()!!) }
            }
        }
    }

    private fun createUI(superheroBody: SuperheroDetailResponse) {

        Picasso.get().load(superheroBody.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superheroBody.name
        binding.tvSuperheroRealName.text = superheroBody.biography.fullName
        binding.tvPublisher.text = "PUBLISHER: "+superheroBody.biography.publisher
        prepareStats(superheroBody.powerstats)
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {

        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewPower, powerstats.power)
    }

    private fun updateHeight(view: View, stat: String) {

        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params

    }

    private fun pxToDp(px: Float):Int {

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") //url para acceder a la api
            .addConverterFactory(GsonConverterFactory.create()) //convertir
            .build()

    }

}
package com.klt.androidkotlinexamples.imcCalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.klt.androidkotlinexamples.R
import com.klt.androidkotlinexamples.imcCalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescription: TextView

    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponent()
        initUI(result)
        initListener()
    }

    private fun initListener() {
        btnRecalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()

        when (result) {

            in 0.00..18.50 -> { //Peso bajo
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }

            in 18.51..24.99 -> { //Peso Normal
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }

            in 25.00..29.99 -> { //Sobrepeso
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }

            in 30.00..100.00 -> { //Obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }

            else -> { //error
                tvImc.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_obesidad))
            }

        }

    }

    private fun initComponent() {

        tvResult = findViewById(R.id.tvResult)
        tvImc = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnReCalculate)
    }
}
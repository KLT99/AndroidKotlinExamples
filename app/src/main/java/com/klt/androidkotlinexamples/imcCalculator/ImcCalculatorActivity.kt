package com.klt.androidkotlinexamples.imcCalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.klt.androidkotlinexamples.R
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight: Int = 60
    private var currentAge:Int = 18
    private var currentHeight:Int = 120

    private lateinit var tvHeight:TextView
    private lateinit var tvWeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton

    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton

    //CONSTANTE VARIABLE QUE SE PUEDE ACCEDER DESDE CUALQUIER CLASE
    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponent()
        initListener()
        initUI()
    }

    private fun initComponent() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlustWeight)
        tvAge = findViewById(R.id.tvAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusttAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListener() {

        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val decimalFormat = DecimalFormat("#.##")
            currentHeight = decimalFormat.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnPlusAge.setOnClickListener {
            currentAge+=1
            setAge()
        }

        btnSubtractAge.setOnClickListener {
            currentAge-= 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
            //Toast.makeText(this, "btn calcular", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToResult(result: Double) {

        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)

    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        //Toast.makeText(this, "calculateIMC: $imc", Toast.LENGTH_SHORT).show()
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }


    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender(){

        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }

    private fun getBackgroundColor(isSelectedComponent:Boolean): Int {

        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

}
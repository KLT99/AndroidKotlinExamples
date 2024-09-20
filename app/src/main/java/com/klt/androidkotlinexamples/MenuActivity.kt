package com.klt.androidkotlinexamples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.klt.androidkotlinexamples.firstapp.FirstAppActivity
import com.klt.androidkotlinexamples.imcCalculator.ImcCalculatorActivity
import com.klt.androidkotlinexamples.settings.SettingsActivity
import com.klt.androidkotlinexamples.supeheroapp.SuperHeroListActivity
import com.klt.androidkotlinexamples.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaluda = findViewById<Button>(R.id.btnSaluda)
        val btnImc = findViewById<Button>(R.id.btnIMC)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperhero = findViewById<Button>(R.id.btnSuperHero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)

        btnSaluda.setOnClickListener { navigateToSaluda() }
        btnImc.setOnClickListener { navigateToImcApp() }
        btnTODO.setOnClickListener { navigateToTodoApp() }
        btnSuperhero.setOnClickListener { navigareSuperHero() }
        btnSettings.setOnClickListener { navigateToSettings() }
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaluda(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigareSuperHero() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

}
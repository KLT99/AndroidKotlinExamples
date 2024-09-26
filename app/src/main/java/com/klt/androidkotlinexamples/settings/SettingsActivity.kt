package com.klt.androidkotlinexamples.settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.klt.androidkotlinexamples.R
import com.klt.androidkotlinexamples.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

//DataStore guarda cosas pequeñas. Room para consultas de sql

//Función de extension    by= legado
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private var firstTime: Boolean = true

    companion object{
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRATION = "key_vibration"
        const val KEY_DARK_MODE = "key_dark_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect{ settingsModel ->
                //datos SettingsModel()
                if (settingsModel!=null){
                    runOnUiThread {
                        binding.rsVolume.setValues(settingsModel.volume.toFloat())
                        binding.switchBluetooth.isChecked = settingsModel.bluetooth
                        binding.switchDarkMode.isChecked = settingsModel.darkMode
                        binding.switchVibration.isChecked = settingsModel.vibrator

                        firstTime = !firstTime
                    }
                }
            }
        }

        initUI()
    }

    private fun initUI() {
    
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            Log.i("rsVolume", "El valor es $value")
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        binding.switchBluetooth.setOnCheckedChangeListener { _, value ->

            CoroutineScope(Dispatchers.IO).launch {

                saveOptions(KEY_BLUETOOTH, value)
            }
        }

        binding.switchVibration.setOnCheckedChangeListener { _, value ->

            CoroutineScope(Dispatchers.IO).launch {

                saveOptions(KEY_VIBRATION, value)
            }
        }

        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->

            if (value){
                enableDarkMode()
            } else {
                disableDarkMode()
            }

            CoroutineScope(Dispatchers.IO).launch {

                saveOptions(KEY_DARK_MODE, value)
            }
        }
    }

    //DataStore
    private suspend fun saveVolume(value:Int){

        dataStore.edit {preferences ->
            preferences[intPreferencesKey(VOLUME_LVL)] = value
        }

    }

    private suspend fun saveOptions(key: String, value: Boolean){

        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }

    }

    //FLOW escucha continuamente un valor, cada vez que hay un cambio avisa sobre ello

    private fun getSettings(): Flow<SettingsModel?> {
        //dataStore solo devuelve el ultimo valor
        return dataStore.data.map { preferences->
            SettingsModel(
                volume = preferences[intPreferencesKey(VOLUME_LVL)] ?: 50,
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true,
                darkMode = preferences[booleanPreferencesKey(KEY_DARK_MODE)] ?: false,
                vibrator = preferences[booleanPreferencesKey(KEY_VIBRATION)] ?: true
            )
        }
    }

    private fun enableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}
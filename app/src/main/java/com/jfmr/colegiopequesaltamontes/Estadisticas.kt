package com.jfmr.colegiopequesaltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Estadisticas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        val campoTextoEstudiantes: TextView = findViewById(R.id.mensaje)
        var bundleData: Bundle? = this.intent.extras


        if (bundleData != null){
            campoTextoEstudiantes.text =  bundleData.getString("lista_estudiantes")
        }
    }
}
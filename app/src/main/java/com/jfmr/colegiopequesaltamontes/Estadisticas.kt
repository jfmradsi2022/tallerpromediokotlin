package com.jfmr.colegiopequesaltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Estadisticas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        val campoTextoEstudiantes: TextView = findViewById(R.id.mensaje)
        val campoTextoProcesados: TextView = findViewById(R.id.textPro)
        val campoTextoGanan: TextView = findViewById(R.id.textga)
        val campoTextoPierden: TextView = findViewById(R.id.textPier)
        val campoTextoRecuperan: TextView = findViewById(R.id.textRec)
        val bundleData: Bundle? = this.intent.extras


        if (bundleData != null){
            campoTextoEstudiantes.text =  bundleData.getString("lista_estudiantes")
            val procesados = bundleData.getIntArray("procesados")
            campoTextoProcesados.text = procesados?.get(0).toString()
            campoTextoGanan.text = procesados?.get(1).toString()
            campoTextoRecuperan.text = procesados?.get(2).toString()
            campoTextoPierden.text = procesados?.get(3).toString()
        }
    }
}

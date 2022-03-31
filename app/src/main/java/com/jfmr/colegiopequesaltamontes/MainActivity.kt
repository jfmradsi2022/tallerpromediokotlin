package com.jfmr.colegiopequesaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miBoton: Button = findViewById(R.id.btnRegistro)
        miBoton.setOnClickListener{onClick()}
    }

    private fun onClick() {

        //Creamos el intent el encargado de la comunicación entre activities
        val intent = Intent(this, Registro::class.java)
        //Creamos el bundle para el paso de información entre activities
        val miBundle: Bundle = Bundle()
        //miBundle.putString("Nombre", campoTexto!!.text.toString())
        //Le agregamos la información al intent para que sea enviada
        intent.putExtras(miBundle)
        //Iniciamos el llamado a la nueva actividad
        startActivity(intent)
    }
}
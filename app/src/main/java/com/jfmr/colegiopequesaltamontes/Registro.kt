package com.jfmr.colegiopequesaltamontes;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    //Se instancian los componentes
    var campoDocumento: EditText? = null
    var campoNombre: EditText? = null
    var campoEdad: EditText? = null
    var campoTelefono: EditText? = null
    var campoDireccion: EditText? = null

    var campoMateria1: EditText? = null
    var campoMateria2: EditText? = null
    var campoMateria3: EditText? = null
    var campoMateria4: EditText? = null
    var campoMateria5: EditText? = null
    var campoNota1: EditText? = null
    var campoNota2: EditText? = null
    var campoNota3: EditText? = null
    var campoNota4: EditText? = null
    var campoNota5: EditText? = null

    /*
     * Se declara la clase operaciones para la logica del sistema
     * esta instancia deberia estar en el activity principal
     * para poder ser enviada como parametro a esta clase, se pone
     * aquí como ejemplo.
     */
    var operaciones: Operaciones? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        //Se instancia la clase operaciones
        operaciones = Operaciones()

        campoDocumento = findViewById(R.id.campoDocumento)
        campoNombre = findViewById(R.id.campoNombre)
        campoEdad = findViewById(R.id.campoEdad)
        campoTelefono = findViewById(R.id.campoTelefono)
        campoDireccion = findViewById(R.id.campoDireccion)

        campoMateria1 = findViewById(R.id.campoMateria1)
        campoMateria2 = findViewById(R.id.campoMateria2)
        campoMateria3 = findViewById(R.id.campoMateria3)
        campoMateria4 = findViewById(R.id.campoMateria4)
        campoMateria5 = findViewById(R.id.campoMateria5)

        campoNota1 = findViewById(R.id.campoNota1)
        campoNota2 = findViewById(R.id.campoNota2)
        campoNota3 = findViewById(R.id.campoNota3)
        campoNota4 = findViewById(R.id.campoNota4)
        campoNota5 = findViewById(R.id.campoNota5)

        var btnRegistro: Button = findViewById(R.id.btnRegistrar)
        btnRegistro.setOnClickListener { registrarEstudiante() }

        var btnVerEstadisticas: Button = findViewById(R.id.btnVerEstadisticas)
        btnVerEstadisticas.setOnClickListener { cargarEstadisticas() }
    }

    private fun cargarEstadisticas() {
        var lista_estudiantes: ArrayList<Estudiante> = operaciones!!.devolverLista()
        var mensaje_estadisticas: String = formatearLista(lista_estudiantes)

        //Creamos el intent el encargado de la comunicación entre activities
        val intent = Intent(this, Estadisticas::class.java)
        //Creamos el bundle para el paso de información entre activities
        val miBundle: Bundle = Bundle()
        miBundle.putString("lista_estudiantes", mensaje_estadisticas)
        //Le agregamos la información al intent para que sea enviada
        intent.putExtras(miBundle)
        //Iniciamos el llamado a la nueva actividad
        startActivity(intent)
    }

    private fun formatearLista(listaEstudiantes: ArrayList<Estudiante>): String {
        var mensaje = ""

        for (estudiante in listaEstudiantes){
            mensaje += "Nombre: ${estudiante.nombre}\n"
            mensaje += "Materia1: ${estudiante.materia1}\n"
            mensaje += "Materia2: ${estudiante.materia2}\n"
            mensaje += "Materia3: ${estudiante.materia3}\n"
            mensaje += "Materia4: ${estudiante.materia4}\n"
            mensaje += "Materia5: ${estudiante.materia5}\n"
            mensaje += "nota1: ${estudiante.nota1}\n"
            mensaje += "nota2: ${estudiante.nota2}\n"
            mensaje += "nota3: ${estudiante.nota3}\n"
            mensaje += "nota4: ${estudiante.nota4}\n"
            mensaje += "nota5: ${estudiante.nota5}\n"
            mensaje += "Promedio: ${estudiante.promedio}\n"
        }
        return mensaje
    }

    private fun registrarEstudiante() {

        if (campoNota1?.text?.length == 0) {
            // La nota está vacía
            return
        }
        if (campoNota2?.text?.length == 0) {
            // La nota está vacía
            return
        }
        if (campoNota3?.text?.length == 0) {
            // La nota está vacía
            return
        }
        if (campoNota4?.text?.length == 0) {
            // La nota está vacía
            return
        }
        if (campoNota5?.text?.length == 0) {
            // La nota está vacía
            return
        }

        var nota1 = campoNota1?.text.toString().toDouble()
        var nota2 = campoNota2?.text.toString().toDouble()
        var nota3 = campoNota3?.text.toString().toDouble()
        var nota4 = campoNota4?.text.toString().toDouble()
        var nota5 = campoNota5?.text.toString().toDouble()
        var mensaje = ""
        var continuar = true

        if(nota1 < 0 || nota1 > 5){
            mensaje += "- Nota 1\n"
            continuar = false
        }
        if(nota2 < 0 || nota2 > 5){
            mensaje += "- Nota 2\n"
            continuar = false
        }
        if(nota3 < 0 || nota3 > 5){
            mensaje += "- Nota 3\n"
            continuar = false
        }
        if(nota4 < 0 || nota4 > 5){
            mensaje += "- Nota 4\n"
            continuar = false
        }
        if(nota5 < 0 || nota5 > 5){
            mensaje += "- Nota 5\n"
            continuar = false
        }

        if (continuar){
            //Se instancia la clase estudiante y se mapean los elementos del formulario
            var est: Estudiante = Estudiante()
            est.documento = campoDocumento?.text.toString()
            est.nombre = campoNombre?.text.toString()
            est.edad = campoEdad?.text.toString().toInt()
            est.direccion = campoDireccion?.text.toString()
            est.telefono = campoTelefono?.text.toString()

            //Si se va a trabajar con un mapa para la gestión de notas
            //est.mapaMaterias.put(
                //campoMateria1?.text.toString(),
                //Materia(campoMateria1?.text.toString(), campoNota1?.text.toString().toDouble())
           // )

            //Si se va a trabajar las materias y notas en la misma clase Estudiante
            est.materia1 = campoMateria1?.text.toString()
            est.materia2 = campoMateria2?.text.toString()
            est.materia3 = campoMateria3?.text.toString()
            est.materia4 = campoMateria4?.text.toString()
            est.materia5 = campoMateria5?.text.toString()


            est.nota1 = nota1
            est.nota2 = nota2
            est.nota3 = nota3
            est.nota4 = nota4
            est.nota5 = nota5

            //Se asigna el promedio delegando el calculo al metodo de la clase operaciones
            est.promedio = operaciones!!.calcularPromedio(est)
            est.mensaje = operaciones!!.resultadoAprobado(est)
            operaciones?.registrarEstudiante(est)
            operaciones?.imprimirListaEstudiantes()
        }
        else
        {
            Toast.makeText(this,"Los siguientes campos están incorrectos\n $mensaje ", Toast.LENGTH_LONG).show()
        }
    }
}

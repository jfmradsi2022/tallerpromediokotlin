package com.jfmr.colegiopequesaltamontes;

class Operaciones {

    var listaEstudiantes =arrayListOf<Estudiante>()
    var contGanan: Int = 0
    var contPierden: Int = 0
    var contRecuperan: Int = 0
    var contProcesados: Int = 0


    fun registrarEstudiante(estudiante: Estudiante){

        listaEstudiantes.add(estudiante)
    }

    fun imprimirListaEstudiantes(){
        for(est in listaEstudiantes){
            println(est)
        }
    }

    fun calcularPromedio(est: Estudiante): Double {

        var prom=(est.nota1+est.nota2+est.nota3+est.nota4+est.nota5)/5
        return prom
    }

    fun resultadoAprobado(est: Estudiante): String{
        var mensajeLocal = ""

        if (est.promedio in 2.5..3.5) {
            mensajeLocal = "Perdió pero puede recuperar"
            contRecuperan++
        } else if (est.promedio < 2.5) {
            mensajeLocal = "Perdió y no puede recuperar"
            contPierden++
        } else {
            mensajeLocal = "Ganó"
            contGanan++
        }
        contProcesados += 1
        return mensajeLocal
    }

    fun cantidadProcesados(): IntArray {
        return arrayOf(
            contProcesados, contGanan, contRecuperan, contPierden
        ).toIntArray()
    }

    fun devolverLista(): ArrayList<Estudiante>{
        return this.listaEstudiantes
    }
}

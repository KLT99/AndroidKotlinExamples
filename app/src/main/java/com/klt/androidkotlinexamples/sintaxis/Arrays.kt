package com.klt.androidkotlinexamples.sintaxis

fun main() {

    //indice 0-6
    //tamaño 7
    val weekDays = arrayOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")

    //tamaño del arreglo
    //println(weekDays.size)

    //tamaños
    if (weekDays.size >= 8){
        //println(weekDays[7])
    } else{
        //println("No hay mas valores en el array")
    }

    //modificar valores del array de acuerdo a la posicion que seleccione
    weekDays[0] = "Feliz Lunes"
    //println(weekDays[0])

    //Bucles para array
    for (position in weekDays.indices){

        //println("posición: $position")
        //println(weekDays[position])

    }
    //bucle da la posicion y el valor de un array
    for ((position, value ) in weekDays.withIndex()){

        //println("La posicion $position, contiene $value")
    }

    for (weekday in weekDays){
        println("Hoy es $weekday")
    }

}
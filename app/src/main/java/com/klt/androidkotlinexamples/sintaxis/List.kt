package com.klt.androidkotlinexamples.sintaxis

fun main() {

    mutableList()
}

fun mutableList(){
    val weekDays:MutableList<String> = mutableListOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
    //agrega a la lista en la posicion 0 el valor
    weekDays.add(0,"Kotlin")
    println(weekDays)

    //verifica si la lista esta vacia
    if (weekDays.isEmpty()){
        //Lista vacia
    } else{
        weekDays.forEach { println(it) }
    }

    if (weekDays.isNotEmpty()){
        weekDays.forEach { println(it) }
    }

    weekDays.last()

    for (item in weekDays){

    }
}

fun inmutableList(){

    val readOnly:List<String> = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")

    /*println(readOnly.size)
    println(readOnly)
    println(readOnly[0])*/

    //ultimo valor de la lista
    //println(readOnly.last())
    //primer valor de la lista
    //println(readOnly.first())

    //filtrar listas donde it.contains busca el dato donde contenga el valor en esa lista (it = iteraccion)
    /*val example = readOnly.filter { it.contains("a") }
    println(example)*/

    readOnly.forEach{
        weekDay -> println(weekDay)
    }

}
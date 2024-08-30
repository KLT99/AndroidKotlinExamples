package com.klt.androidkotlinexamples.sintaxis

fun mai(){
    var name: String? = "Megan"

    //el signo ? significa que si el valor de la varibale checa si no es nulo obtenga el valor que esta en la posicion 3
    //println(name?.get(3))

    //operador elvis (?:) indica que si la variable es nulo entonces imprima lo siguiente
    println(name?.get(3) ?: "Es nulo")
}


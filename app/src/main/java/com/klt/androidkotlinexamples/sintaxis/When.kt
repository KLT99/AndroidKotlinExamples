package com.klt.androidkotlinexamples.sintaxis

fun main(){

    println( getSemestre2(5))

}

//Any
fun result(value: Any){

    when(value){
        is Int -> print(value + value)
        is String -> println(value)
        is Boolean -> if (value) println("holiwi") else println(value)
    }

}

fun getSemestre(month: Int): String{
    /*
    val result = when(month){
       //rangos

    /*in 1 .. 6 -> println("primer semestre") //entre
        in 7 .. 12 -> println("segundo semestre")
        !in 1 .. 12 -> println("semestre no valido") */

        in 1 .. 6 -> "primer semestre"
        in 7 .. 12 -> "segundo semestre"
        !in 1 .. 12 -> "semestre no valido"
        else -> return "error"
    }
    return result
    */


    when(month){
        in 1 .. 6 -> return "primer semestre"
        in 7 .. 12 -> return "segundo semestre"
        !in 1 .. 12 -> return "semestre no valido"
        else -> return "error"
    }

/*
    return when(month){

        in 1 .. 6 -> "primer semestre"
        in 7 .. 12 -> "segundo semestre"
        !in 1 .. 12 -> "semestre no valido"
        else -> "error"
    }
    */

}

fun getSemestre2(month: Int) = when(month){

        in 1 .. 6 -> "primer semestre"
        in 7 .. 12 -> "segundo semestre"
        !in 1 .. 12 -> "semestre no valido"
        else -> "error"
    }

fun getTrimestre(month: Int){

    when(month){
        1,2,3 -> println("primer trimestre")
        4,5,6 -> println("segundo trimestre")
        7,8,9 -> println("tercer trimestre")
        10,11,12 -> println("cuarto trimestre")
        else -> println("trimestre no valido")
    }

}

fun getMonth(month:Int){

    when(month){
        1 -> println("enero")
        2 -> println("febrero")
        3 -> println("marzo")
        4 -> println("abril")
        5 -> println("mayo")
        6 -> println("junio")
        7 -> println("julio")
        8 -> println("agosto")
        9 -> println("septiembre")
        10 -> {
            println("octubre")
            println("mes correcto")
        }
        11 -> println("noviembre")
        12 -> println("diciembre")

        else -> println("no es un mes válido")

    }

}
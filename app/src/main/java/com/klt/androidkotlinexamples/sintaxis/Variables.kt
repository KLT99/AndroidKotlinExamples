package com.klt.androidkotlinexamples.sintaxis

fun main() {

    showMyName()
}

fun showMyName(){

    println("Me llamo Karla")
    val mysubtract = subtract2(20,5)
    println(mysubtract)
}

//funcion devuelve un valor de tipo int
fun subtract(firstNumbre:Int, secondNumbre:Int):Int{
    return firstNumbre-secondNumbre
}
//funcion resumida de la funcion subtract, devuelve un int
fun subtract2(firstNumbre:Int, secondNumbre:Int):Int = firstNumbre-secondNumbre


fun variablesAlfanumericas(){

    //Variables Alfanuméricas

    //Char solo soporta 1 caracter
    val charExample1: Char = 'e'
    val charExample2: Char = '2'
    val charExample3: Char = '@'

    //String
    val stringExample: String = "Karla"

    var stringConcatenada:String = "hola"
    stringConcatenada = "Hola me llamo $stringExample y tengo  años"

    println(stringConcatenada)

}

fun variablesBooleanas(){

    //Variables Booleans

    //Boolean
    val booleanExample: Boolean = true
    val booleanExample2: Boolean = false

    //print(stringExample)

    //valor(val) es una constante y var una variable(var)

}

fun variablesNunericas(){


    //Variables Númericas

    //Integer soporta desde -2,147,483,647 a 2,147,483,647
    val age: Int = 30
    var age2:Int = 30

    age2 = 29

    //Long -9,223,372,036,854,775,807 a 9,223,372,036,854,775,807
    val example: Long = 30
    var example2: Long = 3092233781 //(10 digitos)


    //Float 6 decimales
    val floatExample: Float = 30.5f

    //Double 12 decimales
    val doubleExample: Double = 3241.3123123

}
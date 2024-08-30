package com.klt.androidkotlinexamples.sintaxis

fun main(){
    ifBoolean()
}

fun ifBasico(){

    val name = "Aris"

    if (name.equals("Aris")){
        println("la variable name es Aris")
    }

}

fun ifBoolean(){
    val variable1:Boolean = true

    if (variable1){
        println("variable es true")
    }
}

fun ifInt(){

    val age = 18

    if (age>=18){

        println("puedes beber cerveza")
    } else {
        println("no puedes beber cerveza")
    }

}
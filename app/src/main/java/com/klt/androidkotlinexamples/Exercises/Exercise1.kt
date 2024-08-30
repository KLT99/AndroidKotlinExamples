package com.klt.androidkotlinexamples.Exercises

/*CODELAB PRÁCTICA CONCEPTOPS BÁSISCOS KOTLIN
*
* Por lo general, el teléfono te proporciona un resumen de las notificaciones.

  En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste. El mensaje debe incluir lo siguiente:

  La cantidad exacta de notificaciones cuando haya menos de 100
  99+ como cantidad de notificaciones cuando haya 100 o más
*
* RESULTADO
*
* You have 51 notifications.
* Your phone is blowing up! You have 99+ notifications.
*
* URL: https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?hl=es-419#1
* */

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    //printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    // Fill in the code.

    if (numberOfMessages == 51){
        print("You have 51 notifications")
    } else if (numberOfMessages > 99){
        print("Your phone is blowing up! You have 99+ notifications")
    } else {
        print("You have $numberOfMessages notifications")
    }

}
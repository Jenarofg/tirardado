package com.jenaro.pmdm.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class  MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btntirar: Button = findViewById(R.id.btn_tirar)
        btntirar.setOnClickListener {
            tirarDado()
        }
        /**
         * Llamamos al método tirarDado para inicializarlo y que
         * no salga la pantalla en blanco en el arranque.
         */

        tirarDado()
    }

    /**
     * Tira el dado y actualiza la imagen con el resultado
     */
    private fun tirarDado() {
        //Crea un dado con 6 caras y tira el dadod
        val dado= Dado(6)
        val valorDado= dado.tirar()
        //Busca la ImageView correspondiente.
        val diceImage: ImageView = findViewById(R.id.imgDado)
        //Determina que imagen usar en funcion del resultado obtenido en valorDado
       val drawableResource = when (valorDado) {
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
           else -> R.drawable.dice_6
        }
        //Actualiza le ImageView con su imagen correspondiente
        diceImage.setImageResource(drawableResource)
        //Actualiza el contenido de la Descripcion con el valor numerico correspondiente
        diceImage.contentDescription = diceImage.toString()

        //txtDado.text= valorDado.toString()
    }
}

class Dado(val numCaras:Int){
    /**
     * Creamos la clase Dado , donde tenemos un método
     * tirar(), que devolcerá un número aleatorio de 1 a numCaras.
     */
    fun tirar():Int{
        return (1..numCaras ).random()
    }
}

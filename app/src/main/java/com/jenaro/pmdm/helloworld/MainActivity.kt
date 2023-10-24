package com.jenaro.pmdm.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class  MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btntirar: Button = findViewById(R.id.btn_tirar)
        btntirar.setOnClickListener {
            tirarDado()
        }
    }

    private fun tirarDado() {
        val txtDado = findViewById<TextView>(R.id.txt_dado)
        val dado= Dado(6)
        val valorDado= dado.tirar()
        txtDado.text= valorDado.toString()
    }
}

class Dado(val numCaras:Int){
    fun tirar():Int{
        return (1..numCaras ).random()
    }
}

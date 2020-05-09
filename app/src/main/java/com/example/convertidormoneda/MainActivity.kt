package com.example.convertidormoneda

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(){
    private var dePesoADolar = true
    var mensaje = ""
    var divisor= 0f
    var convertido = 0f
    var aConvertir = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cambiarDivisaAConvertir.setOnClickListener { cambiarDivisa() }
        esBlue.setOnCheckedChangeListener { esBlue, isChecked -> cambiarImagen(imagenSignosMonedas) }
        convertir.setOnClickListener { convertir() }
    }


    fun cambiarImagen(view: View) {
        if (esBlue.isChecked && dePesoADolar) {
            imagenSignosMonedas.setImageResource(R.drawable.pesoblue)
            divisor= 122f
            mensaje = "$aConvertir $ ARG  son $convertido $ USD BLUE"

        } else if (esBlue.isChecked && !dePesoADolar) {
            imagenSignosMonedas.setImageResource(R.drawable.bluepeso)
            divisor= 122f
            mensaje = "$aConvertir $ USD BLUE son $convertido $ ARG"

        } else if (!esBlue.isChecked && dePesoADolar) {
            imagenSignosMonedas.setImageResource(R.drawable.pesodolar)
            divisor= 67.18f
            mensaje = "$aConvertir $ USD  son $convertido $ ARG"

        } else if (!esBlue.isChecked && !dePesoADolar) {
            imagenSignosMonedas.setImageResource(R.drawable.dolarpeso)
            divisor= 67.18f
            mensaje = "$aConvertir $ ARG  son $convertido $ USD"

        }
    }

    fun cambiarDivisa() {
        if (dePesoADolar) {
            dePesoADolar = false
            cambiarImagen(imagenSignosMonedas)
        } else if (!dePesoADolar) {
            dePesoADolar = true
            cambiarImagen(imagenSignosMonedas)
        }
    }


    fun convertir() {
        aConvertir = montoAIngresar.text.toString().toFloat()
        if(dePesoADolar)convertido = (aConvertir / divisor).toFloat()
        else convertido = (aConvertir * divisor).toFloat()
        cambiarImagen(imagenSignosMonedas)
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG)
            .show()

    }


}






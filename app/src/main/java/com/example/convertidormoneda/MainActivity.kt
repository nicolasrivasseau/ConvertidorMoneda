package com.example.convertidormoneda

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var dePesoADolar = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            fun cambiarImagen(view: View) {
                if (esBlue.isChecked && dePesoADolar) {
                    imagenSignosMonedas.setImageResource(R.drawable.pesoblue)

                } else if (esBlue.isChecked && !dePesoADolar) {
                    imagenSignosMonedas.setImageResource(R.drawable.bluepeso)

                } else if (!esBlue.isChecked && dePesoADolar) {
                    imagenSignosMonedas.setImageResource(R.drawable.pesodolar)

                } else if (!esBlue.isChecked && !dePesoADolar) {
                    imagenSignosMonedas.setImageResource(R.drawable.dolarpeso)

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

       fun getPosts() {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.dolarsi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
           var dolarSi = retrofit.create(DolarSi::class.java)

           val repos: Call<List<= service.listRepos("octocat")
       }

        
        cambiarDivisaAConvertir.setOnClickListener {cambiarDivisa()}
        esBlue.setOnCheckedChangeListener { esBlue, isChecked -> cambiarImagen(imagenSignosMonedas) }

        fun convertir() {
                var aConvertir = montoAIngresar.text.toString().toFloat()
                var mensaje = ""
                var convertido = 0f
                esBlue.isChecked
                if (esBlue.isChecked && dePesoADolar) {
                    convertido = (aConvertir / 122).toFloat()
                    mensaje = "$aConvertir $ ARG  son $convertido $ USD BLUE"

                } else if (esBlue.isChecked && !dePesoADolar) {
                    convertido = (aConvertir * 122).toFloat()
                    mensaje = "$aConvertir $ USD BLUE son $convertido $ ARG"

                } else if (!esBlue.isChecked && dePesoADolar) {
                    convertido = (aConvertir / 67.18).toFloat()
                    mensaje = "$aConvertir $ ARG  son $convertido $ USD"

                } else {
                    convertido = (aConvertir * 67.18).toFloat()
                    mensaje = "$aConvertir $ USD  son $convertido $ ARG"
                }

                Toast.makeText(this, mensaje, Toast.LENGTH_LONG)
                    .show()

            }

        convertir.setOnClickListener { convertir() }




        }
}
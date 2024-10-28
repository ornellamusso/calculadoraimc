package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {


    lateinit var heightEdiText:EditText
    lateinit var weightEdiText:EditText
    lateinit var calculateButton: Button
    lateinit var resultTextView:TextView
    lateinit var descriptionTextView:TextView
    lateinit var resultImageView:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightEdiText=findViewById(R.id.heightEdictText)
        weightEdiText=findViewById(R.id.weightEdictText)
        calculateButton=findViewById(R.id.calculateButton)
        resultTextView=findViewById(R.id.resultTextView)
        descriptionTextView=findViewById(R.id.descriptionTextView)
        resultImageView=findViewById(R.id.resultImageView)

        calculateButton.setOnClickListener{
            Log.i("MainActivity", "He pulsado el boton calcular")
            val height = heightEdiText.text.toString().toFloat()
            val weight = weightEdiText.text.toString().toFloat()
            val result = weight / (height / 100).pow(2)
            //if (height) esto es para resolver cuando se pone 0
            resultTextView.text = String.format(Locale.getDefault(), "%.2f", result)

            when (result) {
                in 0.00..<18.50 -> { // Bajo peso
                    setTextAndColorAndImage(R.string.underWeight, R.color.underWeight, R.drawable.weight_bajopeso)
                }
                in 18.50..<25.00 -> {// Peso normal
                    setTextAndColorAndImage(R.string.normalWeight, R.color.normal, R.drawable.weight_normal)
                }
                in 25.00..<30.00 -> {// Sobrepeso
                    setTextAndColorAndImage(R.string.overWeight, R.color.overWeight, R.drawable.weight_sobrepeso)
                }
                in 30.00..<35.00 -> {// Obesidad
                    setTextAndColorAndImage(R.string.obesity, R.color.obesse, R.drawable.weight_obesity)
                }
                else -> {// Obesidad extrema
                    setTextAndColorAndImage(R.string.obesityExtreme, R.color.morbityObesse, R.drawable.weight_obesity_extreme)
                }
            }

        }

    }

    fun setTextAndColorAndImage(textRes: Int, colorRes: Int, imageRes: Int) {
        val color = getColor(colorRes)
        descriptionTextView.text = getString(textRes)
        descriptionTextView.setTextColor(color)
        resultTextView.setTextColor(color)
        resultImageView.setImageDrawable(getDrawable(imageRes))
        resultImageView.setColorFilter(color)
    }

}

fun scaleImage
resultImageView.scaleX = 0.0f
resultImageView.scaleY = 0.0f
val scaleUpX = ObjectAnimator.ofFloat(resultImageView, "scaleX", 1f)
val scaleUpY = ObjectAnimator.ofFloat(resultImageView, "scaleY", 1f)
scaleUpX.setDuration(500)
scaleUpY.setDuration(500)

val scaleUp = AnimatorSet()
scaleUp.play(scaleUpX).with(scaleUpY)

scaleUp.start()
}


/*fun calculateState(result: Float): {
    var pesoPorDebajo;TextView
    var pesoSaludable;TextView
    var pesoSobrepeso;TextView
    var pesoObesidadI;TextView
    var pesoObesidadIi;TextView
    var pesoObesidadIii;TextView

    pesoPorDebajo = findViewbyId(R.id.pesoPorDebajo)
    pesoSaludable = findViewbyId(R.id.pesoSaludable)
    pesoSobrepeso = findViewbyId(R.id.pesoSobrepeso)
    pesoObesidadI = findViewbyId(R.id.pesoObesidadI)
    pesoObesidadIi = findViewbyId(R.id.pesoObesidadIi)
    pesoObesidadIii = findViewbyId(R.id.pesoObesidadIii)

    Log.i("IMC","valor de result $result")

    val result = weight /height/ 100.pow(2))
    resultTextView.text = String.format(Locale.getDefault(),"%.2f", result)

    when (result){
        in 1.00<..<18.00 -> {// Bajo peso
            val color = getColor(R.color.underWeight)
            descriptionTextView.text = getString(underWeight)
            descriptionTextView.setTextColor(color)
            resultTextView.setTextColor(color)

        }in 18.50<..<24.90 -> {// Peso normal

        }in 25.00<..<29.90 -> {// Sobrepeso

        }in 30.00<..<34.90 -> {// Obesidad

        }in 35.00<..<35.90 -> {// Obesidad extrema

        }

        else ->
            Log.i(tag: "IMC", "El dato introducido es incorrecto")
    }






}*/
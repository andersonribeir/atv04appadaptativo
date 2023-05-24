package com.example.alcoolougasolina

import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val txtGaso : EditText =  findViewById(R.id.edGasolina)
        val txtAlc : EditText = findViewById(R.id.edAlcool)

        btCalc.setOnClickListener(View.OnClickListener {
            if(txtAlc.text.toString() == "" || txtGaso.text.toString() == ""){

            }else{
                val swImposto : Switch = findViewById(R.id.swPercentual)
                percentual = if(swImposto.isChecked){ 0.75  }else { 0.70 }

                var txtResultado : TextView = findViewById(R.id.txtResultado)
                var txtTitulo : TextView = findViewById(R.id.titulo)
                if (txtAlc.text.toString().toDouble() <=  txtGaso.text.toString().toDouble()*percentual){
                    txtResultado.text = "Escolha Alcool."
                    txtResultado.setTextColor(Color.BLACK)
                    txtTitulo.setTextColor(Color.BLACK)
                }else {txtResultado.text = "Escolha Gasolina."
                    txtResultado.setTextColor(Color.BLACK)
                    txtTitulo.setTextColor(Color.BLACK)
                }
            }


        })
    }

override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
    private fun isDarkTheme(): Boolean {
        val nightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return nightMode == Configuration.UI_MODE_NIGHT_YES
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        recreate()
    }

override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onDestroy")
}
}
package com.uttab.halcondeoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.agregar_activity.*


class AgregarActivity : AppCompatActivity() {

    val productoadmin = AdminProducto()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_activity)
        guardaProducto_click()
        val spinner = findViewById<Spinner>(R.id.txsp01)
        val lista = listOf("Accesorios", "Amplificadores", "Antena", "Radio")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@AgregarActivity,lista[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
        fun guardaProducto_click(){
            btnguardar.setOnClickListener {
                val producto = Producto(0, txnombre.text.toString(), txprecio.text.toString(), txcantidad.text.toString(), txsp01.toString())
                productoadmin.addProducto(producto)
                finish()
            }
        }
}
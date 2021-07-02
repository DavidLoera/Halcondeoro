package com.uttab.halcondeoro

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.agregar_activity.*

import kotlinx.android.synthetic.main.radios_activity.*

class RadiosActivity : AppCompatActivity() {

    val productoaAdmin = AdminProducto()
    lateinit var nombres : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radios_activity)
        eliminar()
    }

    override fun onResume() {
        super.onResume()
        crearLista()
    }

        fun crearLista(){
            nombres = productoaAdmin.getAll()!!

            val adaptador = ArrayAdapter(AppHalcon.CONTEXT, android.R.layout.simple_list_item_1,nombres!!)
            listradios.adapter = adaptador

            //Al seleccionar un elemento
            
            listradios.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val item = nombres!!.get(i)
                Toast.makeText(AppHalcon.CONTEXT, item, Toast.LENGTH_SHORT).show()
            }
        }

        fun eliminar(){
            listradios.onItemLongClickListener = AdapterView.OnItemLongClickListener { adapterView, view, i, l ->

                val nombre = nombres.get(i)
                val Dialog = AlertDialog.Builder(this)
                Dialog.setTitle("Eliminar Producto")
                Dialog.setMessage("Confirme si desea eliminar este producto")
                Dialog.setPositiveButton("Si"){ dialogInterface, i ->
                    productoaAdmin.deleteProducto(nombre)
                    crearLista()
                }
                Dialog.setNegativeButton("No"){dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                Dialog.show()
                true
            }
        }
    }

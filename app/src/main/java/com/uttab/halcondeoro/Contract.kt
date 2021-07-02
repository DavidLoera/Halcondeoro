package com.uttab.halcondeoro

import android.provider.BaseColumns

class Contract {

    //Define los campos de la tabla
    class Productos : BaseColumns{
        companion object{
            val ID = "id"
            val nombre = "nombre"
            val precio = "precio"
            val cantidad = "cantidad"
            val tipo = "tipo"
        }
    }
}
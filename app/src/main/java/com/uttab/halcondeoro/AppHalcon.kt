package com.uttab.halcondeoro

import android.app.Application
import android.content.Context

class AppHalcon : Application() {

    companion object{
        lateinit var CONTEXT : Context
        lateinit var DB : InitDB
        val DB_NAME = "Productos.db"
        val VERSION = 1
        val TB_PRODUCTOS = "tbProductos" //Nombre de la tabla
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        DB = InitDB()
    }
}
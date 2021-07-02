package com.uttab.halcondeoro

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDB:SQLiteOpenHelper(AppHalcon.CONTEXT, AppHalcon.DB_NAME, null, AppHalcon.VERSION) {

    val qryCreateTabla = "CREATE TABLE ${AppHalcon.TB_PRODUCTOS}(" +
            "${Contract.Productos.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "${Contract.Productos.nombre} TEXT NOT NULL, " +
            "${Contract.Productos.precio} TEXT NOT NULL," +
            "${Contract.Productos.cantidad} TEXT NOT NULL," +
            "${Contract.Productos.tipo} TEXT NOT NULL);"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreateTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
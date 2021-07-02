package com.uttab.halcondeoro

import android.database.DatabaseUtils
import android.widget.Toast
import java.lang.Exception

data class Producto(var id:Int, var nombre:String, var cantidad:String, var precio: String, var tipo: String)

class AdminProducto {

    //Query nombre productos
    fun getAll():ArrayList<String>? {
        try{
            //Respuesta
            val nombres = arrayListOf<String>()
            val  db = AppHalcon.DB.readableDatabase
            //Checar datos
            val numDatos = DatabaseUtils.queryNumEntries(db,AppHalcon.TB_PRODUCTOS).toInt()
            if (numDatos > 0){
                val qry = "Select ${Contract.Productos.nombre} FROM ${AppHalcon.TB_PRODUCTOS}"
                val c = db.rawQuery(qry, null)
                //Nos ponemos al inicio
                c.moveToFirst()
                do{
                    //LLenamos el arreglo
                    nombres.add(c.getString(c.getColumnIndex(Contract.Productos.nombre)))

                }while (c.moveToNext())
            }else{
                Toast.makeText(AppHalcon.CONTEXT, "No hay productos", Toast.LENGTH_SHORT).show()
            }
            db.close()
            return nombres

        }catch (ex:Exception){
            Toast.makeText(AppHalcon.CONTEXT, "No se pudo recuperar la lista de productos", Toast.LENGTH_SHORT).show()
            return null
        }
    }
    //Query Insertar productos
    fun addProducto(producto: Producto){
        try {
            val db = AppHalcon.DB.writableDatabase
            var qry = "INSERT INTO ${AppHalcon.TB_PRODUCTOS} (" +
                      "${Contract.Productos.nombre}, ${Contract.Productos.precio},"+
                      "${Contract.Productos.cantidad},${Contract.Productos.tipo})"+
                      "VALUES('${producto.nombre}','${producto.precio}','${producto.cantidad}','${producto.tipo}');"
            db.execSQL(qry)
            db.close()
        }catch (ex:Exception){
            Toast.makeText(AppHalcon.CONTEXT, "No se pudo guardar el producto", Toast.LENGTH_SHORT).show()
        }
    }



    fun deleteProducto(nombre: String){
        try {
            val db = AppHalcon.DB.writableDatabase
            var qry = "DELETE FROM ${AppHalcon.TB_PRODUCTOS} WHERE ${Contract.Productos.nombre} = '$nombre';"
            db.execSQL(qry)
            db.close()
        }catch (ex:Exception){
            Toast.makeText(AppHalcon.CONTEXT, "No se pudo eliminar el producto", Toast.LENGTH_SHORT).show()
        }
    }
}
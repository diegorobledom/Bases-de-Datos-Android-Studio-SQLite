package com.example.basededatos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper
{
    Context context;

    public DbContactos(@Nullable Context context)
    {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String nombre, String telefono, String correo)
    {
        long id = 0;

        try
        {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("telefono", telefono);
            valores.put("correo", correo);

            id = db.insert(TABLE_CONTACTOS, null, valores);
        } catch (Exception ex)
        {
            Toast.makeText(context.getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        
        return id;
    }
}

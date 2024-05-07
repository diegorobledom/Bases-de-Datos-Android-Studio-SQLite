package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.basededatos.adaptadores.ListaContactosAdapter;
import com.example.basededatos.db.DbContactos;
import com.example.basededatos.entidades.Contactos;
import java.util.ArrayList;

public class MostrarRegistros extends AppCompatActivity
{
    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;
    ListaContactosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_registros);

        listaContactos = findViewById(R.id.listaContactos);

        DbContactos dbContactos = new DbContactos(MostrarRegistros.this);

        listaArrayContactos = new ArrayList<>();

        adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));
    }
}
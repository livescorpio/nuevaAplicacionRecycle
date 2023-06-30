package com.example.nuevaaplicacionrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nuevaaplicacionrecycle.adapters.AdapterNoticias;
import com.example.nuevaaplicacionrecycle.interfaces.iListAlumnos;
import com.example.nuevaaplicacionrecycle.modelos.Noticias;

public class MainActivity2ListViewPersonalizado extends AppCompatActivity {

    public Noticias[] noticias;
    private ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_list_view_personalizado);
        lstOpciones = findViewById(R.id.lstnoticiaspepa);
        data();
    }

    public void data()
    {
         noticias =
                new Noticias[]{
                        new Noticias("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                        new Noticias("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                        new Noticias("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                        new Noticias("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")};

        //adaptador
        AdapterNoticias adaptadornoticias = new AdapterNoticias(this, noticias);

        //vista
        lstOpciones.setAdapter(adaptadornoticias);

        View header =
                getLayoutInflater().inflate(
                        R.layout.activity_lyheader
                        , null);
        lstOpciones.addHeaderView(header);
        //lstOpciones.setOnItemClickListener(new iListAlumnos(this.getApplicationContext()));
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity2ListViewPersonalizado.this,MainActivity2ResultadosNoticias.class);
                Bundle b = new Bundle();
                Noticias not=(Noticias) adapterView.getAdapter().getItem(i);
                b.putSerializable("claseNoticia",not);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

}
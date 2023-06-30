package com.example.nuevaaplicacionrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nuevaaplicacionrecycle.modelos.Noticias;

public class MainActivity2ResultadosNoticias extends AppCompatActivity {

    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_resultados_noticias);
        b=this.getIntent().getExtras();
        llenardata();
    }

    private void llenardata()
    {
        Noticias not=(Noticias) b.getSerializable("claseNoticia");
        TextView txt1=findViewById(R.id.txt1);
        TextView txt2=findViewById(R.id.txt2);
        txt1.setText(not.getTitulo());
        txt2.setText(not.getSubtitulo());
    }

}
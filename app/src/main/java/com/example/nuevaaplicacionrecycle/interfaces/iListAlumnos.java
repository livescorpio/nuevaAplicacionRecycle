package com.example.nuevaaplicacionrecycle.interfaces;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nuevaaplicacionrecycle.R;
import com.example.nuevaaplicacionrecycle.modelos.Noticias;

public class iListAlumnos implements AdapterView.OnItemClickListener{

    Context context;

    public iListAlumnos(Context context)
    {
        this.context=context;
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("getkey","alumno"+adapterView.getAdapter().getItem(i));

        Toast.makeText(context,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG)
                .show();
            Noticias not=(Noticias) adapterView.getAdapter().getItem(i);
            Log.i("holakey",not.getTitulo());
            Log.i("holakey",not.getSubtitulo());


        }

}
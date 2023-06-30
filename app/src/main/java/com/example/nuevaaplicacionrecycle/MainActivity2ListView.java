package com.example.nuevaaplicacionrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nuevaaplicacionrecycle.interfaces.iListAlumnos;

public class MainActivity2ListView extends AppCompatActivity {

    ListView lstList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_list_view);
        lstList=findViewById(R.id.lstlista);
        llenarData();
    }

    private void llenarData()
    {
        final String[] datos = new
                String[]{"Jhon leturne","piña","Hector","ochy","orlando"};

        //adapter
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        datos);
        //vista
        lstList.setAdapter(adaptador2);

        //evento item selected

        /*lstList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("laclave",adapterView.getAdapter().getItem(i).toString());
            }
        });*/

        lstList.setOnItemClickListener(new iListAlumnos(this.getApplicationContext()));
    }





}
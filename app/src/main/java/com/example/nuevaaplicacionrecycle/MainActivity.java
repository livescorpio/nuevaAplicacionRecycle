package com.example.nuevaaplicacionrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener{

    TextView txtItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtItem=findViewById(R.id.itemText);
        llenardata();
    }

    //llenar spinner
    @Deprecated
    private void llenardata(){
        final String[] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);
        Spinner spinner=findViewById(R.id.opciones);
        adaptador.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        txtItem.setText("Ha seleccionado "+adapterView.getItemAtPosition(i).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        txtItem.setText("");
    }

    //llenar list view





}
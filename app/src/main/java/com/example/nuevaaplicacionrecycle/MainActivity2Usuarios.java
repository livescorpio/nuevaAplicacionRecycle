package com.example.nuevaaplicacionrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.nuevaaplicacionrecycle.adapters.AdapterUsuarios;
import com.example.nuevaaplicacionrecycle.httpRequest.Asynchtask;
import com.example.nuevaaplicacionrecycle.httpRequest.WebService;
import com.example.nuevaaplicacionrecycle.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2Usuarios extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_usuarios);
        lstOpciones = (ListView)findViewById(R.id.lstDataUsu);
        View header=getLayoutInflater().inflate(R.layout.activity_lyheader,null);
        lstOpciones.addHeaderView(header);
        cargardata();
    }


    private void cargardata()
    {

        View header = getLayoutInflater().inflate(R.layout.lyitemusuario, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity2Usuarios.this, MainActivity2Usuarios.this);
        ws.execute("GET");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        ArrayList<Usuario> lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdapterUsuarios adapatorUsuario = new AdapterUsuarios(this, lstUsuarios);
        lstOpciones.setAdapter(adapatorUsuario);
    }
}
package com.example.nuevaaplicacionrecycle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.nuevaaplicacionrecycle.R;
import com.example.nuevaaplicacionrecycle.modelos.Noticias;
import com.example.nuevaaplicacionrecycle.modelos.Usuario;

import java.util.ArrayList;

public class AdapterUsuarios extends ArrayAdapter<Usuario> {


    public AdapterUsuarios(@NonNull Context context, ArrayList datos) {
        super(context, R.layout.lyitemusuario,datos);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemusuario, null);
        TextView lblNombres = (TextView)item.findViewById(R.id.lblNombre);
        lblNombres.setText(getItem(position).getNombres());
        TextView lblEmail = (TextView)item.findViewById(R.id.lblEmail);
        lblEmail.setText(getItem(position).getEmail());
        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);
        lblweb.setText(getItem(position).getWebsite());

        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imageView);

        return(item);
    }


}

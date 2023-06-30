package com.example.nuevaaplicacionrecycle.modelos;

import java.io.Serializable;

public class Noticias implements Serializable {
    private String titulo;
    private String subtitulo;
    public Noticias(String tit, String
            sub){
        titulo = tit;
        subtitulo = sub;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
}
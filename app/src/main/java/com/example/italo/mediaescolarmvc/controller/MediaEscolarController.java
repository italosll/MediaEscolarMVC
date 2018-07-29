package com.example.italo.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.italo.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import com.example.italo.mediaescolarmvc.datasource.DataSource;
import com.example.italo.mediaescolarmvc.model.MediaEscolar;

import java.util.List;

public class MediaEscolarController  extends DataSource{

    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    public void calcularMedia(){

    }

    public void resultadoFinal(){

    }

    public boolean salvar( MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = insert(MediaEscolarDataModel.getTABELA(), dados);

        return sucesso;
    }


    public boolean deletar(MediaEscolar obj){

        boolean sucesso = true;

        sucesso = deletar(MediaEscolarDataModel.getTABELA(), obj.getId());

        return sucesso;

    }


    public boolean alterar(MediaEscolar obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getId(), obj.getId());
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = alterar(MediaEscolarDataModel.getTABELA(),dados);

        return sucesso;


    }


    public List<MediaEscolar> listar(){

        return getAllMediaEscolar();

    }





}

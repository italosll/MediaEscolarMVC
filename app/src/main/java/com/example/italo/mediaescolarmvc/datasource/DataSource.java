package com.example.italo.mediaescolarmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.italo.mediaescolarmvc.datamodel.MediaEscolarDataModel;

public class DataSource extends SQLiteOpenHelper {


    private static final String DB_NAME = "media_escolar.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(MediaEscolarDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Média", "DB---->ERRO: " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (Exception e) {

            sucesso = false;
        }

        return sucesso;
    }


    public  boolean deletar(String tabela, int id){


        boolean sucesso = true;

            sucesso = db.delete(tabela,"id=?",
                    new String[]{Integer.toString(id)})>0;


        return sucesso;

    }


    public boolean alterar(String tabela, ContentValues dados){

        boolean sucesso = true;

        int id =  dados.getAsInteger("id");

        sucesso = db.update(tabela, dados , "id=?", new String[]{Integer.toString(id)}) > 0 ;

        return  sucesso;
    }


}

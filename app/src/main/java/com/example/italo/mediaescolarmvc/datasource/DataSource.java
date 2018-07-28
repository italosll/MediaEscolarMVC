package com.example.italo.mediaescolarmvc.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.italo.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import com.example.italo.mediaescolarmvc.model.MediaEscolar;

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

        }catch (Exception e){

            Log.e("Média", "DB---->ERRO: " +e.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

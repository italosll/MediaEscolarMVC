package com.example.italo.mediaescolarmvc.datamodel;

public class MediaEscolarDataModel {

    // Dados para criar as tabelas no banco de dados
    // MOR - modelo relacional

    //Criar dinamicamente uma Query SQL para criar a tabela  Média Escolar no Banco de Dados


    private final static String TABELA =  "media_escolar";

    private final static String id  = "id";
    private final static String materia = "materia";
    private final static String bimestre = "bimestre";
    private final static String situacao = "situacao";
    private final static String notaProva = "notaProva";
    private final static String notaMateria = "notaMateria";
    private final static String mediaFinal = "mediaFinal";

    private static  String queryCriarTabela = "id";


    public static String  criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id  + " INTEGER PRIMARY KEY, ";
        queryCriarTabela += materia + " TEXT, ";
        queryCriarTabela += bimestre + " TEXT, ";
        queryCriarTabela += situacao + " TEXT, ";
        queryCriarTabela += notaProva + " REAL, ";
        queryCriarTabela += notaMateria + " REAL, ";
        queryCriarTabela += mediaFinal + " REAL ";
        queryCriarTabela += ")";
        return queryCriarTabela;
    }


    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public String getMateria() {
        return materia;
    }

    public String getBimestre() {
        return bimestre;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getNotaProva() {
        return notaProva;
    }

    public String getNotaMateria() {
        return notaMateria;
    }

    public String getMediaFinal() {
        return mediaFinal;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        MediaEscolarDataModel.queryCriarTabela = queryCriarTabela;
    }
}
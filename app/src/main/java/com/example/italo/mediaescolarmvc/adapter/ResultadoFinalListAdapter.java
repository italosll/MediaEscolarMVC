package com.example.italo.mediaescolarmvc.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.italo.mediaescolarmvc.R;
import com.example.italo.mediaescolarmvc.model.MediaEscolar;

import java.util.ArrayList;

public class ResultadoFinalListAdapter extends ArrayAdapter<MediaEscolar> implements View.OnClickListener{


    Context context;

    private int ultimaPosicao = -1;

    AlertDialog.Builder builder;
    AlertDialog alert;

    private static class ViewHolder{

        TextView txtBimestre;
        TextView txtSituacao;
        TextView txtMateria;

        ImageView imgLogo;
        ImageView imgConsultar;
        ImageView imgEditar;
        ImageView imgDeletar;
        ImageView imgSalvar;




    }

    public ResultadoFinalListAdapter(ArrayList<MediaEscolar> dataSet,  Context context) {
        super(context, R.layout.listview_resultado_final, dataSet);


        ArrayList<MediaEscolar> dados = dataSet;

        this.context = context;

    }

    @Override
    public void onClick(View view) {

        int posicao = (Integer) view.getTag();

        Object object = getItem(posicao);

        MediaEscolar mediaEscolar = (MediaEscolar) object;

        switch (view.getId()) {

            case R.id.imgLogo:

                // Apresentar  os detalhes

                Snackbar.make(view, "Nota da Prova " + mediaEscolar.getNotaProva(), Snackbar.LENGTH_LONG).setAction("No action", null).show();

                break;



            case R.id.imgDeletar:

                builder = new AlertDialog.Builder(getContext());

                builder.setTitle("ALERTA");
                builder.setMessage("Deseja DELETAR este registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // Deletar o Rgistro


                    }
                });

                builder.setNegativeButton("CANCELAR", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        dialogInterface.cancel();

                    }
                });


                alert = builder.create();
                alert.show();

                break;




            case R.id.imgConsultar:

                builder = new AlertDialog.Builder(getContext());

                builder.setTitle("ALERTA");
                builder.setMessage("Deseja CONSULTAR este registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // Deletar o Rgistro


                    }
                });

                builder.setNegativeButton("CANCELAR", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        dialogInterface.cancel();

                    }
                });


                alert = builder.create();
                alert.show();

                break;






            case R.id.imgEditar:

                builder = new AlertDialog.Builder(getContext());

                builder.setTitle("ALERTA");
                builder.setMessage("Deseja EDITAR este registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // Deletar o Rgistro


                    }
                });

                builder.setNegativeButton("CANCELAR", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        dialogInterface.cancel();

                    }
                });


                alert = builder.create();
                alert.show();

                break;






            case R.id.imgSalvar:

                builder = new AlertDialog.Builder(getContext());

                builder.setTitle("ALERTA");
                builder.setMessage("Deseja SALVAR este registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // Deletar o Rgistro


                    }
                });

                builder.setNegativeButton("CANCELAR", new Dialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        dialogInterface.cancel();

                    }
                });


                alert = builder.create();
                alert.show();

                break;




        }
    }

    @NonNull
    @Override
    public View getView(int position,  View dataSet, @NonNull ViewGroup parent) {

        MediaEscolar mediaEscolar = getItem(position);

        ViewHolder linha;

        if(dataSet == null){


            linha = new ViewHolder();

            LayoutInflater layoutResultadoFinalList = LayoutInflater.from(getContext());

            dataSet = layoutResultadoFinalList.inflate(R.layout.listview_resultado_final,parent, false);

            linha.txtMateria = dataSet.findViewById(R.id.txtMateria);
            linha.txtBimestre = dataSet.findViewById(R.id.txtBimestre);
            linha.txtSituacao = dataSet.findViewById(R.id.txtResultado);
            linha.imgLogo = dataSet.findViewById(R.id.imgLogo);
            linha.imgConsultar = dataSet.findViewById(R.id.imgConsultar);
            linha.imgSalvar = dataSet.findViewById(R.id.imgSalvar);
            linha.imgDeletar = dataSet.findViewById(R.id.imgDeletar);
            linha.imgEditar = dataSet.findViewById(R.id.imgEditar);

            dataSet.setTag(linha);

        }else{

            linha = (ViewHolder) dataSet.getTag();
        }

        linha.txtMateria.setText(mediaEscolar.getMateria());
        linha.txtBimestre.setText(mediaEscolar.getBimestre());
        linha.txtSituacao.setText(mediaEscolar.getSituacao());

        linha.imgLogo.setOnClickListener(this);
        linha.imgLogo.setTag(position);


        linha.imgDeletar.setOnClickListener(this);
        linha.imgDeletar.setTag(position);

        linha.imgSalvar.setOnClickListener(this);
        linha.imgSalvar.setTag(position);

        linha.imgEditar.setOnClickListener(this);
        linha.imgEditar.setTag(position);


        return dataSet;


    }










    // Herdar ArrayAdapter - MediaEscolar
    // Impllementar OnclickListner
    // Contexto
    // Classe ViewHolder para os componentes ImageView e TextView
    // Atributo  para conhecer a posicao no Array - animação
    // Construtor que receba o dataSet
    // onClick do elemento da lista
    // Devolver via getView por linha para o ListView

}

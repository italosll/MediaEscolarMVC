package com.example.italo.mediaescolarmvc.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.italo.mediaescolarmvc.R;
import com.example.italo.mediaescolarmvc.adapter.ResultadoFinalListAdapter;
import com.example.italo.mediaescolarmvc.controller.MediaEscolarController;
import com.example.italo.mediaescolarmvc.model.MediaEscolar;

import java.util.ArrayList;


public class ResultadoFinalFragment extends Fragment {


    // Adapter
    // dataSet com os dados
    ArrayList<MediaEscolar> dataSet;

    // listView para buscar os dados no DB
    ListView listView;

    // Controler para buscar os dados no DB
    MediaEscolarController controller;

    // Novo método na controller  getResultadoFinal devolvendo  um ArrayList



    View view;

    public ResultadoFinalFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_resultado_final, container, false);

        controller = new MediaEscolarController(getContext());

        listView = view.findViewById(R.id.listview);

        dataSet = controller.getAllResultadoFinal();

        ResultadoFinalListAdapter adapter = new ResultadoFinalListAdapter(dataSet, getContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                MediaEscolar mediaEscolar = dataSet.get(i);

                Double media = mediaEscolar.getMediaFinal();

                Snackbar.make(view,  mediaEscolar.getMateria() +
                        "\n" + mediaEscolar.getSituacao() +
                        " Média Final: " +
                        mediaEscolar.getMediaFinal() , Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();




            }
        });


        return view;
    }
}

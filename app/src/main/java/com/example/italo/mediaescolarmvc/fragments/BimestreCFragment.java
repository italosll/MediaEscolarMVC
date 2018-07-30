package com.example.italo.mediaescolarmvc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.italo.mediaescolarmvc.R;


public class BimestreCFragment extends Fragment {



    Button btnCalcular;
    EditText editMateria;
    EditText editNotaProva;
    EditText editNotaTrabalho;
    TextView txtResultado;
    TextView txtSituacaoFinal;

    double notaProva;
    double notaTrabalho;
    double media;

    boolean dadosValidados = true;


    Context context;

    View view;

    public BimestreCFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_bimestre_c, container, false);

        btnCalcular = view.findViewById(R.id.btnCalcular);
        editMateria = view.findViewById(R.id.editMateria);
        editNotaProva = view.findViewById(R.id.editNotaProva);
        editNotaTrabalho = view.findViewById(R.id.editNotaTrabalho);
        txtResultado = view.findViewById(R.id.txtResultado);
        txtSituacaoFinal = view.findViewById(R.id.txtSituacaoFinal);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    if (editNotaProva.getText().toString().length() > 0) {
                        notaProva = Double.parseDouble(editNotaProva.getText().toString());

                        if (notaProva > 10) {
                            dadosValidados = false;
                            Toast.makeText(context, "Nota inválida!", Toast.LENGTH_SHORT).show();
                            editNotaProva.requestFocus();

                        } else {
                            dadosValidados = true;
                        }

                    } else {
                        editNotaProva.setError("*");
                        editNotaProva.requestFocus();
                        dadosValidados = false;
                    }

                    if (editNotaTrabalho.getText().toString().length() > 0) {
                        notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());


                        if (notaTrabalho > 10) {
                            dadosValidados = false;
                            Toast.makeText(context, "Nota inválida!", Toast.LENGTH_SHORT).show();
                            editNotaTrabalho.requestFocus();

                        } else {
                            dadosValidados = true;
                        }

                    } else {
                        editNotaTrabalho.setError("*");
                        editNotaTrabalho.requestFocus();
                        dadosValidados = false;
                    }

                    if (editMateria.getText().toString().length() == 0) {
                        editMateria.setError("*");
                        editMateria.requestFocus();
                        dadosValidados = false;
                    }

                    // Após Validação
                    if (dadosValidados) {
                        media = (notaProva + notaTrabalho) / 2;

                        //txtResultado.setText(MainActivity.formatarValorDecimal(media));

                        if (media >= 7) txtSituacaoFinal.setText("Aprovado");
                        else txtSituacaoFinal.setText("Reprovado");

                        //editNotaProva.setText(MainActivity.formatarValorDecimal(notaProva));
                        //editNotaTrabalho.setText(MainActivity.formatarValorDecimal(notaTrabalho));

                        //salvarSharedPreferences();

                    }

                } catch (Exception e) {

                    Toast.makeText(context, "Informe as notas...", Toast.LENGTH_LONG).show();

                }

            }


        });

        return view;
    }
}

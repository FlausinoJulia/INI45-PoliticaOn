package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ActivityPerfilCandidato extends AppCompatActivity {

    int idDoUsuario;
    Candidato candidato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_do_candidato);

        AppCompatButton btnVoltarPerfilCand;

        ImageView foto_candid    = (ImageView)findViewById(R.id.foto_candid);
        TextView nome_candidato  = findViewById(R.id.nome_candidato);
        TextView sigla_partido   = findViewById(R.id.sigla_partido);
        TextView cargo_candidato = findViewById(R.id.cargo_candidato);

        // dados gerais
        TextView text_nomeCompleto  = findViewById(R.id.text_nomeCompleto);
        TextView text_numCandidato  = findViewById(R.id.text_numCandidato);
        TextView text_numPartido    = findViewById(R.id.text_numPartido);
        TextView text_grauIntrucao  = findViewById(R.id.text_grauIntrucao);
        TextView text_cpfCnpj       =  findViewById(R.id.text_cpfCnpj);
        TextView text_genero        =  findViewById(R.id.text_genero);
        TextView text_corRaca       =  findViewById(R.id.text_corRaca);

        Intent intent = getIntent();
        idDoUsuario = intent.getIntExtra("idDoUsuario", -1);
        candidato   = intent.getParcelableExtra("candidato");

        // setar foto_candid
        nome_candidato.setText(candidato.getNome());
        sigla_partido.setText(candidato.getSiglaPartido());
        cargo_candidato.setText(candidato.getCargo());

        // dados gerais
        text_nomeCompleto.setText(candidato.getNome());

        String numCand = candidato.getNumCandidato() + "";
        text_numCandidato.setText(numCand);

        String numPart = candidato.getNumPartido() + "";
        text_numPartido.setText(numPart);

        text_grauIntrucao.setText(candidato.getGrauInstrucao());
        text_cpfCnpj.setText(candidato.getCpfOuCnpj());
        text_genero.setText(candidato.getGenero());
        text_corRaca.setText(candidato.getCorRaca());

        btnVoltarPerfilCand = findViewById(R.id.btnVoltarPerfilCand);
        btnVoltarPerfilCand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // terminamos essa activity e voltamos para a passada
            }
        });
    }
}
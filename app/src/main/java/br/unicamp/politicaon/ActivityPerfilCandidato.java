package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ActivityPerfilCandidato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_do_candidato);

        TextView nome_candidato  = findViewById(R.id.nome_candidato);
        TextView sigla_partido   = findViewById(R.id.sigla_partido);
        TextView cargo_candidato = findViewById(R.id.cargo_candidato);
        TextView cpf_cnpj        = findViewById(R.id.cpf_cnpj);
        TextView grau_instrucao  = findViewById(R.id.grau_instrucao);
        TextView cor_raca        = findViewById(R.id.cor_raca);
        TextView genero          =  findViewById(R.id.genero);

        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String line = "";
        ArrayList<String> candidatos = new ArrayList<>();

        try {
            String[] cols = br.readLine().split(";");

            if(cols.length > 0
            ){

                /* nome_candidato.setText(nome_candidato.getText() + cols[0] + cols[1]  + cols[2] + "'");
                nome_candidato.setText(nome_candidato.getText() + cols[0]);
                sigla_partido.setText(sigla_partido.getText() + cols[3]);
                cargo_candidato.setText(cargo_candidato.getText() + cols[4]);
                cpf_cnpj.setText(cpf_cnpj.getText() + cols[5]);
                grau_instrucao.setText(grau_instrucao.getText() + cols[6]);
                cor_raca.setText(cor_raca.getText() + cols[7]);
                genero.setText(genero.getText() + cols[8]); */

                nome_candidato.setText(cols[0] + cols[1]  + cols[2]);
                sigla_partido.setText(cols[3]);
                cargo_candidato.setText(cols[4]);
                cpf_cnpj.setText(cols[5]);
                grau_instrucao.setText(cols[6]);
                cor_raca.setText(cols[7]);
                genero.setText(cols[8]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
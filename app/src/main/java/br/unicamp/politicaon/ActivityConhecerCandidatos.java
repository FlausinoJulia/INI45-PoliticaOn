package br.unicamp.politicaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ActivityConhecerCandidatos extends AppCompatActivity {

    BottomNavigationView menu;
    int idDoUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecer_candidatos);

        Intent intent = getIntent();
        idDoUsuario = intent.getIntExtra("idDoUsuario", -1);

        menu = findViewById(R.id.menu_horizontal);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.aprender:
                        Intent irProAprender = new Intent(ActivityConhecerCandidatos.this, ActivityAprender.class);
                        irProAprender.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProAprender);
                        break;
                    case R.id.monitorar:
                        //Intent irProMonitorar = new Intent(ActivityInicio.this, ActivityMonitorar.class);
                        //irProMonitorar.putExtra("idDoUsuario", idDoUsuario);
                        break;
                    case R.id.inicio:
                        Intent irProInicio = new Intent(ActivityConhecerCandidatos.this, ActivityInicio.class);
                        irProInicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        irProInicio.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProInicio);
                        break;
                }

                return true;
            }
        });
    }

    private List<Candidato> lerCsv()
    {
        List<Candidato> lista = new ArrayList<Candidato>();

        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String linha = " ";

            try {
                // lemos a primeira linha do arquivo, que contém os identificadores dos dados
                br.readLine();

                while ((linha = br.readLine())!= null)
                {
                    String[] tokens = linha.split(";");

                    Candidato candidatoLido = new Candidato();

                    candidatoLido.setNome(tokens[0]);

                    if (tokens[1].length() > 0)
                    {
                        candidatoLido.setNumPartido(Integer.parseInt(tokens[1]));
                    }
                    else
                        candidatoLido.setNumPartido(-1);

                    if (tokens[2].length() > 0)
                    {
                        candidatoLido.setNumCandidato(Integer.parseInt(tokens[2]));
                    }
                    else
                        candidatoLido.setNumCandidato(-1);

                    candidatoLido.setSiglaPartido(tokens[3]);
                    candidatoLido.setCargo(tokens[4]);
                    candidatoLido.setCpfOuCnpj(tokens[5]);
                    candidatoLido.setGrauInstrucao(tokens[6]);
                    candidatoLido.setCorRaca(tokens[7]);

                    if (tokens.length >= 8)
                    {
                        candidatoLido.setGenero(tokens[8]);
                    }
                    else
                    {
                        candidatoLido.setGenero(" ");
                    }

                    lista.add(candidatoLido);
                }
            } catch (IOException e) {
                Log.wtf("ErroLeitura", "Erro ao ler o csv", e);
                e.printStackTrace();
            }

        return lista;
    }

    @SuppressLint("NonConstantResourceId")
    public void clickCargo(@NonNull View view)
    {
        // lemos o arquivo csv
        List<Candidato> candidatosCsv = lerCsv();

        switch (view.getId())
        {
            case R.id.btnPresidente:
            case R.id.setaPresidente:

                // pegamos todos os registros de presidente da lista de candidatos e guardamos em uma lista separada
                ArrayList<Candidato> presidentes = new ArrayList<Candidato>();

                for (Candidato candidato : candidatosCsv)
                {
                    if (candidato.getCargo().equals("PRESIDENTE"))
                        presidentes.add(candidato);
                }

                Intent mostrarPresidentes = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarPresidentes.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarPresidentes.putExtra("idDoUsuario", idDoUsuario);
                mostrarPresidentes.putExtra("cargoEscolhido", "PRESIDENTE");
                mostrarPresidentes.putParcelableArrayListExtra("listaPresidentes", presidentes);
                startActivity(mostrarPresidentes);

                break;
            case R.id.btnVicePresidente:
            case R.id.setaVicePresidente:

                // pegamos todos os registros de vice presidentes da lista de candidatos e guardamos em uma lista separada
                ArrayList<Candidato> vicePresidentes = new ArrayList<Candidato>();

                for (Candidato candidato : candidatosCsv)
                {
                    if (candidato.getCargo().equals("VICE PRESIDENTE"))
                        vicePresidentes.add(candidato);
                }

                Intent mostrarVicePre = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarVicePre.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarVicePre.putExtra("idDoUsuario", idDoUsuario);
                mostrarVicePre.putExtra("cargoEscolhido", "VICE PRESIDENTE");
                mostrarVicePre.putParcelableArrayListExtra("listaVices", vicePresidentes);
                startActivity(mostrarVicePre);

                break;
            case R.id.btnDeputadoFederal:
            case R.id.setaDeputadoFederal:

                // pegamos todos os registros de dep. federais da lista de candidatos e guardamos em uma lista separada
                ArrayList<Candidato> deputadosFederais = new ArrayList<Candidato>();

                for (Candidato candidato : candidatosCsv)
                {
                    if (candidato.getCargo().equals("DEPUTADO FEDERAL"))
                        deputadosFederais.add(candidato);
                }

                Intent mostrarDepFederal = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarDepFederal.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarDepFederal.putExtra("idDoUsuario", idDoUsuario);
                mostrarDepFederal.putExtra("cargoEscolhido", "DEPUTADO FEDERAL");
                mostrarDepFederal.putParcelableArrayListExtra("listaDeputadosFederais", deputadosFederais);
                startActivity(mostrarDepFederal);

                break;
            case R.id.btnSenador:
            case R.id.setaSenador:

                // pegamos todos os registros de senadores da lista de candidatos e guardamos em uma lista separada
                ArrayList<Candidato> senadores = new ArrayList<Candidato>();

                for (Candidato candidato : candidatosCsv)
                {
                    if (candidato.getCargo().equals("SENADOR"))
                        senadores.add(candidato);
                }

                Intent mostrarSenadores = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarSenadores.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarSenadores.putExtra("idDoUsuario", idDoUsuario);
                mostrarSenadores.putExtra("cargoEscolhido", "SENADOR");
                mostrarSenadores.putParcelableArrayListExtra("listaSenadores", senadores);
                startActivity(mostrarSenadores);

                break;
        }
    }
}
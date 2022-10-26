package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityCargo extends AppCompatActivity {

    int idDoUsuario;
    String cargoEscolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo);

        Intent intent  = getIntent();
        idDoUsuario    = intent.getIntExtra("idDoUsuario", -1);
        cargoEscolhido = intent.getStringExtra("cargoEscolhido");

        switch (cargoEscolhido)
        {
            case "PRESIDENTE":
                break;
            case "VICE PRESIDENTE":
                break;
            case "DEPUTADO FEDERAL":
                break;
            case "SENADOR":
                break;
        }
        // exibir todos os candidatos cadastrados que são do cargo escolhido pelo usuário
    }
}
package br.unicamp.politicaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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

    @SuppressLint("NonConstantResourceId")
    public void clickCargo(@NonNull View view)
    {
        switch (view.getId())
        {
            case R.id.btnPresidente:
            case R.id.setaPresidente:
                Intent mostrarPresidentes = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarPresidentes.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarPresidentes.putExtra("idDoUsuario", idDoUsuario);
                mostrarPresidentes.putExtra("cargoEscolhido", "PRESIDENTE");
                startActivity(mostrarPresidentes);
                break;
            case R.id.btnVicePresidente:
            case R.id.setaVicePresidente:
                Intent mostrarVicePre = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarVicePre.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarVicePre.putExtra("idDoUsuario", idDoUsuario);
                mostrarVicePre.putExtra("cargoEscolhido", "VICE PRESIDENTE");
                startActivity(mostrarVicePre);
                break;
            case R.id.btnDeputadoFederal:
            case R.id.setaDeputadoFederal:
                Intent mostrarDepFederal = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarDepFederal.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarDepFederal.putExtra("idDoUsuario", idDoUsuario);
                mostrarDepFederal.putExtra("cargoEscolhido", "DEPUTADO FEDERAL");
                startActivity(mostrarDepFederal);
                break;
            case R.id.btnSenador:
            case R.id.setaSenador:
                Intent mostrarSenadores = new Intent(ActivityConhecerCandidatos.this, ActivityCargo.class);
                mostrarSenadores.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mostrarSenadores.putExtra("idDoUsuario", idDoUsuario);
                mostrarSenadores.putExtra("cargoEscolhido", "SENADOR");
                startActivity(mostrarSenadores);
                break;
        }
    }
}
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
                        //Intent irProAprender = new Intent(ActivityInicio.this, ActivityAprender.class);
                        //irProAprender.putExtra("idDoUsuario", idDoUsuario);
                        break;
                    case R.id.monitorar:
                        //Intent irProMonitorar = new Intent(ActivityInicio.this, ActivityMonitorar.class);
                        //irProMonitorar.putExtra("idDoUsuario", idDoUsuario);
                        break;
                    /*case R.id.inicio:
                        Intent irProInicio = new Intent(ActivityConhecerCandidatos.this, ActivityInicio.class);
                        // irProInicio.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        irProInicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        irProInicio.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProInicio);
                        break;*/
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
                break;
            case R.id.btnVicePresidente:
            case R.id.setaVicePresidente:
                break;
            case R.id.btnDeputadoFederal:
            case R.id.setaDeputadoFederal:
                break;
            case R.id.btnSenador:
            case R.id.setaSenador:
                break;
        }
    }
}
package br.unicamp.politicaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ActivityConhecerCandidatos extends AppCompatActivity {

    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecer_candidatos);

        menu = findViewById(R.id.menu);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.inicio:

                        Intent intent1 = new Intent(ActivityConhecerCandidatos.this, ActivityInicio.class);
                        startActivity(intent1);

                        break;
                    case R.id.aprender:

                        //  Intent intent1 = new Intent(ActivityInicio.this, ActivityAprender.class)

                        break;
                    case R.id.monitorar:

                        // Intent intent3 = new Intent(ActivityInicio.this, ActivityPainelDeMonitoramento.class);
                        // startActivity(intent3);

                        break;
                }
                return true;
            }
        });
    }
}
package br.unicamp.politicaon.Aprender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import br.unicamp.politicaon.Activities.ActivityConhecerCandidatos;
import br.unicamp.politicaon.Activities.ActivityInicio;
import br.unicamp.politicaon.R;

public class Aprender_Historia extends AppCompatActivity {

    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender_historia);

        AppCompatButton arrow_left = findViewById(R.id.arrow_left);
        arrow_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // terminamos essa activity e voltamos para a passada
            }
        });

        menu = findViewById(R.id.menu_horizontal);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.aprender:
                        finish();
                        break;
                    case R.id.monitorar:
                        //Intent irProMonitorar = new Intent(ActivityInicio.this, ActivityMonitorar.class);
                        //irProMonitorar.putExtra("idDoUsuario", idDoUsuario);
                        break;
                    case R.id.inicio:
                        Intent irProInicio = new Intent(Aprender_Historia.this, ActivityInicio.class);
                        irProInicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(irProInicio);
                        break;
                    case R.id.conhecer:
                        Intent irProConhecer = new Intent(Aprender_Historia.this, ActivityConhecerCandidatos.class);
                        startActivity(irProConhecer);
                        break;
                }

                return true;
            }
        });
    }
}
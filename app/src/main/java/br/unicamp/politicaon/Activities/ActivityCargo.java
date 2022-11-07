package br.unicamp.politicaon.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import br.unicamp.politicaon.Adapters.AdapterCandidatos;
import br.unicamp.politicaon.Models.Candidato;
import br.unicamp.politicaon.R;

public class ActivityCargo extends AppCompatActivity {

    int idDoUsuario;
    String cargoEscolhido;
    List<Candidato> candidatos;
    RecyclerView recyclerViewCandidatos;
    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo);

        Intent intent  = getIntent();
        idDoUsuario    = intent.getIntExtra("idDoUsuario", -1);
        cargoEscolhido = intent.getStringExtra("cargoEscolhido");

        AppCompatButton btnVoltarCargo;

        switch (cargoEscolhido)
        {
            case "PRESIDENTE":
                candidatos = intent.getParcelableArrayListExtra("listaPresidentes");
                break;
            case "VICE PRESIDENTE":
                candidatos = intent.getParcelableArrayListExtra("listaVices");
                break;
            case "DEPUTADO FEDERAL":
                candidatos = intent.getParcelableArrayListExtra("listaDeputadosFederais");
                break;
            case "SENADOR":
                candidatos = intent.getParcelableArrayListExtra("listaSenadores");
                break;
        }

        candidatos.removeIf(candidato -> candidato == null ||
                candidato.getNome().equals(" ") ||
                candidato.getNumPartido() == -1 ||
                candidato.getNumCandidato() == -1 ||
                candidato.getSiglaPartido().equals(" ") ||
                candidato.getCargo().equals(" ") ||
                candidato.getCpfOuCnpj().equals(" ") ||
                candidato.getGrauInstrucao().equals(" ") ||
                candidato.getCorRaca().equals(" ") ||
                candidato.getGenero().equals(" "));

        if (candidatos.isEmpty())
        {
            TextView tvVazio = findViewById(R.id.tvVazio);
            tvVazio.setVisibility(View.VISIBLE);
        }
        else
        {
            // exibindo os candidatos no recycler view candidatos
            AdapterCandidatos adapter = new AdapterCandidatos(this, candidatos, idDoUsuario);
            recyclerViewCandidatos = findViewById(R.id.recyclerViewCandidatos);
            recyclerViewCandidatos.setAdapter(adapter);
            recyclerViewCandidatos.setLayoutManager(new LinearLayoutManager(ActivityCargo.this));
        }

        menu = findViewById(R.id.menu_horizontal_ac_cargo);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.aprender:
                        Intent irProAprender = new Intent(ActivityCargo.this, ActivityAprender.class);
                        irProAprender.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        irProAprender.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProAprender);
                        break;
                    case R.id.monitorar:
                        //Intent irProMonitorar = new Intent(ActivityInicio.this, ActivityMonitorar.class);
                        //irProMonitorar.putExtra("idDoUsuario", idDoUsuario);
                        break;
                    case R.id.inicio:
                        Intent irProInicio = new Intent(ActivityCargo.this, ActivityInicio.class);
                        irProInicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        irProInicio.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProInicio);
                        break;
                    case R.id.conhecer:
                        Intent irProConhecer = new Intent(ActivityCargo.this, ActivityConhecerCandidatos.class);
                        irProConhecer.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        irProConhecer.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProConhecer);
                        break;
                }

                return true;
            }
        });

        btnVoltarCargo = findViewById(R.id.btnVoltarCargo);
        btnVoltarCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // terminamos essa activity e voltamos para a activity passada
            }
        });
    }
}
package br.unicamp.politicaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import br.unicamp.politicaon.Models.NewsApiResponse;
import br.unicamp.politicaon.Models.NewsHeadLines;

import java.util.Collections;
import java.util.List;

public class ActivityInicio extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    BottomNavigationView menu;
    int idDoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Buscando notícias recentes");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "eleicoes");

        // para pegar o id do usuario logado
        Intent intent = getIntent();
        idDoUsuario = intent.getIntExtra("idDoUsuario", -1);

        Toast.makeText(this, idDoUsuario + "", Toast.LENGTH_SHORT).show();

        menu = findViewById(R.id.menu_horizontal);

        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.aprender:
                        //Intent irProAprender = new Intent(ActivityInicio.this, ActivityAprender.class);
                        //irProAprender.putExtra("idDoUsuario", idDoUsuario);
                        //startActivity(irProAprender);
                        break;
                    case R.id.monitorar:
                        //Intent irProMonitorar = new Intent(ActivityInicio.this, ActivityMonitorar.class);
                        //irProMonitorar.putExtra("idDoUsuario", idDoUsuario);
                        //startActivity(irProMonitorar);
                        break;
                    case R.id.conhecer:
                        Intent irProConhecer = new Intent(ActivityInicio.this, ActivityConhecerCandidatos.class);
                        irProConhecer.putExtra("idDoUsuario", idDoUsuario);
                        startActivity(irProConhecer);
                        break;
                }

                return true;
            }
        });
    }

    private final OnFetchDataListener<NewsApiResponse> listener =
            new OnFetchDataListener<NewsApiResponse>() {
                @Override
                public void onFetchData(List<NewsHeadLines> list, String message) {
                    if (list.isEmpty()) {
                        Toast.makeText(ActivityInicio.this, "Sem notícias encontradas", Toast.LENGTH_LONG).show();
                    } else {
                        showNews(list);
                        dialog.dismiss();
                    }
                }

                @Override
                public void onError(String message) {
                    Toast.makeText(ActivityInicio.this, "Ocorreu um erro", Toast.LENGTH_LONG).show();
                }
            };

    private void showNews(List<NewsHeadLines> list) {
        recyclerView = findViewById(R.id.recyclerViewNoticias);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadLines headlines) {
        startActivity(new Intent(ActivityInicio.this, DetailsActivity.class)
                .putExtra("data", headlines));
    }
}
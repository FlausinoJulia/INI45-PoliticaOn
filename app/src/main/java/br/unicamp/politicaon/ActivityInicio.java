package br.unicamp.politicaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.unicamp.politicaon.Models.NewsApiResponse;
import br.unicamp.politicaon.Models.NewsHeadLines;

import java.util.List;

public class ActivityInicio extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Buscando notícias recentes");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "eleicoes");
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.aprender:

                // Intent intent1 = new Intent(ActivityInicio.this, ActivityAprender.class);
                // startActivity(intent1);

                break;
            case R.id.conhecer:

                Intent intent2 = new Intent(ActivityInicio.this, ActivityConhecerCandidatos.class);
                startActivity(intent2);

                break;
            case R.id.monitorar:

                // Intent intent3 = new Intent(ActivityInicio.this, ActivityPainelDeMonitoramento.class);
                // startActivity(intent3);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
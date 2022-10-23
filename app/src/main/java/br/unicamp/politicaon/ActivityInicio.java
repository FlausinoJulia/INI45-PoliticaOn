package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.unicamp.politicaon.Models.NewsApiResponse;
import br.unicamp.politicaon.Models.NewsHeadLines;

import java.util.List;

public class ActivityInicio extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;

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
}
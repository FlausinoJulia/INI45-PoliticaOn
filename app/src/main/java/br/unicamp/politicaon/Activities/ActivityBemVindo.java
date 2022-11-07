package br.unicamp.politicaon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.unicamp.politicaon.R;

public class ActivityBemVindo extends AppCompatActivity {

    AppCompatButton btnCadastrese, btnLoginInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        btnCadastrese   = findViewById(R.id.btnCadastrese);
        btnLoginInicial = findViewById(R.id.btnLoginInicial);

        btnCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityBemVindo.this, ActivityCadastro.class);
                startActivity(intent);
            }
        });

        btnLoginInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityBemVindo.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }
}
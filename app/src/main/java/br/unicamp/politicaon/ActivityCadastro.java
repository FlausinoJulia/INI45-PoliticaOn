package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCadastro extends AppCompatActivity {

    Button   btnCadastro;
    EditText edtNome, edtEmail, edtSenha;

    String nome, email, senha; // dados do user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // associamos aos componetes do xml
        btnCadastro = (Button) findViewById(R.id.btnCadastro);

        // on click do btnCadastro
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
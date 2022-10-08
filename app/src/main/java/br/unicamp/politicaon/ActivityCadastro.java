package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCadastro extends AppCompatActivity {

    AppCompatButton btnCadastro;
    EditText edtNome, edtEmail, edtSenha;
    TextView tvLogin;
    String nome, email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // associamos aos componetes do xml
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);

        btnCadastro = findViewById(R.id.btnCadastro);

        tvLogin = findViewById(R.id.tvLogin);

        // on click do btnCadastro
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (edtNome.getText().toString().isEmpty() && edtEmail.getText().toString().isEmpty() &&
                    edtSenha.getText().toString().isEmpty())
                {
                    Toast.makeText(ActivityCadastro.this, "Preencha todos os campos obrigatórios", Toast.LENGTH_LONG).show();
                    return;
                }

                cadastrarUsuario();
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityCadastro.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }

    private void cadastrarUsuario()
    {
        nome = edtNome.getText().toString();
        senha = edtSenha.getText().toString();
        int idEstado = 13; // estado de teste
        email = edtEmail.getText().toString();

        Usuario user = new Usuario(nome, senha, idEstado, email);
        UsuarioService service = RetrofitConfig.getRetrofitInstance().create(UsuarioService.class);
        Call<Usuario> call = service.adicionarUsuario(user);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.code() == 400)
                    Toast.makeText(ActivityCadastro.this, "Esse email já está cadastrado", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(ActivityCadastro.this, "Usuário adicionado", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityCadastro.this, ActivityInicio.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Não foi possível realizar o cadastro", Toast.LENGTH_LONG).show();
                Log.e("erroDeConexao", t.getMessage());
            }
        });
    }
}
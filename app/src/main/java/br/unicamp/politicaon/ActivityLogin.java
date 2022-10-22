package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    TextView tvCadastro;
    EditText edtEmailLogin, edtSenhaLogin;
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvCadastro = findViewById(R.id.tvCadastro);
        btnLogin = findViewById(R.id.btnLogin);

        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);

        tvCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLogin.this, ActivityCadastro.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtEmailLogin.getText().toString().isEmpty()
                        || edtSenhaLogin.getText().toString().isEmpty())
                {
                    Toast.makeText(ActivityLogin.this, "Preencha todos os campos obrigatórios", Toast.LENGTH_LONG).show();
                }
                else
                {
                    loginDoUsuario();
                }
            }
        });
    }

    private void loginDoUsuario()
    {
        String email, senha;
        email = edtEmailLogin.getText().toString();
        senha = edtSenhaLogin.getText().toString();

        Usuario user = new Usuario("", senha, 0, email);
        UsuarioService service = RetrofitConfig.getRetrofitInstance().create(UsuarioService.class);
        Call<Usuario> call = service.logarUsuario(user);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int code = response.code();
                if (code == 404)
                    Toast.makeText(ActivityLogin.this, "Email incorreto!", Toast.LENGTH_LONG).show();
                else if (code == 401)
                    Toast.makeText(ActivityLogin.this, "Senha incorreta!", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(ActivityLogin.this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
                    // int idDoUserLogado = response.body()
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }
}
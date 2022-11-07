package br.unicamp.politicaon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.politicaon.Models.Estado;
import br.unicamp.politicaon.Models.Usuario;
import br.unicamp.politicaon.R;
import br.unicamp.politicaon.RetrofitConfig;
import br.unicamp.politicaon.Services.EstadoService;
import br.unicamp.politicaon.Services.UsuarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCadastro extends AppCompatActivity {

    AppCompatButton btnCadastro;
    AutoCompleteTextView btnEstado;
    ArrayAdapter<String> adapterItens;
    List<Estado> estados;
    EditText edtNome, edtEmail, edtSenha;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // associamos aos componetes do xml
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);

        btnCadastro = findViewById(R.id.btnCadastro);

        btnEstado = findViewById(R.id.btnEstado);

        EstadoService estadoService = RetrofitConfig.getRetrofitInstance().create(EstadoService.class);
        Call<List<Estado>> callEstado = estadoService.getEstados();
        callEstado.enqueue(new Callback<List<Estado>>() {
            @Override
            public void onResponse(Call<List<Estado>> call, Response<List<Estado>> response) {
                if (response.code() == 500)
                    Toast.makeText(ActivityCadastro.this, "Erro de conexão com a api!", Toast.LENGTH_LONG).show();
                else {
                    estados = response.body();

                    if (estados == null) {
                        btnEstado.setVisibility(View.INVISIBLE);
                        btnEstado.setText("");
                    }
                    else
                    {
                        ArrayList<String> nomesDosEstados = new ArrayList<>();
                        for (Estado estado : estados) {
                            nomesDosEstados.add(estado.getNome());
                        }

                        adapterItens = new ArrayAdapter<String>(ActivityCadastro.this, R.layout.lista_itens, nomesDosEstados);
                        btnEstado.setAdapter(adapterItens);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Estado>> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Não foi possível pegar os estados da api...", Toast.LENGTH_LONG).show();
                Log.e("erroDeConexao", t.getMessage());
            }
        });



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
        String nome = edtNome.getText().toString();
        String senha = edtSenha.getText().toString();

        // int idEstado = 13; // estado de teste
        String nomeEstado = btnEstado.getText().toString();
        int idEstado = -1;

        for  (Estado estado : estados)
        {
            if (estado.getNome().equals(nomeEstado)) {
                idEstado = estado.getId();
                break;
            }
        }

        String email = edtEmail.getText().toString();

        Usuario user = new Usuario(nome, senha, idEstado, email);
        UsuarioService service = RetrofitConfig.getRetrofitInstance().create(UsuarioService.class);
        Call<Usuario> call = service.adicionarUsuario(user);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.code() == 400)
                    Toast.makeText(ActivityCadastro.this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_LONG).show();
                else if (response.code() == 422)
                    Toast.makeText(ActivityCadastro.this, "Email inválido!", Toast.LENGTH_LONG).show();
                else if (response.code() == 409)
                    Toast.makeText(ActivityCadastro.this, "Essse email já está cadastrado!", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(ActivityCadastro.this, "Cadastro realizado!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityCadastro.this, ActivityLogin.class);
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
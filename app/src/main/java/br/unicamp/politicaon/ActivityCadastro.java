package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCadastro extends AppCompatActivity {

    Button   btnCadastro;
    EditText edtNome, edtEmail, edtSenha;
    String   nome, email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // associamos aos componetes do xml
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        btnCadastro = (Button) findViewById(R.id.btnCadastro);

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

                Toast.makeText(ActivityCadastro.this, "Usuário adicionado", Toast.LENGTH_LONG).show();
               // Usuario userReposta = response.body();

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Erro na inclusão", Toast.LENGTH_LONG).show();
            }
        });

        /*
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                // this method is called when we get response from our api.
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                // below line is for hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

                // on below line we are setting empty text
                // to our both edit text.
                jobEdt.setText("");
                nameEdt.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                DataModal responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();

                // below line we are setting our
                // string to our text view.
                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                responseTV.setText("Error found is : " + t.getMessage());
            }
        });
    }
}
         */

    }
}
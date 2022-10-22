package br.unicamp.politicaon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService
{
    // consultar o registro de todos os usuarios
    @GET("/usuarios")
    Call<List<Usuario>> getUsuarios();

    // pesquisar o usuario pelo nome
    @GET("/usuarios/{id}")
    Call<Usuario> getUsuario(@Path("id") int id);

    // adicionar um usuario
    @POST("/usuarios")
    Call<Usuario> adicionarUsuario(@Body Usuario usuario);

    // login de um usuario
    @POST("/usuarios/login")
    Call<Usuario> logarUsuario(@Body Usuario usuario);

    // alterar os dados de um usuario
    @PUT("/usuarios/{id}")
    Call<Usuario> atualizarUsuario(@Path("id") int id, @Body Usuario usuario);

    // deletar um usuario
    @DELETE("/usuarios/{id}")
    Call<Usuario> excluirUsuario(@Path("id") int id);
}

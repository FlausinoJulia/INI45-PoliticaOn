package br.unicamp.politicaon.Services;

import java.util.List;

import br.unicamp.politicaon.Models.Estado;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EstadoService
{
    // consultar o registro de todos os estados
    @GET("/estados")
    Call<List<Estado>> getEstados();

    // pesquisar o estado pelo id
    @GET("/estados/{id}")
    Call<Estado> getEstado(@Path("id") int id);
}

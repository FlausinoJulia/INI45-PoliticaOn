package br.unicamp.politicaon;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Usuario implements Serializable
{
    @SerializedName("id")
    private final int id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("senha")
    private String senha;
    @SerializedName("idEstado")
    private int idEstado;
    @SerializedName("email")
    private String email;

    public Usuario(String nome, String senha, int idEstado, String email)
    {
        this.id = 0;
        this.nome = nome;
        this.senha = senha;
        this.idEstado = idEstado;
        this.email = email;
    }

    public int getId() { return this.id; }
    public String getNome() { return this.nome; }
    public String getSenha() { return this.senha; }
    public int getIdEstado() { return this.idEstado; }
    public String getEmail() { return this.email; }

    public void setNome(String nome) { this.nome = nome; }
    public void setRaca(String senha) { this.senha = senha; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }
    public void setImage(String email) { this.email = email; }
}

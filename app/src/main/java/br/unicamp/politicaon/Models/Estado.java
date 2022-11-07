package br.unicamp.politicaon.Models;

import com.google.gson.annotations.SerializedName;

public class Estado
{
    @SerializedName("id")
    private final int id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("uf")
    private String uf;

    public Estado(int id, String nome, String uf)
    {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public Estado(String nome)
    {
        id = -1;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }
}

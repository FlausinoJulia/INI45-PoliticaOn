package br.unicamp.politicaon.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Candidato implements Parcelable
{
    private String nome;
    private int numPartido;
    private int numCandidato;
    private String siglaPartido;
    private String cargo;
    private String cpfOuCnpj;
    private String grauInstrucao;
    private String corRaca;
    private String genero;

    public Candidato(String nome, int numPartido, int numCandidato, String siglaPartido, String cargo,
                     String cpfOuCnpj, String grauInstrucao, String corRaca, String genero)
    {
        this.nome = nome;
        this.numPartido = numPartido;
        this.numCandidato = numCandidato;
        this.siglaPartido = siglaPartido;
        this.cargo = cargo;
        this.cpfOuCnpj = cpfOuCnpj;
        this.grauInstrucao = grauInstrucao;
        this.corRaca = corRaca;
        this.genero = genero;
    }

    public Candidato()
    {
        this.nome = " ";
        this.numPartido = -1;
        this.numCandidato = -1;
        this.siglaPartido = " ";
        this.cargo = " ";
        this.cpfOuCnpj = " ";
        this.grauInstrucao = " ";
        this.corRaca = " ";
        this.genero = " ";
    }

    protected Candidato(Parcel in) {
        nome = in.readString();
        numPartido = in.readInt();
        numCandidato = in.readInt();
        siglaPartido = in.readString();
        cargo = in.readString();
        cpfOuCnpj = in.readString();
        grauInstrucao = in.readString();
        corRaca = in.readString();
        genero = in.readString();
    }

    public static final Creator<Candidato> CREATOR = new Creator<Candidato>() {
        @Override
        public Candidato createFromParcel(Parcel in) {
            return new Candidato(in);
        }

        @Override
        public Candidato[] newArray(int size) {
            return new Candidato[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPartido() {
        return numPartido;
    }

    public void setNumPartido(int numPartido) {
        this.numPartido = numPartido;
    }

    public int getNumCandidato() {
        return numCandidato;
    }

    public void setNumCandidato(int numCandidato) {
        this.numCandidato = numCandidato;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getGrauInstrucao() {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public String getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // implementando Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeInt(numPartido);
        parcel.writeInt(numCandidato);
        parcel.writeString(siglaPartido);
        parcel.writeString(cargo);
        parcel.writeString(cpfOuCnpj);
        parcel.writeString(grauInstrucao);
        parcel.writeString(corRaca);
        parcel.writeString(genero);
    }
}

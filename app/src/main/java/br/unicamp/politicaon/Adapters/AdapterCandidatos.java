package br.unicamp.politicaon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unicamp.politicaon.Activities.ActivityPerfilCandidato;
import br.unicamp.politicaon.Models.Candidato;
import br.unicamp.politicaon.R;

public class AdapterCandidatos extends RecyclerView.Adapter<AdapterCandidatos.MyViewHolder>
{
    private List<Candidato> listaCandidatos;
    private Context contexto;
    private int idDoUsuario;

    public AdapterCandidatos(Context contexto, List<Candidato> listaCandidatos, int idDoUsuario)
    {
        this.contexto = contexto;
        this.listaCandidatos = listaCandidatos;
        this.idDoUsuario = idDoUsuario;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.card_candidato, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCandidatos.MyViewHolder holder, int position) {

        Candidato candidato = listaCandidatos.get(position);
        String nome = candidato.getNome();
        String partido = candidato.getSiglaPartido();

        holder.txtNome.setText(nome);
        holder.txtPartido.setText(partido);

        // setar a imagem do candidato

        holder.viewCandidato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exibirDetalhes = new Intent(contexto, ActivityPerfilCandidato.class);
                exibirDetalhes.putExtra("candidato", candidato);
                exibirDetalhes.putExtra("idDoUsuario", idDoUsuario);
                contexto.startActivity(exibirDetalhes);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaCandidatos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgCandidato;
        TextView txtNome, txtPartido;
        LinearLayout viewCandidato;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.tvNomeCandidato);
            txtPartido = itemView.findViewById(R.id.tvPartidoCandidato);
            imgCandidato = itemView.findViewById(R.id.imgDoCandidato);
            viewCandidato = itemView.findViewById(R.id.viewCandidato);
        }
    }
}

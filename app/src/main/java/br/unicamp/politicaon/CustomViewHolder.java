package br.unicamp.politicaon;

import android.content.ClipData;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView text_title, text_source;
    ImageView img_headline;
    CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title= itemView.findViewById(R.id.tvTituloNoticia);
        text_source= itemView.findViewById(R.id.tvFonteNoticia);
        img_headline=itemView.findViewById(R.id.imagemNoticia);
        cardView= itemView.findViewById(R.id.cardNoticia);
    }
}

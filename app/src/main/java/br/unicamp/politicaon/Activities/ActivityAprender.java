package br.unicamp.politicaon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.politicaon.Aprender.Aprender_CargosFuncoes;
import br.unicamp.politicaon.Aprender.Aprender_Historia;
import br.unicamp.politicaon.Aprender.Aprender_SistemaPolitico;
import br.unicamp.politicaon.Aprender.Aprender_TipoVoto;
import br.unicamp.politicaon.R;

public class ActivityAprender extends AppCompatActivity {

    List<CarouselItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        ImageCarousel carousel = findViewById(R.id.carousel);

        // Register lifecycle. For activity this will be lifecycle/getLifecycle() and for fragments it will be viewLifecycleOwner/getViewLifecycleOwner().
        carousel.registerLifecycle(getLifecycle());

        // Teste
        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"
                )
        );

        // Image drawable with caption
        list.add(
                new CarouselItem(
                        R.drawable.img1,
                        "Reunião taltaltal"
                )
        );
        // Image drawable with caption
        list.add(
                new CarouselItem(
                        R.drawable.img2,
                        "Reunião taltaltal"
                )
        );

        // Image drawable with caption
        list.add(
                new CarouselItem(
                        R.drawable.img3,
                        "Reunião taltaltal"
                )
        );

        // Image drawable with caption
        list.add(
                new CarouselItem(
                        R.drawable.img4,
                        "Reunião taltaltal"
                )
        );



        carousel.setData(list);

        /*
        AppCompatButton btnVoltarAprender;


        btnVoltarAprender = findViewById(R.id.btnVoltarAprender);
        btnVoltarAprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityAprender.this, ActivityInicio.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });*/
    }

    public void clickAprender (View view)
    {
        switch(view.getId()) {
            case R.id.tema_sistemaPolitico:
                Intent irProSisPoli = new Intent(ActivityAprender.this, Aprender_SistemaPolitico.class);
                startActivity(irProSisPoli);
                break;

            case R.id.tema_cargosFuncoes:
                Intent irProCargosFuncoes = new Intent(ActivityAprender.this, Aprender_CargosFuncoes.class);
                startActivity(irProCargosFuncoes);
                break;

            case R.id.tema_tipoVoto:
                Intent irProTipoVoto = new Intent(ActivityAprender.this, Aprender_TipoVoto.class);
                startActivity(irProTipoVoto);
                break;

            case R.id.tema_historia:
                Intent irProHistoria = new Intent(ActivityAprender.this, Aprender_Historia.class);
                startActivity(irProHistoria);
                break;
        }
    }
}
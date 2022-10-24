package br.unicamp.politicaon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityAprender extends AppCompatActivity {

    List<CarouselItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        ImageCarousel carousel = findViewById(R.id.carousel);

        // Register lifecycle. For activity this will be lifecycle/getLifecycle() and for fragments it will be viewLifecycleOwner/getViewLifecycleOwner().
        carousel.registerLifecycle(getLifecycle());

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

    }
}
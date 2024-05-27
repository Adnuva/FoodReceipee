package com.example.foodreceipe.kategorimakanan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.foodreceipe.R;
import com.example.foodreceipe.details.Salad_Buah;

public class Salad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);

        CardView sldbuah = findViewById(R.id.sldbuah);
        sldbuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Salad.this, Salad_Buah.class);
                startActivity(intent);
            }
        });
    }
}

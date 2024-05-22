package com.example.foodreceipe;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// Salad.java
public class Salad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);
    }

    // Metode untuk menangani klik pada CardView Salad
    public void onSaladClick(View view) {
        // Buat Intent untuk memulai DetailResepActivity dan kirim data resep yang diperlukan
        Intent intent = new Intent(this, DetailResep.class);
        intent.putExtra("resep", "salad"); // Kirim judul resep
        startActivity(intent);
    }

    private class View {
    }

    // Metode untuk menangani klik pada CardView resep lainnya
    // Anda dapat menambahkan metode serupa untuk resep lainnya
}

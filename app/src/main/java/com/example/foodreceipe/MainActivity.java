package com.example.foodreceipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ensure the ImageView is found and set an OnClickListener if needed
        ImageView imageView = findViewById(R.id.lg);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This can be used as an alternative way to handle the click
                lg(v);
            }
        });
    }

    // This method will be called when the ImageView is clicked
    public void lg(View view) {
        // Create an explicit intent to start SecondActivity
        Intent intent = new Intent(MainActivity.this, home.class);
        // Optionally, add data to the intent
        intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!");
        // Start the target activity
        startActivity(intent);
    }
}

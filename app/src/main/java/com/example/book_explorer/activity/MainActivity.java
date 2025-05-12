package com.example.book_explorer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_explorer.R;

public class MainActivity extends AppCompatActivity {

    private Button btnBookList, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        btnBookList = findViewById(R.id.btnBookList);
        btnAbout = findViewById(R.id.btnAbout);

        // Set up click listeners
        btnBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to BookListActivity
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display a simple message about the app
                Toast.makeText(MainActivity.this, 
                    getString(R.string.about_message), 
                    Toast.LENGTH_LONG).show();
            }
        });
    }
} 
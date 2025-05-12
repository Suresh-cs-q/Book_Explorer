package com.example.book_explorer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_explorer.R;

public class BookDetailActivity extends AppCompatActivity {

    private TextView tvBookTitle, tvAuthor, tvYear, tvCategory, tvDescription;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // Initialize UI components
        tvBookTitle = findViewById(R.id.tvBookTitle);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvYear = findViewById(R.id.tvYear);
        tvCategory = findViewById(R.id.tvCategory);
        tvDescription = findViewById(R.id.tvDescription);
        btnBack = findViewById(R.id.btnBack);

        // Get data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Extract book data
            String title = extras.getString("BOOK_TITLE", "");
            String author = extras.getString("BOOK_AUTHOR", "");
            int year = extras.getInt("BOOK_YEAR", 0);
            String description = extras.getString("BOOK_DESCRIPTION", "");
            String category = extras.getString("BOOK_CATEGORY", "");

            // Set data to UI components
            tvBookTitle.setText(title);
            tvAuthor.setText(author);
            tvYear.setText(String.valueOf(year));
            tvCategory.setText(category);
            tvDescription.setText(description);
        }

        // Set up back button click listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to BookListActivity
                finish();
            }
        });
    }
} 
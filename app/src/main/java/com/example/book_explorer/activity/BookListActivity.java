package com.example.book_explorer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_explorer.R;
import com.example.book_explorer.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private LinearLayout bookListContainer;
    private Button btnBack;
    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        // Initialize UI components
        bookListContainer = findViewById(R.id.bookListContainer);
        btnBack = findViewById(R.id.btnBack);

        // Create sample book data
        createSampleBooks();

        // Populate the book list
        populateBookList();

        // Set up back button click listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to MainActivity
                finish();
            }
        });
    }

    /**
     * Create a list of sample books with sample data
     */
    private void createSampleBooks() {
        books = new ArrayList<>();

        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925,
                "Set in the Jazz Age on Long Island, the novel depicts narrator Nick Carraway's " +
                "interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite " +
                "with his former lover, Daisy Buchanan.", "Fiction"));

        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", 1960,
                "The story takes place in the fictional town of Maycomb, Alabama, during the Great " +
                "Depression. The protagonist is Jean Louise (\"Scout\") Finch, an intelligent and " +
                "unconventional girl whose father, Atticus Finch, is a lawyer and member of the state " +
                "legislature who defends a black man accused of raping a young white woman.", "Classic"));

        books.add(new Book(3, "1984", "George Orwell", 1949,
                "The novel is set in Airstrip One, formerly Great Britain, a province of the superstate " +
                "Oceania, whose residents are victims of perpetual war, omnipresent government " +
                "surveillance, and public manipulation.", "Dystopian"));

        books.add(new Book(4, "The Hobbit", "J.R.R. Tolkien", 1937,
                "The story is about the hobbit Bilbo Baggins, who is hired by the wizard Gandalf to " +
                "accompany 13 dwarves led by Thorin Oakenshield on a quest to reclaim the Lonely " +
                "Mountain and its vast treasure from the dragon Smaug.", "Fantasy"));

        books.add(new Book(5, "Pride and Prejudice", "Jane Austen", 1813,
                "The novel follows the character development of Elizabeth Bennet, the dynamic " +
                "protagonist of the book who learns about the repercussions of hasty judgments and " +
                "comes to appreciate the difference between superficial goodness and actual goodness.", "Romance"));
    }

    /**
     * Populate the book list container with book items
     */
    private void populateBookList() {
        LayoutInflater inflater = LayoutInflater.from(this);
        
        // Add each book to the list
        for (final Book book : books) {
            View bookItemView = inflater.inflate(R.layout.item_book, bookListContainer, false);
            
            // Set the book data to the view
            TextView tvBookTitle = bookItemView.findViewById(R.id.tvBookTitle);
            TextView tvBookAuthor = bookItemView.findViewById(R.id.tvBookAuthor);
            TextView tvBookYear = bookItemView.findViewById(R.id.tvBookYear);
            
            tvBookTitle.setText(book.getTitle());
            tvBookAuthor.setText(book.getAuthor());
            tvBookYear.setText(String.valueOf(book.getYear()));
            
            // Set click listener to navigate to book details
            bookItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
                    // Pass book data to the detail activity
                    intent.putExtra("BOOK_ID", book.getId());
                    intent.putExtra("BOOK_TITLE", book.getTitle());
                    intent.putExtra("BOOK_AUTHOR", book.getAuthor());
                    intent.putExtra("BOOK_YEAR", book.getYear());
                    intent.putExtra("BOOK_DESCRIPTION", book.getDescription());
                    intent.putExtra("BOOK_CATEGORY", book.getCategory());
                    startActivity(intent);
                }
            });
            
            // Add the book item to the container
            bookListContainer.addView(bookItemView);
        }
    }
} 
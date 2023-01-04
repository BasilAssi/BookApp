package com.example.bookapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText title, author , pages;
    private Switch switchAva;
    private Button addBook, saveAll ;
    private ArrayList<Book>  books = new ArrayList<Book>();
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        setUpShardPrefs();




    }

    public void setUpView(){
        title = findViewById(R.id.edtTitle);
        author =findViewById(R.id.edtAuthor);
        pages = findViewById(R.id.edtPages);
        switchAva = findViewById(R.id.switch1);
        addBook = findViewById(R.id.btnAdd);
        saveAll = findViewById(R.id.btnSaveAll);
    }


    public void setUpShardPrefs(){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }


//    addBook.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            int number = Integer.parseInt(pages.getText()+"");
//            boolean isChecked = switchAva.isChecked();
//            Book book =  new Book(title.getText().toString() , author.getText().toString() ,number, isChecked);
//            books.add(book);
//        }
//    });
//
//        saveAll.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Log.d("result" , "Clicked");
//            Gson gson = new Gson();
//            String stringBooks = gson.toJson(books);
//            editor.putString("books" , stringBooks);
//            editor.commit();
//            Toast.makeText(getApplicationContext() , " number of books" + books.size(), Toast.LENGTH_LONG).show();
//            Log.d("result" , books.size()+"");
//
//        }
//    }

    public void addBook(View view) {
            int number = Integer.parseInt(pages.getText().toString());
            boolean isChecked = switchAva.isChecked();
            Book book =  new Book(title.getText().toString() , author.getText().toString() ,number, isChecked);
        Log.d("result" ,title.getText().toString() + "  "+
                author.getText().toString() +" " +
                number + " " + isChecked);
            books.add(book);
    };

    public void saveAll(View view) {
        Log.d("result" , "Clicked");
        Gson gson = new Gson();
        String stringBooks = gson.toJson(books);
        editor.putString("books" , stringBooks);
        editor.commit();
        Toast.makeText(getApplicationContext() , " number of books" + books.size(), Toast.LENGTH_LONG).show();
        Log.d("result" , books.size()+"");
    }

}
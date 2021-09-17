package com.example.cookbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;


public class Book  extends AppCompatActivity {

    //array list for data
    ArrayList<String> listCountries = new ArrayList<>(), listRecepies = new ArrayList<>();
    ListView list_viewCountries, list_viewRecepies;
    ArrayAdapter arrayAdapterCountries, arrayAdapterRecepies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button btnShowCountries = (Button) findViewById(R.id.btnCountries);
        btnShowCountries.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listCountries.add("Indie");
                listCountries.add("Francja");
                arrayAdapterCountries.notifyDataSetChanged();
            }
        });
        /*
        List view handling For Sorting by countries
         */
        list_viewCountries = findViewById(R.id.listCountries);
        arrayAdapterCountries = new ArrayAdapter(Book.this, android.R.layout.simple_list_item_1, listCountries);
        list_viewCountries.setAdapter(arrayAdapterCountries);

        list_viewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listRecepies.add("Dahl");
                arrayAdapterRecepies.notifyDataSetChanged();
            }
        });
        /*
        List view handling For recepies
         */
        list_viewRecepies = findViewById(R.id.List);
        arrayAdapterRecepies = new ArrayAdapter(Book.this, android.R.layout.simple_list_item_1, listRecepies);
        list_viewRecepies.setAdapter(arrayAdapterRecepies);

        list_viewRecepies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Book.this, Recipe.class);
                startActivity(intent);
            }
        });

    }
}

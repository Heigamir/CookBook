package com.example.cookbook;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Recipe extends AppCompatActivity {
    //array list for data
    ArrayList<String> list = new ArrayList<>();
    ListView list_view;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        list.add("100 gram Grochu łuskanego");
        list.add("1/3 szklanki kaszy jaglanej");
        list.add("1 papryczka chili");
        /*
        List view handling For Sorting by countries
         */
        list_view = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter(Recipe.this, android.R.layout.simple_list_item_1, list);
        list_view.setAdapter(arrayAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}

package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Book  extends AppCompatActivity {

    EditText editText;
    //array list for data
    ArrayList<String> listNames = new ArrayList<>();
    ListView list_viewCountries, list_viewRecepies;
    ArrayAdapter arrayAdapterCountries, arrayAdapterRecepies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        editText = findViewById(R.id.editText);

        /*
        Button handling For Sorting by all
         */
        Button btnShowAll = (Button) findViewById(R.id.btnAll);
        btnShowAll.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Data.getListRecipe();
                listNames.clear();
                for (int i=0; i<Data.listRecipe.size(); i++)
                {
                    listNames.add(Data.listRecipe.get(i).name);
                }
                arrayAdapterRecepies.notifyDataSetChanged();
                Data.listRecipe.clear();
            }
        });

        /*
        Button handling For Sorting by countries
         */
        Button btnShowCountries = (Button) findViewById(R.id.btnCountries);
        btnShowCountries.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Data.getListCountries();
                arrayAdapterCountries.notifyDataSetChanged();
            }
        });
        /*
        List view handling For Sorting by countries
         */
        list_viewCountries = findViewById(R.id.listCountries);
        arrayAdapterCountries = new ArrayAdapter(Book.this, android.R.layout.simple_list_item_1, Data.listCountries);
        list_viewCountries.setAdapter(arrayAdapterCountries);

        list_viewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listNames.clear();
                Data.getListRecipe();
                for (int i=0; i<Data.listRecipe.size(); i++)
                {
                    if (Data.listCountries.get(position).equals(Data.listRecipe.get(i).countrie)) { listNames.add(Data.listRecipe.get(i).name);}
                }
                Data.listCountries.clear();
                arrayAdapterCountries.notifyDataSetChanged();
                arrayAdapterRecepies.notifyDataSetChanged();
                Data.listRecipe.clear();
            }
        });

        /*
        Button handling For Sorting by ingredients
         */
        Button btnShowIn = (Button) findViewById(R.id.btnIn);
        btnShowIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listNames.clear();
                Data.getListRecipe();
                for (int i=0; i<Data.listRecipe.size(); i++)
                {
                    for(int j=0; j<Data.listRecipe.get(i).ingridients.length; j++)
                    {
                        if (editText.getText().toString().trim().equals(Data.listRecipe.get(i).ingridients[j])) {
                            listNames.add(Data.listRecipe.get(i).name);
                        }
                    }
                }
                arrayAdapterRecepies.notifyDataSetChanged();
                Data.listRecipe.clear();
            }
        });


        /*
        List view handling For recepies
         */
        list_viewRecepies = findViewById(R.id.List);
        arrayAdapterRecepies = new ArrayAdapter(Book.this, android.R.layout.simple_list_item_1, listNames);
        list_viewRecepies.setAdapter(arrayAdapterRecepies);

        list_viewRecepies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data.name=listNames.get(position);
                listNames.clear();
                arrayAdapterRecepies.notifyDataSetChanged();
                Intent intent = new Intent(Book.this, RecipeLoad.class);
                startActivity(intent);
            }
        });

        Button btnNavToBack = (Button) findViewById(R.id.btnBack);
        btnNavToBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Book.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

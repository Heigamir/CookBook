package com.example.cookbook;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecipeLoad extends AppCompatActivity {
    //array list for data
    ArrayList<String> list = new ArrayList<>();
    ListView list_view;
    ArrayAdapter arrayAdapter;

    TextView title, text;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        list_view = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter(RecipeLoad.this, android.R.layout.simple_list_item_1, list);
        list_view.setAdapter(arrayAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Dodano "+list.get(position)+" do listy zakupów" ,Toast. LENGTH_SHORT).show();
                Shoping.list.add(list.get(position));
            }
        });

        title=findViewById(R.id.Name);
        text=findViewById(R.id.mainText);
        image=findViewById(R.id.mainPicture);
        Data.getListRecipe();
        for (int i=0; i<Data.listRecipe.size(); i++)
        {
            if (Data.name.equals(Data.listRecipe.get(i).name))
            {
                title.setText(Data.listRecipe.get(i).name);


                for(int j=0; j<Data.listRecipe.get(i).ingridients.length; j++)
                {
                    list.add(Data.listRecipe.get(i).ingridients[j]);
                }

                arrayAdapter.notifyDataSetChanged();

                String url = "@drawable/"+Data.name.toLowerCase().replace(" ", "");  // where myresource (without the extension) is the file

                int imageResource = getResources().getIdentifier(url, null, getPackageName());
                image.setImageResource(imageResource);

                if(Data.name=="Dahl"){
                text.setText(getString(R.string.dahl));
                }
                else{
                    if(Data.name=="Crepe"){
                        text.setText(getString(R.string.crepe));
                    }
                    else{
                        if(Data.name=="Kotlet Schabopwy"){
                            text.setText(getString(R.string.kotletschabowy));
                        }
                        else{
                            if(Data.name=="Bigos"){
                                text.setText(getString(R.string.bigos));
                            }
                        }
                        }
                }


            }


        }

        Button btnNavToBack = (Button) findViewById(R.id.btnBack);
        btnNavToBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeLoad.this, Book.class);
                startActivity(intent);
            }
        });

        Data.listRecipe.clear();
    }
}

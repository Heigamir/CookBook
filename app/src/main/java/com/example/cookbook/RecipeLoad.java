package com.example.cookbook;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

                String url = "@drawable/"+Data.name.toLowerCase();  // where myresource (without the extension) is the file

                int imageResource = getResources().getIdentifier(url, null, getPackageName());
                image.setImageResource(imageResource);

                text.setText(getString(R.string.dahl));

            }


        }



        Data.listRecipe.clear();
    }
}

package com.tomi.pokeview.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.tomi.pokeview.Data.MyAdapter;
import com.tomi.pokeview.Model.ListItem;

import com.tomi.pokeview.R;
import com.tomi.pokeview.Util.Prefs;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       listItems=new ArrayList<>();
        for(int i=0; i<10; i++)
        {

            ListItem item=new ListItem("Pokemon "+(i+1), "PokeType...");
            listItems.add(item);

            String eye = String.valueOf(i);
            String url = "https://pokeapi.co/api/v2/pokemon/"+ eye;
        }
        adapter=new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);

        Prefs prefs = new Prefs(MainActivity.this);
        String search = prefs.getSearch();

    }

}
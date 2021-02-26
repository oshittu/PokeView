package com.tomi.pokeview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

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

        String thetype;

        listItems=new ArrayList<>();
        for(int i=0; i<10; i++)
        {
            ListItem item=new ListItem("Pokemon "+(i+1), "PokeType...");
            listItems.add(item);

            String eye = String.valueOf(i);
            String url = "https://pokeapi.co/api/v2/pokemon/"+ eye;

            JsonObjectRequest jsonObjectRequest=new JsonObjectRequest("https://pokeapi.co/api/v2/pokemon/1", Request.Method.GET, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response)
                {
                    JSONArray tabTypes = null;
                    try {
                        tabTypes = response.getJSONArray("types");

                        // pokemon type
                        JSONObject jsonobj = (JSONObject) tabTypes.get(0);
                        JSONObject Typexx = (JSONObject) jsonobj.get("type");
                        String typeName = Typexx.getString("name");
                       // ab1.setText(typeName);                                // THIS LINE DOESNT WORK BUT THE "REQUEST METHOD GET" WONT WORK WITHOUT THIS LINE.

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

        }
        adapter=new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);


    }



}
package com.tomi.pokeview.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.tomi.pokeview.Model.Poke;
import com.tomi.pokeview.R;
import com.tomi.pokeview.Util.Prefs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Poke> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems=new ArrayList<>();


        Prefs prefs = new Prefs(MainActivity.this);
        String search = prefs.getSearch();


        for(int i=0; i<10; i++)
        {
            Poke item=new Poke("Pokemon "+(i+1), "PokeType...");
            listItems.add(item);

            String eye = String.valueOf(i);
            String url = "https://pokeapi.co/api/v2/pokemon/"+ eye;
        }

    }

    public List<Poke> getPokes(String searchTerm)
    {
        listItems.clear();

        String url = "https://pokeapi.co/api/v2/pokemon/1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    Poke poke = new Poke();

                    JSONArray tabTypes = response.getJSONArray("types");
                    JSONObject jsonobj = (JSONObject) tabTypes.get(0);
                    JSONObject Typexx = (JSONObject) jsonobj.get("type");
                    String typeName = Typexx.getString("name");

                    poke.setpType(typeName);

                    JSONObject species = response.getJSONObject("species");
                    String name = species.getString("name");
                    poke.setpName(name);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                VolleyLog.d("Error:", error.getMessage());
            }
        });

        return listItems;
    }

}
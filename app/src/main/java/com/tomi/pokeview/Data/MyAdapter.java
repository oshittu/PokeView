package com.tomi.pokeview.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tomi.pokeview.Model.Poke;
import com.tomi.pokeview.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<Poke> pokeList;
    public MyAdapter(android.content.Context context, List<Poke> pokes)
    {
        this.context=context;
        this.pokeList=pokes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Poke poke = pokeList.get(position);

        holder.pName.setText(poke.getpName());
        holder.pType.setText(poke.getpType());
    }

    @Override
    public int getItemCount()
    {
        return pokeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pName;
        public TextView pType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            pName=itemView.findViewById(R.id.pName);
            pType=itemView.findViewById(R.id.pType);
        }

        @Override
        public void onClick(View v)
        {

        }
    }
}

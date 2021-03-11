package com.tomi.pokeview.Data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tomi.pokeview.Activities.DetailsActivity;
import com.tomi.pokeview.Model.Poke;
import com.tomi.pokeview.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<Poke> listItems;
    public MyAdapter(android.content.Context context, List listItem)
    {
        this.context=context;
        this.listItems=Poke;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem item=listItems.get(position);

        holder.pName.setText(item.getpName());
        holder.pType.setText(item.getpType());
    }

    @Override
    public int getItemCount()
    {
        return listItems.size();
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
           /*
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("Name", item.getpName());
            intent.putExtra("Type", item.getpType());
            context.startActivity(intent);
            */
        }
    }
}

package com.sandeepysv.blooddonors;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafi on 02/06/17.
 */

public class MyAdapter {//extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

   /* private ArrayList<String> arrays;
    private ArrayList<String> places;

    public Context context;

    int count=1;

    MyAdapter(ArrayList<String> array, ArrayList<String> place) {
        this.arrays = array;
        this.places = place;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.list_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*if(count != 1) position = ((count-1)*5);
        if((arrays.size()/5)+1 == count)
        {
            holder.Name.setText(arrays.get(position));
            holder.Place.setText("-------");
            holder.BloodGroup.setText("-----");
            holder.Last.setText("---");
            holder.Phone.setText("-");
        }
        else {
            holder.Name.setText(arrays.get(position));
            holder.Place.setText(arrays.get(position + 1));
            holder.BloodGroup.setText(arrays.get(position + 2));
            holder.Last.setText(arrays.get(position + 3));
            holder.Phone.setText(arrays.get(position + 4));
            count++;
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                if(((places.size())-1) == pos) Toast.makeText(context,places.get(pos),Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent = new Intent(context, MapsActivity.class);
                    intent.putExtra("place", places.get(pos));
                    context.startActivity(intent);
                    Toast.makeText(context,places.get(pos),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrays.size()/5)+1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        public TextView Name;
        public TextView Place;
        public TextView BloodGroup;
        public TextView Last;
        public TextView Phone;
        ItemClickListener itemClickListener;

          public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            Name = (TextView)itemView.findViewById(R.id.textViewName);
            Place = (TextView)itemView.findViewById(R.id.textViewPlace);
            BloodGroup = (TextView)itemView.findViewById(R.id.textViewBlood);
            Last = (TextView)itemView.findViewById(R.id.textViewLast);
            Phone = (TextView)itemView.findViewById(R.id.textViewPh);
        }

        @Override
        public void onClick(View view) {

            this.itemClickListener.onItemClick(this.getLayoutPosition());

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {

            this.itemClickListener = itemClickListener;

        }
        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }*/
}

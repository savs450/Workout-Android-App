package com.savs.workoutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Interface.ItemClickListener;

public class Adapter extends RecyclerView.Adapter<Adapter.itemViewHolder> {
    private ItemClickListener listener;

    public Adapter(ItemClickListener listener){
        this.listener = listener;
    }
    //6.2
    private ArrayList<Mycard> mcardlist;
   //1
    public static class itemViewHolder extends RecyclerView.ViewHolder{
        //4
        public ImageView imageview;
        public TextView text;
        //2
        public itemViewHolder( View itemView ,final ItemClickListener listener) {
            super(itemView);
            //4
            imageview = itemView.findViewById(R.id.imageview);
            text = itemView.findViewById(R.id.exercise);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                        listener.onClick(v, getAdapterPosition());
                }
            });
            }


   }//6.1
    public Adapter(ArrayList<Mycard> cardlist){

        mcardlist = cardlist;
    }
    //3
    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new itemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
     Mycard currentItem =mcardlist.get(position);
     holder.imageview.setImageResource(currentItem.getmImageResource());
     holder.text.setText(currentItem.getMtext());

    }

    @Override
    public int getItemCount() {
        return mcardlist.size();
    }


}

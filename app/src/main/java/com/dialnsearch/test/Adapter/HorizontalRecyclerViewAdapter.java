package com.dialnsearch.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dialnsearch.test.Model.HorizontalModel;
import com.dialnsearch.test.R;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRVViewHolder> {

    Context context;
    ArrayList<HorizontalModel> modelArrayList;



    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel>arrayList){
            this.context=context;
            this.modelArrayList=arrayList;
    }

    @NonNull
    @Override
    public HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontel,parent,false);
        return new HorizontalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder holder, int position) {
        final HorizontalModel horizontalModel=modelArrayList.get(position);
        holder.textView.setText(horizontalModel.getNeme());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, horizontalModel.getNeme(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class HorizontalRVViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public HorizontalRVViewHolder(View itemView){
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textTitleHorizontal);
            imageView=(ImageView)itemView.findViewById(R.id.ivThumb);
        }
    }
 }

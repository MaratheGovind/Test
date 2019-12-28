package com.dialnsearch.test.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dialnsearch.test.MainActivity;
import com.dialnsearch.test.Model.WhatNew;
import com.dialnsearch.test.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WhatNewAdapter extends RecyclerView.Adapter<WhatNewAdapter.ViewHolder>{
    private Context context;
    private List<WhatNew> list;

    public WhatNewAdapter( List<WhatNew> list,Context context) {
        this.context = context;
        this.list = list;
        Log.d("Demo", "RvAdapter:"+list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.whats_new,parent,false);
        Log.d("Demo", "onCreateViewHolder:"+v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WhatNew movie = list.get(position);
        String imageUrl = movie.getImgurl();
        holder.textTitle.setText(movie.getName());
        holder.textSave.setText(String.valueOf(movie.getSave()));
        //holder.textOriginalPrice.setText(String.valueOf(movie.getOriginalprice()));
        //holder.textDiscountedPrice.setText(String.valueOf(movie.getDiscountedprice()));
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);
        Log.d("Demo", "onBindViewHolder:"+movie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textSave,textOriginalPrice,textDiscountedPrice ;
        public ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            textTitle = itemView.findViewById(R.id.main_title);
            textSave = itemView.findViewById(R.id.main_rating);
            /*textOriginalPrice = itemView.findViewById(R.id.original_price);
            textDiscountedPrice = itemView.findViewById(R.id.discounted_price);*/
            Log.d("Demo", "ViewHolder:"+itemView);
        }
    }
}

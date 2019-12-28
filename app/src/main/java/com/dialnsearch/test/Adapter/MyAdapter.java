package com.dialnsearch.test.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dialnsearch.test.Model.Data;
import com.dialnsearch.test.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Data> list_datas;
    private Context context;

    public MyAdapter(List<Data> list_datas, Context context) {
        this.list_datas = list_datas;
        this.context = context;
        Log.d("Demo", "MyAdapter:"+list_datas);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        Log.d("Demo", "onCreateViewHolder:"+view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Data listData=list_datas.get(position);
        Picasso.get()
                .load(listData.getImag_url())
                .into(holder.img);
        Log.d("Demo", "onBindViewHolder:"+listData);
    }

    @Override
    public int getItemCount() {
        return list_datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView);
            Log.d("Demo", "ViewHolder:"+itemView);
        }
    }
}

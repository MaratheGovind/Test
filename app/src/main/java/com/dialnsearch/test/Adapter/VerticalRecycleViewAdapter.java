package com.dialnsearch.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dialnsearch.test.Model.HorizontalModel;
import com.dialnsearch.test.Model.VerticalModel;
import com.dialnsearch.test.R;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class VerticalRecycleViewAdapter extends RecyclerView.Adapter<VerticalRecycleViewAdapter.VreticalRVViewJHolder> {

    Context context;
    ArrayList<VerticalModel> arrayList;

    public VerticalRecycleViewAdapter(Context context, ArrayList<VerticalModel> arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public VreticalRVViewJHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false);
        return new VreticalRVViewJHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VreticalRVViewJHolder holder, int position) {
    final VerticalModel verticalModel=arrayList.get(position);
    String title=verticalModel.getTitle();
    ArrayList<HorizontalModel> stringname=verticalModel.getArrayList();


    holder.textView.setText(title);
    HorizontalRecyclerViewAdapter horizontalRecycle=new HorizontalRecyclerViewAdapter(context,stringname);

    holder.recyclerView.setHasFixedSize(true);
    holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


    holder.recyclerView.setAdapter(horizontalRecycle);

    holder.btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, verticalModel.getTitle(), Toast.LENGTH_SHORT).show();
        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VreticalRVViewJHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView textView;
        Button btn;
        public VreticalRVViewJHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=(RecyclerView)itemView.findViewById(R.id.recyclerView1);
            textView=itemView.findViewById(R.id.textView);
            btn=itemView.findViewById(R.id.btnMore);
        }
    }
}

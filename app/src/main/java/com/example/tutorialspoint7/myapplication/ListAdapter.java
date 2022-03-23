package com.example.tutorialspoint7.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    private List<Trade> tradeList;

    public ListAdapter(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Trade trade = tradeList.get(position);
        holder.txtview1.setText(trade.getName());
        holder.txtview2.setText(String.valueOf(trade.getAskP()));
        holder.txtview3.setText(String.valueOf(trade.getLastP()));
        holder.txtview4.setText(String.valueOf(trade.getBidP()));
        holder.txtview5.setText(String.valueOf(trade.getHighP()));

    }

    @Override
    public int getItemCount() {
        return tradeList.size();
    }

    public void setData(List<Trade> tradeList){
//        this.tradeList.clear();
//        this.tradeList.addAll(tradeList);
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtview1,txtview2,txtview3,txtview4,txtview5;

        public MyViewHolder(@NonNull View itemView){

            super(itemView);
            txtview1=itemView.findViewById(R.id.textView1);
            txtview2=itemView.findViewById(R.id.textView2);
            txtview3=itemView.findViewById(R.id.textView3);
            txtview4=itemView.findViewById(R.id.textView4);
            txtview5=itemView.findViewById(R.id.textView5);

        }

    }
}

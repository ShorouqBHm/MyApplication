package com.example.tutorialspoint7.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorialspoint7.myapplication.R;
import com.example.tutorialspoint7.myapplication.domain.Trade;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TradeListAdapter extends RecyclerView.Adapter<TradeListAdapter.MyViewHolder> {

    private final List<Trade> tradeList;

    public TradeListAdapter(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Trade trade = tradeList.get(position);
        holder.title.setText(trade.getName());
        holder.askP.setText(String.valueOf(trade.getAskP()));
        holder.lastP.setText(String.valueOf(trade.getLastP()));
        holder.bidP.setText(String.valueOf(trade.getBidP()));
        holder.highP.setText(String.valueOf(trade.getHighP()));
    }

    @Override
    public int getItemCount() {
        return tradeList.size();
    }

    public void setData(List<Trade> tradeList) {

        notifyDataSetChanged();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.askP)
        TextView askP;
        @BindView(R.id.lastP)
        TextView lastP;
        @BindView(R.id.bidP)
        TextView bidP;
        @BindView(R.id.highP)
        TextView highP;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);


            ButterKnife.bind(this, itemView);

        }

    }
}

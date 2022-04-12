package com.example.tutorialspoint7.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MarketWatchFragment extends Fragment {

    @BindView(R.id.rec) RecyclerView tradeRecyclerView;
    private List<Trade>tradeList=new ArrayList<>();
    private TradeListAdapter tradeListAdapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        jsonParse();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.marketwatch, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        tradeRecyclerView.setLayoutManager(horizontalLayoutManager);
        tradeListAdapter = new TradeListAdapter(tradeList);
        tradeRecyclerView.setAdapter(tradeListAdapter);
        return view;

    }


    public void jsonParse() {

        String url="https://tickerchart.com/interview/marketwatch.json";


        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    for(int i=0;i<response.length();i++){
                        Trade trade = new Trade();
                        JSONObject members=response.getJSONObject(i);
                        String fName=members.getString("name");
                        double askPrice= members.getDouble("ask-price");
                        double lastPrice=members.getDouble("last-price");
                        double bidPrice=members.getDouble("bid-price");
                        double highPrice=members.getDouble("high-price");
                        trade.setName(fName);trade.setAskP(askPrice);trade.setLastP(lastPrice);trade.setBidP(bidPrice);trade.setHighP(highPrice);
                        tradeList.add(trade);

                    }
                   tradeListAdapter.setData(tradeList);
                } catch (JSONException e) {
                    System.err.println(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.err.println(error.getMessage());
            }
        });

        VolleySingleton.getInstance(getContext()).addRequest(request);
    }


}

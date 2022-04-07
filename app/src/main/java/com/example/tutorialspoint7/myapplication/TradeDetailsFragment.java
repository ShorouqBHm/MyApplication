package com.example.tutorialspoint7.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TradeDetailsFragment extends Fragment {

    @BindView(R.id.title2) TextView tradeDetailsTitleTxt;
    @BindView(R.id.symbol) TextView symbolTxt;
    @BindView(R.id.tradescount) TextView tradesCountTxt;
    @BindView(R.id.high) TextView highTxt;
    @BindView(R.id.low) TextView lowTxt;
    @BindView(R.id.volume) TextView volumeTxt;
    @BindView(R.id.amount) TextView amountTxt;

    @Override
    public void onStart() {
        super.onStart();
        jsonParse();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tradedetails, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void jsonParse() {

        String url="https://tickerchart.com/interview/company-details.json";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()  {
            @Override
            public void onResponse(JSONObject response) {


                try {

                    GeneralIndex generalIndex = new GeneralIndex();
                    Company company=new Company();
                    String name=response.getString("company-name");
                    String symbol= response.getString("symbol");
                    String tradesCount=response.getString("trades-count");
                    String high=response.getString("high");
                    String low=response.getString("low");
                    String volume=response.getString("volume");
                    String amount=response.getString("amount");


//                    generalIndex.setName(name);generalIndex.setTrades(trades);generalIndex.setVolume(volume);generalIndex.setAmount(amount);
//                    generalIndex.setCompany(company);

                  //  generalIndexList.add(generalIndex);
                    tradeDetailsTitleTxt.setText(name);symbolTxt.setText(symbol);tradesCountTxt.setText(tradesCount);highTxt.setText((high));lowTxt.setText(low);volumeTxt.setText(volume);amountTxt.setText(amount);

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

        Singleton.getInstance(getContext()).addRequest(request);
    }

}

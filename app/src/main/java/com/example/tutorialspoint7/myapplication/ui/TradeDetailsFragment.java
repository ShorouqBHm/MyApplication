package com.example.tutorialspoint7.myapplication.ui;

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
import com.example.tutorialspoint7.myapplication.R;
import com.example.tutorialspoint7.myapplication.network.VolleySingleton;
import com.example.tutorialspoint7.myapplication.domain.TradeDetails;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TradeDetailsFragment extends Fragment {

    @BindView(R.id.title)
    TextView tradeDetailsTitleTxt;
    @BindView(R.id.symbol)
    TextView symbolTxt;
    @BindView(R.id.tradescount)
    TextView tradesCountTxt;
    @BindView(R.id.high)
    TextView highTxt;
    @BindView(R.id.low)
    TextView lowTxt;
    @BindView(R.id.volume)
    TextView volumeTxt;
    @BindView(R.id.amount)
    TextView amountTxt;

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

        String url = "https://tickerchart.com/interview/company-details.json";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {

                    TradeDetails tradeDetails = new TradeDetails();
                    String name = response.getString("company-name");
                    String symbol = response.getString("symbol");
                    String tradesCount = response.getString("trades-count");
                    String high = response.getString("high");
                    String low = response.getString("low");
                    String volume = response.getString("volume");
                    String amount = response.getString("amount");

                    tradeDetails.setName(name);
                    tradeDetails.setSymbol(symbol);
                    tradeDetails.setTradesCount(tradesCount);
                    tradeDetails.setHigh(high);
                    tradeDetails.setLow(low);
                    tradeDetails.setVolume(volume);
                    tradeDetails.setAmount(amount);

                    viewData(tradeDetails);


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

    private void viewData(TradeDetails tradeDetails) {
        tradeDetailsTitleTxt.setText(tradeDetails.getName());
        symbolTxt.setText(tradeDetails.getSymbol());
        tradesCountTxt.setText(tradeDetails.getTradesCount());
        highTxt.setText((tradeDetails.getHigh()));
        lowTxt.setText(tradeDetails.getLow());
        volumeTxt.setText(tradeDetails.getVolume());
        amountTxt.setText(tradeDetails.getAmount());
    }
}

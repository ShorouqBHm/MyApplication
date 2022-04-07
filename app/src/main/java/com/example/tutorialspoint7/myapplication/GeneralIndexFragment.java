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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GeneralIndexFragment extends Fragment {

    private List<GeneralIndex> generalIndexList=new ArrayList<>();

    @BindView(R.id.title) TextView tradeTitleTxt;
    @BindView(R.id.trade)  TextView tradeTxt;
    @BindView(R.id.amount) TextView amountTxt;
    @BindView(R.id.volume)  TextView  volumeTxt;
    @BindView(R.id.winning) TextView winning_txt;
    @BindView(R.id.fixed)  TextView fixedTxt;
    @BindView(R.id.losing)  TextView losingTxt;
    private Unbinder unbinder;

    @Override
    public void onStart() {
        super.onStart();
        jsonParse();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.generalindex, container, false);
        unbinder=  ButterKnife.bind(this, view);//findviewbyId
        return view;
    }


    public void jsonParse() {

        String url="https://tickerchart.com/interview/general-index.json";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()  {
            @Override
            public void onResponse(JSONObject response) {


                try {

                        GeneralIndex generalIndex = new GeneralIndex();
                        Company company=new Company();
                        String name=response.getString("name");
                        String trades= response.getString("trades");
                        String volume=response.getString("volume");
                        String amount=response.getString("amount");

                        JSONObject companiesObject=response.getJSONObject("companies");

                        String winning=companiesObject.getString("winning");
                        String fixed=companiesObject.getString("fixed");
                        String losing=companiesObject.getString("losing");


                    company.setWinning(winning);company.setFixed(fixed);company.setLosing(losing);
                    generalIndex.setName(name);generalIndex.setTrades(trades);generalIndex.setVolume(volume);generalIndex.setAmount(amount);
                    generalIndex.setCompany(company);

                    generalIndexList.add(generalIndex);
                    tradeTitleTxt.setText(name);tradeTxt.setText(trades);amountTxt.setText(amount);volumeTxt.setText((volume));winning_txt.setText(winning);fixedTxt.setText(fixed);losingTxt.setText(losing);

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
    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

}

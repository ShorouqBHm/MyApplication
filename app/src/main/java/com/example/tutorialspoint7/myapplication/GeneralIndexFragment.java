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

public class GeneralIndexFragment extends Fragment {


    private TextView textView;
    private List<GeneralIndex> generalIndexList=new ArrayList<>();

    @Override
    public void onStart() {
        super.onStart();
        jsonParse();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.generalindex, container, false);
        textView=view.findViewById(R.id.textView9);
        return view;
    }


    public void jsonParse() {

        String url="http://tickerchart.com/interview/general-index.json";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()  {
            @Override
            public void onResponse(JSONObject response) {


                try {

                        GeneralIndex generalIndex = new GeneralIndex();
                        Company company=new Company();
                        String name=response.getString("name");
                        double trades= response.getDouble("trades");
                        double volume=response.getDouble("volume");
                        double amount=response.getDouble("amount");

                        JSONObject companiesObject=response.getJSONObject("companies");

                        double winning=companiesObject.getDouble("winning");
                        double fixed=companiesObject.getDouble("fixed");
                        double losing=companiesObject.getDouble("losing");


                    company.setWinning(winning);company.setFixed(fixed);company.setLosing(losing);
                    generalIndex.setName(name);generalIndex.setTrades(trades);generalIndex.setVolume(volume);generalIndex.setAmount(amount);
                    generalIndex.setCompany(company);

                    generalIndexList.add(generalIndex);



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

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tutorialspoint7.myapplication.R;
import com.example.tutorialspoint7.myapplication.network.VolleySingleton;
import com.example.tutorialspoint7.myapplication.domain.Company;
import com.example.tutorialspoint7.myapplication.domain.GeneralIndex;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GeneralIndexFragment extends Fragment {


    @BindView(R.id.title)
    TextView tradeTitleTxt;
    @BindView(R.id.trade)
    TextView tradeTxt;
    @BindView(R.id.amount)
    TextView amountTxt;
    @BindView(R.id.volume)
    TextView volumeTxt;
    @BindView(R.id.winning)
    TextView winning_txt;
    @BindView(R.id.fixed)
    TextView fixedTxt;
    @BindView(R.id.losing)
    TextView losingTxt;
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
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    public void jsonParse() {

        String url = "https://tickerchart.com/interview/general-index.json";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {


            try {

                GeneralIndex generalIndex = new GeneralIndex();
                Company company = new Company();
                String title = response.getString("name");
                String trades = response.getString("trades");
                String volume = response.getString("volume");
                String amount = response.getString("amount");

                JSONObject companiesObject = response.getJSONObject("companies");

                String winning = companiesObject.getString("winning");
                String fixed = companiesObject.getString("fixed");
                String losing = companiesObject.getString("losing");


                company.setWinning(winning);
                company.setFixed(fixed);
                company.setLosing(losing);
                generalIndex.setName(title);
                generalIndex.setTrades(trades);
                generalIndex.setVolume(volume);
                generalIndex.setAmount(amount);
                generalIndex.setCompany(company);


                viewData(generalIndex);


            } catch (JSONException e) {
                System.err.println(e.getMessage());

            }
        }, error -> System.err.println(error.getMessage()));

        VolleySingleton.getInstance(getContext()).addRequest(request);
    }


    private void viewData(GeneralIndex generalIndex) {
        tradeTitleTxt.setText(generalIndex.getName());
        tradeTxt.setText(generalIndex.getTrades());
        amountTxt.setText(generalIndex.getAmount());
        volumeTxt.setText((generalIndex.getVolume()));
        winning_txt.setText(generalIndex.getCompany().getWinning());
        fixedTxt.setText(generalIndex.getCompany().getFixed());
        losingTxt.setText(generalIndex.getCompany().getLosing());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

}

package com.example.tutorialspoint7.myapplication;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton mInstance;
    private static RequestQueue mQueue;

    private VolleySingleton() {

    }

    public static synchronized VolleySingleton getInstance(Context context) {
        mQueue = Volley.newRequestQueue(context);
        if (mInstance == null) {
            mInstance = new VolleySingleton();
        }

        return mInstance;
    }


    public void addRequest(JsonArrayRequest request) {
        mQueue.add(request);
    }

    public void addRequest(JsonObjectRequest request) {
        mQueue.add(request);
    }
}

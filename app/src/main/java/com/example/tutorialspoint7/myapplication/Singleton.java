package com.example.tutorialspoint7.myapplication;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class Singleton extends AppCompatActivity {

    private static Singleton mInstance;
    private static RequestQueue mQueue;

    private Singleton() {

    }

    public static synchronized Singleton getInstance(Context context) {
        mQueue = Volley.newRequestQueue(context);
        if (mInstance == null) {
            mInstance = new Singleton();
        }

        return mInstance;
    }


    public void addRequest(JsonArrayRequest request){
        mQueue.add(request);
    }
    public void addRequest(JsonObjectRequest request){
        mQueue.add(request);
    }
}

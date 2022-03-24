package com.example.tutorialspoint7.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportFragmentManager().beginTransaction().add(R.id.Act1, new GeneralIndexFragment()).addToBackStack("asd").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.Act1, new MarketWatchFragment()).addToBackStack("asd").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.Act1, new TradeDetailsFragment()).addToBackStack("asd").commit();


//                Toast.makeText(getApplication(),"Shorouq",Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(MainActivity.this, MyApplication.class);
//                startActivity(intent);


    }}

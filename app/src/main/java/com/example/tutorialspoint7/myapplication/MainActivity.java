package com.example.tutorialspoint7.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Gravity;
import android.view.Menu;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    private AppBarConfiguration mAppBarConfiguration;
    Switch aswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_MyApplicationDark);
        } else
            setTheme(R.style.Theme_MyApplicationLight);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        aswitch = findViewById(R.id.switchh);
//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            aswitch.setChecked(true);
//        }
//
//        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    reset();
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    reset();
//                }
//            }
//        });

        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer);



        navigationView.setNavigationItemSelectedListener(item -> {
            Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();
            switch (item.getItemId()) {
                case R.id.nav_Language:
                    Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();
                    break;
                case R.id.nav_theme: {
                    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                        item.setChecked(true);
                    }
//                    item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                            if (isChecked) {
//                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                                reset();
//                            } else {
//                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                                reset();
//                            }
//                        }
//                    });

                    Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();
                    break;
                }
            }

            drawerLayout.closeDrawers();

            return true;
        });

//         drawer layout instance to toggle the menu icon to open
//         drawer and back button to close drawer


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        //  navigationView.bringToFront();
//        drawerLayout.closeDrawers();
//        drawerLayout.requestLayout();
//        drawerLayout.bringToFront();

//              // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().add(R.id.general_index_container, new GeneralIndexFragment()).addToBackStack("asd").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.MarketWatch_contanier, new MarketWatchFragment()).addToBackStack("asd").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.TradeDetails_contanier, new TradeDetailsFragment()).addToBackStack("asd").commit();

    }
//                Toast.makeText(getApplication(),"Shorouq",Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(MainActivity.this, MyApplication.class);
//                startActivity(intent);

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void reset(){

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

}

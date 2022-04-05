package com.example.tutorialspoint7.myapplication;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.content.res.Resources;

import android.content.Intent;

import android.os.Bundle;

import android.text.Html;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;


import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_MyApplicationDark);
          getSupportActionBar().setTitle(Html.fromHtml("" + getString(R.string.app_name) + " </font>"));

        } else {
            setTheme(R.style.Theme_MyApplicationLight);
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>" + getString(R.string.app_name) + " </font>"));

        }



        getString(R.string.app_name);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      //  getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>"+ getString(R.string.app_name)+" </font>"));

        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer);


       // setLocale(this, "ar");
      //  setLocale(this, "en");

        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {


                case R.id.nav_Language:
                {


                    if(Locale.getDefault().getLanguage().equals("ar"))
                    {
                        // Locale.setDefault();
                        setLocale(this, "en");
                        reset();

                    }
                    else if (Locale.getDefault().getLanguage().equals("en")) {

                      setLocale(this, "ar");
                      reset();

                     }
                    break;

                }


                case R.id.nav_theme: {
                    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


                        reset();
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        reset();

                    }
                    drawerLayout.closeDrawers();
                    break;

                }
            }

            return true;
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().add(R.id.general_index_container, new GeneralIndexFragment()).addToBackStack("asd").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.MarketWatch_contanier, new MarketWatchFragment()).addToBackStack("asd").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.TradeDetails_contanier, new TradeDetailsFragment()).addToBackStack("asd").commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void reset() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent); finish();

    }

    public static void setLocale(Activity activity, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}
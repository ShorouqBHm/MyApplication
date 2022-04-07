package com.example.tutorialspoint7.myapplication;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.Resources;

import android.content.Intent;

import android.os.Bundle;

import android.text.Html;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import java.util.Locale;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_drawer) NavigationView navigationView;

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
      //  getString(R.string.app_name);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           ButterKnife.bind(this);
      //  getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>"+ getString(R.string.app_name)+" </font>"));

        navigationView.setNavigationItemSelectedListener(item -> {

     switch (item.getItemId()) {
//                case R.id.nav_Language: {
//
//             if(Locale.getDefault().getLanguage().equals("en"))
//
//             {
//                 setLocale(this,"ar");
//                    reset();
//             }
//                else
//                    {
//
//                        setLocale(this,"en");
//                        reset();
//                    }
////
//                  break;
//         }



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
    @OnTouch(R.id.navigation_drawer)
    void buttonClick(){
        Toast.makeText(this,"This is aToast msg",Toast.LENGTH_LONG).show();
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
        startActivity(intent);
        finish();

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
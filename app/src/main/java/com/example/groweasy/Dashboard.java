package com.example.groweasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.example.groweasy.R;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    Button btnImgBack;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        /*--------------------Hooks-------------------------*/
        drawerLayout = findViewById(R.id.dlPrincipal);
        navigationView = findViewById(R.id.nvMenuLateral);
        toolbar = findViewById(R.id.tbPrincipal);

        /*-------------------Tool Bar ---------------------*/
        setSupportActionBar(toolbar);

        /*------------------Navigation Drawer Menu --------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        btnImgBack = (Button) findViewById(R.id.imgLogoMenu);
        btnImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Dashboard.this, VistaPrincipal.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectedItemNav(item);
        return true;
    }

    private void selectedItemNav(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(Dashboard.this, VistaPrincipal.class);
                startActivity(intent);
                break;

            case R.id.generarReporte:
                Intent intent2 = new Intent(Dashboard.this, Inicio.class);
                startActivity(intent2);
                break;
        }
    }


}

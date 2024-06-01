package com.example.groweasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VistaPrincipal extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private DatabaseReference groweasydb;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button btnImgMenu, btnHumedad;
    TextView txthumedad, txtsuelo, txtluz, txtambiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal);

        /* ---------------------------MENÚ LATERAL DE NAVEGACIÓN -------------------------------------------*/
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

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Dashboard2Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        /* --------------------------FIN VARIABLES MENÚ LATERAL NAVEGACIÓN --------------------------------*/

/*
        btnHumedad = (Button) findViewById(R.id.btnDashboardHumedad);
        txthumedad= (TextView) findViewById(R.id.txtVariableHumedad);
        txtluz= (TextView) findViewById(R.id.txtVariableLuz);
        txtambiente= (TextView) findViewById(R.id.txtVariableAmbiente);
        txtsuelo= (TextView) findViewById(R.id.txtVariableSuelo);

        /* -------------------------- INSTANCIAR BASE DE DATOS -------------------------------------*/
  /*      groweasydb= FirebaseDatabase.getInstance().getReference();


        /*-------------------- Obtener los valores desde la base de datos de Firebase --------------*/
    /*    groweasydb.child("Humedad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String humedad = dataSnapshot.child("humedad").getValue().toString();
                    txthumedad.setText(humedad + " %");
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        groweasydb.child("Luz").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String luz = dataSnapshot.child("luz").getValue().toString();
                    txtluz.setText(luz);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        groweasydb.child("T_ambiente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String t_ambiente = dataSnapshot.child("t_ambiente").getValue().toString();
                    txtambiente.setText(t_ambiente + " °C");
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        groweasydb.child("T_suelo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String t_suelo = dataSnapshot.child("t_suelo").getValue().toString();
                    txtsuelo.setText(t_suelo + " °C");
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*----------------------------------------- FIN ---------------------------------------------*/
      /*  btnHumedad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(VistaPrincipal.this, Dashboard.class);
                startActivity(intent);
            }
        });
*/    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuPrincipalFragment()).commit();
                break;
            case R.id.generarReporte:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Dashboard2Fragment()).commit();
                break;

            case R.id.SoporteTecnico:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Test()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

}

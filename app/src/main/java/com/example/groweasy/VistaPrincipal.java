package com.example.groweasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VistaPrincipal extends AppCompatActivity {

    private DatabaseReference groweasydb;
    Button btnImgMenu, btnHumedad;
    TextView txthumedad, txtsuelo, txtluz, txtambiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal);
        /*btnImgMenu = (Button) findViewById(R.id.imgLogoMenu);
        btnHumedad = (Button) findViewById(R.id.btnHumedad);

        txthumedad= (TextView) findViewById(R.id.txthumedad);
        txtluz= (TextView) findViewById(R.id.txtluz);
        txtambiente= (TextView) findViewById(R.id.txtambiente);
        txtsuelo= (TextView) findViewById(R.id.txtsuelo);
        groweasydb= FirebaseDatabase.getInstance().getReference();

        groweasydb.child("Humedad").addValueEventListener(new ValueEventListener() {
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

        btnImgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(VistaPrincipal.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnHumedad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(VistaPrincipal.this, Dashboard.class);
                startActivity(intent);
            }
        });*/
    }

}

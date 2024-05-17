package com.example.groweasy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuTrabajador extends AppCompatActivity {

    private DatabaseReference prueba1;
    Button btnImgMenu, btnHumedad;
    TextView txthumedad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_1);
        btnImgMenu = (Button) findViewById(R.id.imgLogoMenu);
        btnHumedad = (Button) findViewById(R.id.btnHumedad);

        txthumedad= (TextView) findViewById(R.id.textView3);
        prueba1= FirebaseDatabase.getInstance().getReference();

        prueba1.child("Persona").addValueEventListener(new ValueEventListener() {
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

        btnImgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MenuTrabajador.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnHumedad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MenuTrabajador.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

}

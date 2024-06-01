package com.example.groweasy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuPrincipalFragment extends Fragment {
    private DatabaseReference groweasydb;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button btnImgMenu, btnHumedad;
    TextView txthumedad, txtsuelo, txtluz, txtambiente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_principal, container, false);

        // Inicializar los TextViews
        txthumedad = view.findViewById(R.id.txtVariableHumedad);
        txtluz = view.findViewById(R.id.txtVariableLuz);
        txtambiente = view.findViewById(R.id.txtVariableAmbiente);
        txtsuelo = view.findViewById(R.id.txtVariableSuelo);

        // Instanciar la base de datos de Firebase
        groweasydb = FirebaseDatabase.getInstance().getReference();

        // Obtener los valores desde la base de datos de Firebase
        obtenerDatosDesdeFirebase();

        return view;
    }

    private void obtenerDatosDesdeFirebase() {
        // Escuchar cambios en la humedad
        groweasydb.child("Humedad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.child("humedad").getValue() != null) {
                    String humedad = dataSnapshot.child("humedad").getValue().toString();
                    txthumedad.setText(humedad + " %");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar el error
            }
        });

        // Escuchar cambios en la luz
        groweasydb.child("Luz").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.child("luz").getValue() != null) {
                    String luz = dataSnapshot.child("luz").getValue().toString();
                    txtluz.setText(luz);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar el error
            }
        });

        // Escuchar cambios en la temperatura ambiente
        groweasydb.child("T_ambiente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.child("t_ambiente").getValue() != null) {
                    String t_ambiente = dataSnapshot.child("t_ambiente").getValue().toString();
                    txtambiente.setText(t_ambiente + " °C");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar el error
            }
        });

        // Escuchar cambios en la temperatura del suelo
        groweasydb.child("T_suelo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.child("t_suelo").getValue() != null) {
                    String t_suelo = dataSnapshot.child("t_suelo").getValue().toString();
                    txtsuelo.setText(t_suelo + " °C");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar el error
            }
        });
    }
}

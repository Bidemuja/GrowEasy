package com.example.groweasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuTrabajador extends AppCompatActivity {

    Button btnImgMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_1);
        btnImgMenu = (Button) findViewById(R.id.imgLogoMenu);
        btnImgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MenuTrabajador.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

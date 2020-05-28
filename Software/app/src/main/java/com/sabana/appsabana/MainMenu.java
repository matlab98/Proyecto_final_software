package com.sabana.appsabana;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sabana.appsabana.modelos.User;

public class MainMenu extends AppCompatActivity {
   private Button salirlogin;
   private Button Buses;
   private Button Trense;

   private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        init();
    }


    private void init() {
        Trense = findViewById(R.id.tren);
        Trense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this , TrenesGeneral.class));
            }
        });


        Buses= findViewById(R.id.bus);
        Buses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Busqueda_Buses.class));
            }
        });

        salirlogin = findViewById(R.id.salirlogin);
        salirlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, MainActivity.class));
            }
        });

        user = (User) getIntent().getSerializableExtra("User");
    }
}

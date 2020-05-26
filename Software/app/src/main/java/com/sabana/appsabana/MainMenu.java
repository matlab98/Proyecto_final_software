package com.sabana.appsabana;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainMenu extends AppCompatActivity {
   Button salirlogin;
   Button Buses;
   Button Tren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Tren= (Button)findViewById(R.id.tren);
        Tren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, BusesGeneral.class));
            }
        });


        Buses=(Button)findViewById(R.id.bus);
        Buses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Busqueda_Buses.class));
            }
        });

        salirlogin = (Button) findViewById(R.id.salirlogin);
        salirlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, MainActivity.class));
            }
        });
    }
}

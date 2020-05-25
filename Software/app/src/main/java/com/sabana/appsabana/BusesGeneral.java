package com.sabana.appsabana;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BusesGeneral extends AppCompatActivity {
    Button buscar;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_general);

        regresar=(Button) findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusesGeneral.this , MainMenu.class));
            }
        });

        buscar = (Button) findViewById(R.id.Buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusesGeneral.this , Busqueda_Buses.class));
            }
        });
    }
}

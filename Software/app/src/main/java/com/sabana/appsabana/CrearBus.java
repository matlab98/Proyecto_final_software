package com.sabana.appsabana;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CrearBus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button Regresar;
    Button Buscar;
    Button General;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bus);


        Spinner spinner =findViewById(R.id.spinnerDestino);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Destinos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 =findViewById(R.id.spinnerAsiento);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.NumeroAsiento, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 =findViewById(R.id.spinnerMarca);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this, R.array.Marca, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        General = (Button) findViewById(R.id.General);
        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearBus.this , BusesGeneral.class));
            }
        });

        Buscar = (Button) findViewById(R.id.Buscar);
        Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearBus.this , Busqueda_Buses.class));
            }
        });

        Regresar = (Button) findViewById(R.id.regresar);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearBus.this , MainMenu.class));
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

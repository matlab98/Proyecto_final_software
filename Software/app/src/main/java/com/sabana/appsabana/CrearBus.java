package com.sabana.appsabana;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.sabana.appsabana.modelos.Bus;
import com.sabana.appsabana.modelos.Train;
import com.sabana.appsabana.servicios.APIService;
import com.sabana.appsabana.servicios.APIUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrearBus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button Buscar;
    private Button General;
    private Button crearBus;

    private Spinner spinnerDestino;
    private Spinner spinnerAsiento;
    private Spinner spinnerMarca;

    private EditText editTextConductor;
    private EditText editTextPlaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bus);

        init();
    }

    private void init() {
        spinnerDestino = findViewById(R.id.spinnerDestino);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Destinos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestino.setAdapter(adapter);
        spinnerDestino.setOnItemSelectedListener(this);

        spinnerAsiento =findViewById(R.id.spinnerAsiento);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.NumeroAsiento, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAsiento.setAdapter(adapter2);
        spinnerAsiento.setOnItemSelectedListener(this);

        spinnerMarca = findViewById(R.id.spinnerMarca);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this, R.array.Marca, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMarca.setAdapter(adapter3);
        spinnerMarca.setOnItemSelectedListener(this);

        General = findViewById(R.id.General);
        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearBus.this , BusesGeneral.class));
            }
        });

        Buscar = findViewById(R.id.Buscar);
        Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearBus.this , Busqueda_Buses.class));
            }
        });

        crearBus = findViewById(R.id.crear_bus);
        crearBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        editTextConductor = findViewById(R.id.nombre_conductor);
        editTextPlaca = findViewById(R.id.placa);

    }

    private void sendData() {
        String placa = editTextPlaca.getText().toString();
        String seat = spinnerAsiento.getSelectedItem().toString();
        String reference = spinnerMarca.getSelectedItem().toString();
        String conductor = editTextConductor.getText().toString();
        String destino = spinnerDestino.getSelectedItem().toString();


        APIService service = APIUtils.getAPIService();

        Map<String, String> params = new HashMap();

        final String token = "abc";

        params.put("placa", placa);
        params.put("seat", seat);
        params.put("reference", reference);
        params.put("key", token);
        params.put("conductor", conductor);
        params.put("destino", destino);

        Call<Bus> call = service.createBus(params);

        call.enqueue(new Callback<Bus>() {
            @Override
            public void onResponse(Call<Bus> call, Response<Bus> response) {
                final AlertDialog alertDialog = new AlertDialog.Builder(CrearBus.this)
                        .setTitle("Exito")
                        .setMessage("Se ha creado exitosamente el bus!")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(CrearBus.this, BusesGeneral.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        })
                        .create();

                alertDialog.show();
            }

            @Override
            public void onFailure(Call<Bus> call, Throwable t) {
                Toast.makeText(CrearBus.this, "No se pudo crear el bus!", Toast.LENGTH_SHORT).show();
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

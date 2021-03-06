package com.sabana.appsabana;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.sabana.appsabana.modelos.Train;
import com.sabana.appsabana.modelos.User;
import com.sabana.appsabana.servicios.APIService;
import com.sabana.appsabana.servicios.APIUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrearTren extends AppCompatActivity  {

    private Button General;
    private Button send;

    private Spinner spinnerDestino;
    private Spinner spinnerReferencia;
    private Spinner spinnerAsiento;

    private EditText editTextDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tren);

        init();

    }

    private void init() {
        spinnerDestino =findViewById(R.id.spinnerDestino);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.DestinosTren, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestino.setAdapter(adapter);


        spinnerReferencia = findViewById(R.id.spinnerReferencia);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.MarcaTren, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReferencia.setAdapter(adapter2);

        spinnerAsiento = findViewById(R.id.spinnerAsiento);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this, R.array.NumeroAsientoTren, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAsiento.setAdapter(adapter3);

        General = findViewById(R.id.General);
        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearTren.this, TrenesGeneral.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        send = findViewById(R.id.crear_tren);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        editTextDriver = findViewById(R.id.nombre_conductor);
    }

    private void sendData() {
        String seats = spinnerAsiento.getSelectedItem().toString();
        String reference = spinnerReferencia.getSelectedItem().toString();
        String destination = spinnerDestino.getSelectedItem().toString();
        String driver = editTextDriver.getText().toString();

        APIService service = APIUtils.getAPIService();

        Map<String, String> params = new HashMap();

        final String token = getApplicationContext().getSharedPreferences(getResources().getString(R.string.preferences ), 0).getString(getResources().getString(R.string.token), "");

        params.put("key", token);
        params.put("seat", seats);
        params.put("reference", reference);
        params.put("conductor", driver);
        params.put("destino", destination);

        Call<Train> call = service.createTrain(params);

        call.enqueue(new Callback<Train>() {
            @Override
            public void onResponse(Call<Train> call, Response<Train> response) {
                final AlertDialog alertDialog = new AlertDialog.Builder(CrearTren.this)
                        .setTitle("Exito")
                        .setMessage("Se ha creado exitosamente el tren!")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startActivity(new Intent(CrearTren.this, TrenesGeneral.class));
                            }
                        })
                        .create();

                alertDialog.show();
            }

            @Override
            public void onFailure(Call<Train> call, Throwable t) {
                Toast.makeText(CrearTren.this, "No se pudo crear el tren!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

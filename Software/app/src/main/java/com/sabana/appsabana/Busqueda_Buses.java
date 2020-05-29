package com.sabana.appsabana;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Busqueda_Buses extends AppCompatActivity {
    TextView mTimeView;
    Button MpickTime;
    Context mContext=this;
    Button general;
    Button Crear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda__buses);

        Crear = (Button) findViewById(R.id.Crear);
        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Busqueda_Buses.this , CrearBus.class));
            }
        });

        general =(Button) findViewById(R.id.General);
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Busqueda_Buses.this,BusesGeneral.class));
            }
        });

        Spinner spinner =findViewById(R.id.spinnerBus);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Destinos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        mTimeView =(TextView) findViewById(R.id.VistaHora);
        Calendar calendar= Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        MpickTime =(Button) findViewById(R.id.Tiempo);
        MpickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mTimeView.setText(hourOfDay+ ":" + minute);
                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();
            }
        });

    }

}

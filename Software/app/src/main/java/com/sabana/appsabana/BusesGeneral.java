package com.sabana.appsabana;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sabana.appsabana.modelos.Bus;
import com.sabana.appsabana.modelos.Train;
import com.sabana.appsabana.servicios.APIService;
import com.sabana.appsabana.servicios.APIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusesGeneral extends AppCompatActivity {
    Button buscar;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    Button Crear;

    final ArrayList<Model> models = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_general);


        mRecyclerView=findViewById(R.id.recycleBus);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new MyAdapter(this, models);
        mRecyclerView.setAdapter(myAdapter);

        Crear= findViewById(R.id.Crear);
        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusesGeneral.this , CrearBus.class));
            }
        });

        buscar = findViewById(R.id.Buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusesGeneral.this , Busqueda_Buses.class));
            }
        });

        fillList();
    }

    private void fillList(){


        APIService service = APIUtils.getAPIService();

        Map<String, String> params = new HashMap();

        final String token = getApplicationContext().getSharedPreferences(getResources().getString(R.string.preferences ), 0).getString(getResources().getString(R.string.token), "");

        params.put("key", token);
        params.put("route", "");

        Call<List<Bus>> call = service.getBuses(params);

        call.enqueue(new Callback<List<Bus>>() {
            @Override
            public void onResponse(Call<List<Bus>> call, Response<List<Bus>> response) {

                //shows only the last three buses
                int k = 4;
                for (int i = response.body().size() - 1; i >=0 && k >= 0 ;--i, --k) {
                    Bus bus = response.body().get(i);
                    Model m = new Model();
                    m.setTitle("Placa: " + bus.getPlate());
                    m.setDescription("Asientos: " + bus.getSeats());
                    m.setImg(R.drawable.bus1);
                    myAdapter.models.add(m);
                }
                myAdapter.notifyItemRangeInserted(0, 5 - k);
            }

            @Override
            public void onFailure(Call<List<Bus>> call, Throwable t) {
                final AlertDialog alertDialog = new AlertDialog.Builder(BusesGeneral.this)
                        .setTitle("Error!")
                        .setMessage("No se pudo recuperar la informacion de los buses!")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(BusesGeneral.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        })
                        .create();

                alertDialog.show();
            }
        });
    }
}

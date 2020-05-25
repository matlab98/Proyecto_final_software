package com.sabana.appsabana;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusesGeneral extends AppCompatActivity {
    Button buscar;
    Button regresar;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_general);


        mRecyclerView=findViewById(R.id.recycleBus);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);


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

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();
        m.setTitle("Destino: Portal 170");
        m.setDescription("Valor: $3.200");
        m.setImg(R.drawable.bus1);
        models.add(m);


        m.setTitle("Destino: Mazuren");
        m.setDescription("Valor: $3.500");
        m.setImg(R.drawable.bus2);
        models.add(m);


        m.setTitle("Destino: Estación 127");
        m.setDescription("Valor: $3.600");
        m.setImg(R.drawable.bus2);
        models.add(m);


        m.setTitle("Destino: Heroes");
        m.setDescription("Valor: $3.800");
        m.setImg(R.drawable.bus1);
        models.add(m);

        return models;
    }
}

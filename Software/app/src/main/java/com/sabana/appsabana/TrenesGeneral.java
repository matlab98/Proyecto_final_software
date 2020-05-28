package com.sabana.appsabana;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrenesGeneral extends AppCompatActivity {
    Button regresar;
    Button Crear;
    RecyclerView mRecyclerViewT;
    MyAdapterT myAdapterT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trenes_general);

        Crear = (Button) findViewById(R.id.Crear);
        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrenesGeneral.this , CrearTren.class));
            }
        });

        mRecyclerViewT=findViewById(R.id.recycleTren);
        mRecyclerViewT.setLayoutManager(new LinearLayoutManager(this));
        myAdapterT= new MyAdapterT(this, getMyListl());
        mRecyclerViewT.setAdapter(myAdapterT);

        regresar =(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrenesGeneral.this , MainMenu.class ));
            }
        });

    }

    private ArrayList<Modelt> getMyListl(){
        ArrayList<Modelt> modelst = new ArrayList<>();
        Modelt m = new Modelt();
        m.setTitle("Hora: 6:30 P.M");
        m.setDescription("Valor: $3.200");
        m.setImg(R.drawable.trensabana);
        modelst.add(m);


        return modelst;
    }

}

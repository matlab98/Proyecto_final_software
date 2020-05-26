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
    RecyclerView mRecyclerViewT;
    MyAdapterT myAdapterT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trenes_general);

        mRecyclerViewT=findViewById(R.id.recycleBus);
        mRecyclerViewT.setLayoutManager(new LinearLayoutManager(this));
        myAdapterT= new MyAdapterT(this, getMyList());

        regresar =(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrenesGeneral.this , MainMenu.class ));
            }
        });

    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();
        m.setTitle("Hora: 6:30 P.M");
        m.setDescription("Valor: $3.200");
        m.setImg(R.drawable.Tren);
        models.add(m);


        return models;
    }

}

package com.sabana.appsabana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterT extends RecyclerView.Adapter<MyHolderT> {

    Context c;
    ArrayList<Model> models;

    public MyAdapterT(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolderT onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new MyHolderT(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderT myHolderT, int i) {
        myHolderT.mTitleT.setText(models.get(i).getTitle());
        myHolderT.mDesT.setText(models.get(i).getDescription());
        myHolderT.mImaeViewT.setImageResource(models.get(i).getImg());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
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
    ArrayList<Modelt> modelst;

    public MyAdapterT(Context c, ArrayList<Modelt> modelst) {
        this.c = c;
        this.modelst = modelst;
    }

    @NonNull
    @Override
    public MyHolderT onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowt, null);

        return new MyHolderT(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderT myHolderT, int i) {
    myHolderT.mTitleT.setText(modelst.get(i).getTitle());
    myHolderT.mDesT.setText(modelst.get(i).getDescription());
    myHolderT.mImaeViewT.setImageResource(modelst.get(i).getImg());
    }

    @Override
    public int getItemCount() {
        return modelst.size();
    }
}
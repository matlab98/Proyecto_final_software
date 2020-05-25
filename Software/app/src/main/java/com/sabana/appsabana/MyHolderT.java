package com.sabana.appsabana;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolderT extends RecyclerView.ViewHolder {

    ImageView mImaeViewT;
    TextView mTitleT, mDesT;

    public MyHolderT(@NonNull View itemView) {
        super(itemView);

        this.mImaeViewT = itemView.findViewById(R.id.imageTren);
        this.mTitleT=itemView.findViewById(R.id.titleTren);
        this.mDesT= itemView.findViewById(R.id.descriptionTren);
    }
}

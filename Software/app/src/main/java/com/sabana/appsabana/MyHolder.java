package com.sabana.appsabana;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

public class MyHolder extends RecyclerView.ViewHolder {
    ImageView mImaeView;
    TextView mTitle, mDes;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImaeView = itemView.findViewById(R.id.imageBus);
        this.mTitle=itemView.findViewById(R.id.titleBus);
        this.mDes= itemView.findViewById(R.id.descriptionBus);
    }
}

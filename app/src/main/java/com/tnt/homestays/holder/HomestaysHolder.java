package com.tnt.homestays.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tnt.homestays.R;

public class HomestaysHolder extends RecyclerView.ViewHolder {
    public ImageView imgAvatar;
    public TextView tvPrice;
    public TextView tvAddress;
    public TextView tvArea;
    public TextView tvTitle;

    public HomestaysHolder(@NonNull View itemView) {
        super(itemView);
        imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
        tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        tvArea = (TextView) itemView.findViewById(R.id.tvArea);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
    }
}

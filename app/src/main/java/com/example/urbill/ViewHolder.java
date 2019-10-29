package com.example.urbill;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    TextView remarkTv;
    TextView amountTv;
    TextView timeTv;
    ImageView categoryIcon;

    public ViewHolder(View itemView, BillBean bill){
        remarkTv = itemView.findViewById(R.id.textView_remark);
        amountTv = itemView.findViewById(R.id.textView_amount);
        timeTv = itemView.findViewById(R.id.textView_time);
        categoryIcon = itemView.findViewById(R.id.imageView_category);
    }
}

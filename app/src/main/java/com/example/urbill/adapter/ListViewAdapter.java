package com.example.urbill.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.urbill.BillBean;
import com.example.urbill.DateUtil;
import com.example.urbill.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private static final String TAG = "ListViewAdapter";
    private List<BillBean> bills = null;
    private LayoutInflater inflater;
    private Context context;

    public ListViewAdapter(Context context){
        if (context != null){
            this.context = context;
            inflater = LayoutInflater.from(context);
        }else {
            Log.i(TAG, "ListViewAdapter: "+context == null ? "1" : "2");
        }
    }

    public void setData(List<BillBean> bills){
        this.bills = bills;
        notifyDataSetChanged();
    }





    @Override
    public int getCount() {
        return bills.size();
    }

    @Override
    public Object getItem(int i) {
        return bills.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder holder = null;
        BillBean bill = (BillBean) getItem(i);
        if(convertView == null){
            view = inflater.inflate(R.layout.cell_list_view, viewGroup, false);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        setViewContent(holder, bill);

        return view;
    }

    public void setViewContent(ViewHolder holder, BillBean bill){
        holder.remarkTv.setText(bill.getRemark());
        if(bill.getType() == 1){
            holder.amountTv.setText("-"+bill.getAmount());
        }else if (bill.getType() == 2){
            holder.amountTv.setText("+"+bill.getAmount());
        }
        holder.timeTv.setText(DateUtil.getFormattedTime(bill.getTimeStamp()));
//        holder.categoryIcon.setImageResource();
    }

    class ViewHolder {
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
}

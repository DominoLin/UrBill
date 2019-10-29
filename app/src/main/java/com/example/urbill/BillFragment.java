package com.example.urbill;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

public class BillFragment extends Fragment implements AdapterView.OnItemLongClickListener {

    private static final String TAG = "BillFragment";
    private View rootView;
    private TextView textView;
    private ListView listView;
    private String date;
    private ListViewAdapter listViewAdapter;
    private List<BillBean> bills;
    BillManager billManager = new BillManager(getContext());

    public BillFragment(String date) {
        this.date = date;
        billManager = new BillManager(getContext());
        bills = billManager.queryBills(date);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate((R.layout.fragment_bill), container,false);
        }
        initView();
        return rootView;
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume:()");
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initView() {
        textView = rootView.findViewById(R.id.day_text);
        listView = rootView.findViewById(R.id.list_view);
        listViewAdapter = new ListViewAdapter(getActivity());
        listView.setAdapter(listViewAdapter);
        reload();

        textView.setText(DateUtil.getDateYear(date) + DateUtil.getDateTitle(date));
        listView.setOnItemLongClickListener(this);
    }

    public void reload() {
        bills = billManager.queryBills(date);
        if (listViewAdapter == null) {
            listViewAdapter = new ListViewAdapter(getActivity());
        }

        listViewAdapter.setData(bills);

//        listView.setAdapter(listViewAdapter);
        if (rootView == null) {
            Log.d(TAG, "--->遭遇到了一些错误");
        } else {
            if (listViewAdapter.getCount() > 0) {
                rootView.findViewById(R.id.no_bill).setVisibility(View.INVISIBLE);
            } else {
                rootView.findViewById(R.id.no_bill).setVisibility(View.VISIBLE);
            }
        }
    }

    public int getTotalCost() {
        double totalCost = 0;
        for (BillBean record : bills) {
            if (record.getType() == 1) {
                totalCost += record.getAmount();
            }
        }
        return (int) totalCost;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "index" + i + "clicked");
        showDialog(i);

        return false;
    }

    private void showDialog(int index) {
        final String[] options = {"删除", "编辑"};
        final BillBean selectedRecord = bills.get(index);
//        billManager = new BillManager(getContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.create();

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, options[which] + "onClicked");
                //0-->删除
                //1-->编辑
                if (which == 0) {
                    String uuid = selectedRecord.getUuid();
                    billManager.removeBill(uuid);
                    reload();
                    if (listViewAdapter.getCount() == 0) {
                        if (date != DateUtil.getFormatterDate()) {

                        }
                    }
//                    GlobalUtil.getInstance().mainActivity.updateHeader();
                }
//                else if (which == 1) {
//                    //addRecordActivity
////                    Intent intent = new Intent(getActivity(), AddRecordActivity.class);
////
//                    Bundle extra = new Bundle();
//                    extra.putSerializable("record", selectedRecord);
//                    intent.putExtras(extra);
//
//                    startActivityForResult(intent, 1);
//                }
            }
        }).setNegativeButton("取消", null);
        builder.create().show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

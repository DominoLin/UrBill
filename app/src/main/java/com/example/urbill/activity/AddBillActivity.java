package com.example.urbill.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbill.BillBean;
import com.example.urbill.R;

public class AddBillActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AddBillActivity";
    private TextView amountText;//金额显示
    private String input = "";
    private TextView calendar;
    private String date;

    private EditText type_editText;

    private BillBean.RecordType type = BillBean.RecordType.RECORD_TYPE_EXPENSE;

    private boolean inEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        findViewById(R.id.keyboard_one).setOnClickListener(this);
        findViewById(R.id.keyboard_two).setOnClickListener(this);
        findViewById(R.id.keyboard_three).setOnClickListener(this);
        findViewById(R.id.keyboard_four).setOnClickListener(this);
        findViewById(R.id.keyboard_five).setOnClickListener(this);
        findViewById(R.id.keyboard_six).setOnClickListener(this);
        findViewById(R.id.keyboard_seven).setOnClickListener(this);
        findViewById(R.id.keyboard_eight).setOnClickListener(this);
        findViewById(R.id.keyboard_nine).setOnClickListener(this);
        findViewById(R.id.keyboard_zero).setOnClickListener(this);

        amountText = findViewById(R.id.input_text);

        handleType();
        handleDot();
        handleBackspace();
        handleDone();

    }

    private void handleDone() {

    }

    private void handleBackspace() {

    }

    private void handleDot() {

    }

    private void handleType() {
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String intent = button.getText().toString();
        Log.i(TAG, "onClick: " + intent);
        if (input.contains(".")) {
            if (input.split("\\.").length == 1 || input.split("\\.")[1].length() < 2) {
                //11.11   小数点后面 只能是两位数
                input += intent;
            }else {
                input += intent;
            }
        }
        updateAmountText();
    }

    private void updateAmountText() {

    }
}

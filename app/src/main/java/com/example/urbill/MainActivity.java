package com.example.urbill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";


    private TickerView amountText;//数字显示
    private TextView dateText;//星期显示
    private FloatingActionButton addBtn//添加账单按钮
    private ViewPager viewPager;//账单ViewPager

    private int currentPagerPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountText = findViewById(R.id.amount_text);//数字显示
        amountText.setCharacterLists(TickerUtils.provideNumberList());
        dateText = findViewById(R.id.date_text);//星期显示

        addBtn = findViewById(R.id.add_amount);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this. AddBillActivity.class);
                startActivityForResult(intent,1);
            }
        });

        viewPager = findViewById(R.id.view_pager);




    }


    @Override
    public void onPageSelected(int position) {
        currentPagerPosition = position;

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }

}

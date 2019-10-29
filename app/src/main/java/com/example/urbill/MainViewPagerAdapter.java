package com.example.urbill;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.LinkedList;


public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "MainViewPagerAdapter";
    private FragmentManager fragmentManager;
    LinkedList<MainFragment> fragments = new LinkedList<>();

    public MainViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

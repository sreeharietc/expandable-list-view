package com.example.qbclct.expandableview.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.qbclct.expandableview.Fragment.MyFragment;

/**
 * Created by QBCLCT on 10/8/16.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 5;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle data = new Bundle();
        data.putInt("current_page", position+1);
        myFragment.setArguments(data);
        return myFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}

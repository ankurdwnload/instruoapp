package com.example.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Focus on 29-Dec-14.
 */
public class MyCollectionPagerAdapter extends FragmentStatePagerAdapter {

    public MyCollectionPagerAdapter(FragmentManager fm){
        super(fm);
    }




    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new MyObjectFragment();
//        Bundle args = new Bundle();
        // Our object is just an integer :-P
//        args.putInt(MyObjectFragment.ARG_OBJECT, i + 1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "DAY " + (position + 1);
    }
}

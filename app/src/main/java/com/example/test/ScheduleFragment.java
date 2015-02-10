package com.example.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Focus on 29-Dec-14.
 */
public class ScheduleFragment extends Fragment {

    MyCollectionPagerAdapter mMyCollectionPagerAdapter;
    ViewPager mViewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(MainActivity.menu_list[getArguments().getInt("POSITION")].title);
        PagerSlidingTabStrip mpagerSlidingTabStrip;
        mMyCollectionPagerAdapter = new MyCollectionPagerAdapter(getFragmentManager());
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.schedule_fragment, container, false);
        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mMyCollectionPagerAdapter);
        mpagerSlidingTabStrip = (PagerSlidingTabStrip) v.findViewById(R.id.sliding_tabs);
        mpagerSlidingTabStrip.setShouldExpand(true);
//        mpagerSlidingTabStrip.setTabBackground(R.color.top);
        mpagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.tab_underline));
        mpagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.top));
        mpagerSlidingTabStrip.setViewPager(mViewPager);
        return v;
    }



}

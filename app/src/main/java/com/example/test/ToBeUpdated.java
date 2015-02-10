package com.example.test;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Focus on 31-Dec-14.
 */
public class ToBeUpdated extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(MainActivity.menu_list[getArguments().getInt("POSITION")].title);
        View rootView = inflater.inflate(R.layout.to_be_updated, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.updated_soon);
        ImageView iv = (ImageView) rootView.findViewById(R.id.upimg);
        Drawable image = getResources().getDrawable(R.drawable.android2);
        View root  = (View) rootView.findViewById(R.id.uproot);
        iv.setImageDrawable(image);
//        image.setBounds(0,0, 200, 200);
//        tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, image);
        root.setMinimumHeight(getResources().getDisplayMetrics().heightPixels);
        return rootView;
    }
}

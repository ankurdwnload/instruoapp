package com.example.test;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Focus on 29-Dec-14.
 */
public class MyObjectFragment extends Fragment {

    public EventSchedule day_one_schedule [] = new EventSchedule[]{
            new EventSchedule(AllEventsFragment.all_event_list[0], "Institute hall", "0900", "1200"),
            new EventSchedule(AllEventsFragment.all_event_list[1], "Alumni Seminar hall", "1000", "1230"),
            new EventSchedule(AllEventsFragment.all_event_list[2], "Civil Drawing Room", "1200", "1330"),
            new EventSchedule(AllEventsFragment.all_event_list[3], "Gallery 7", "1200"),
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_object_fragment, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.schedule_listview);
        ScheduleAdapter adapter = new ScheduleAdapter(this.getActivity(), R.layout.schedule_list_row, day_one_schedule);
        lv.setAdapter(adapter);
        return rootView;
    }

}

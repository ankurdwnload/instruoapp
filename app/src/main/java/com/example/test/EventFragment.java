package com.example.test;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Focus on 25-Dec-14.
 */
public class EventFragment extends Fragment {

    public static MyMenu event_list[] = new MyMenu[]
            {
                    new MyMenu(R.drawable.allevents, "All Events"),
                    new MyMenu(R.drawable.robodarshan, "Robodarshan"),
                    new MyMenu(R.drawable.coder, "Coder"),
                    new MyMenu(R.drawable.legacy, "Legacy"),
                    new MyMenu(R.drawable.insitu, "In-Situ"),
                    new MyMenu(R.drawable.initium, "Initium"),
                    new MyMenu(R.drawable.quizmaniacs, "Quizmaniacs"),
            };



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount() > 1)
            fm.popBackStack();
//        if(fm.findFragmentByTag("EVENT").isDetached() || container.getChildCount()!=0 ){
////            return super.onCreateView(inflater, container, savedInstanceState);
//            Log.d("DEBUG", "Stack before = "+fm.getBackStackEntryCount());
//            fm.popBackStack();
//            Log.d("DEBUG", "Stack after = "+fm.getBackStackEntryCount());
//            MainActivity.state = 0;
//            return super.onCreateView(inflater, container, savedInstanceState);
//        }
        Log.d("DEBUG", "Event Added");
        if (fm.getBackStackEntryCount() > 0)
            MainActivity.state = 1;
        else
            MainActivity.state = 0;
                ((MainActivity) getActivity()).getSupportActionBar().setTitle(MainActivity.menu_list[getArguments().getInt("POSITION")].title);
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.event_fragment, container, false);
        ListView lv = (ListView) v.findViewById(R.id.event_listview);
        EventAdapter adapter = new EventAdapter(this.getActivity(), R.layout.event_list_row, event_list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ((MainActivity)getActivity()).getSupportActionBar().setTitle(event_list[position].title);
                selectItem(position);
            }
        });
        return v;
    }
//


    private void selectItem (int position){
       FragmentManager fm = getFragmentManager();
       Bundle args = new Bundle();
       args.putInt("POSITION", position);
       switch (position){
           case 0 : AllEventsFragment fragment = new AllEventsFragment();
                    fragment.setArguments(args);
//                    replaceFragment(fragment);
                    fm.beginTransaction().replace(R.id.fr1, fragment, "ALL EVENT").addToBackStack("Event").commit();
                    break;
       }

   }

        @Override
        public void onStop() {
            Log.d("DEBUG", "Event Destroyed");
            super.onDestroy();
        }
}


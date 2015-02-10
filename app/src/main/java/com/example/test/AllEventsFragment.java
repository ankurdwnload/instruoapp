package com.example.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Focus on 28-Dec-14.
 */
public class AllEventsFragment extends Fragment {

    public static MyMenu all_event_list [] = new MyMenu[]{
            new MyMenu(R.drawable.shadowe, "Shadow"),
            new MyMenu(R.drawable.lightliner, "Light-Liner"),
            new MyMenu(R.drawable.reliefhunter, "Relief Hunter"),
            new MyMenu(R.drawable.amazeing, "A-Maze-ing"),
            new MyMenu(R.drawable.odetocode, "Ode to Code"),
            new MyMenu(R.drawable.googlegrep, "Google Grep"),
            new MyMenu(R.drawable.devwars, "Dev Wars"),
            new MyMenu(R.drawable.counterstrike, "Counter Strike"),
            new MyMenu(R.drawable.fifa, "FIFA '09"),
            new MyMenu(R.drawable.nfsmostwanted, "NFS Most Wanted"),
            new MyMenu(R.drawable.faceoff, "Face Off"),
            new MyMenu(R.drawable.designstudios, "Design Studios"),
            new MyMenu(R.drawable.warofthetitans, "War of the Titans"),
            new MyMenu(R.drawable.wiredin, "Wired-In"),
            new MyMenu(R.drawable.electronikaz, "Electronikaz"),
            new MyMenu(R.drawable.junke, "JunkE"),
            new MyMenu(R.drawable.sanskaran, "Sanskaran"),
            new MyMenu(R.drawable.mathemania, "Mathemania"),
            new MyMenu(R.drawable.papyrus, "Papyrus"),
            new MyMenu(R.drawable.opendesign, "Open Design"),
            new MyMenu(R.drawable.planmasters, "Plan Masters"),
            new MyMenu(R.drawable.prashnavali, "Prashnavali"),
            new MyMenu(R.drawable.bizathelon, "Bizathelon"),
            new MyMenu(R.drawable.ibmworklight, "IBM Worklight"),
    };


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        FragmentManager fm = getFragmentManager();
//        Fragment fr = fm.findFragmentByTag("EVENT");
//        if(fm.getBackStackEntryCount() > 1)
//            fm.beginTransaction().remove(fr).commit();
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(EventFragment.event_list[getArguments().getInt("POSITION")].title);
        Log.d("DEBUG", "All Event Created");
        MainActivity.state = 1;
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.all_event_fragment, container, false);
        ListView lv = (ListView) v.findViewById(R.id.all_event_listview);
        EventAdapter adapter = new EventAdapter(this.getActivity(), R.layout.event_list_row, all_event_list);
        lv.setAdapter(adapter);
        return v;
    }
}



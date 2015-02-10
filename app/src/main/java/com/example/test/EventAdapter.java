package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Focus on 27-Dec-14.
 */
public class EventAdapter extends ArrayAdapter <MyMenu> {
    private int lastPosition = -1;
    Context context;
    int resource;
    MyMenu data[] = null;

    public EventAdapter(Context context, int resource, MyMenu[] data) {
        super(context, resource, data);
        this.resource = resource;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EventHolder holder = new EventHolder();
        MyMenu myMenu = data[position];
        if(row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle_event);
            row.setTag(holder);
        }else{
            holder = (EventHolder) row.getTag();
        }
        holder.txtTitle.setText(myMenu.title);
        Drawable image = getContext().getResources().getDrawable(myMenu.icon);
        image.setBounds(0,0, getContext().getResources().getDisplayMetrics().widthPixels, 150);
        holder.txtTitle.setCompoundDrawables(null, image, null, null);
        Animation anim = AnimationUtils.loadAnimation(getContext(),(position > lastPosition)? R.anim.slide_up : R.anim.slide_down);
        row.startAnimation(anim);
        lastPosition = position;
        return row;

    }

    static class EventHolder{
        TextView txtTitle;
    }
}

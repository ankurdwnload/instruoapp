package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Focus on 31-Dec-14.
 */
public class ScheduleAdapter extends ArrayAdapter <EventSchedule> {

    private int lastPosition = -1;
    Context context;
    int resource;
    EventSchedule data[] = null;

    public ScheduleAdapter(Context context, int resource, EventSchedule[] data) {
        super(context, resource, data);
        this.resource = resource;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ScheduleHolder holder = new ScheduleHolder();
        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder.event_image = (ImageView) row.findViewById(R.id.event_image);
            holder.event_name = (TextView) row.findViewById(R.id.event_name);
            holder.event_venue = (TextView) row.findViewById(R.id.event_venue);
            holder.event_time = (TextView) row.findViewById(R.id.event_time);
            row.setTag(holder);
        }else{
            holder = (ScheduleHolder) row.getTag();
        }
        EventSchedule eventSchedule = data[position];
        Drawable drawable = getContext().getResources().getDrawable(eventSchedule.eventObj.icon);
        drawable.setBounds(0,0, 100, 100);
        holder.event_image.setImageDrawable(drawable);
        holder.event_name.setText(eventSchedule.eventObj.title);
        holder.event_venue.setText(eventSchedule.eventVenue);
        if(eventSchedule.endTime == "Onwards"){
            holder.event_time.setText(eventSchedule.startTime + " Hrs Onwards");
        }
        else{
            holder.event_time.setText(eventSchedule.startTime + " - " + eventSchedule.endTime + " Hrs");
        }
        return row;
    }

    static class ScheduleHolder {
        TextView event_name, event_venue, event_time;
        ImageView event_image;
    }
}

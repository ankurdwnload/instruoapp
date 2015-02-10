package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Focus on 26-Dec-14.
 */
public class MyMenuAdapter extends ArrayAdapter<MyMenu> {

    Context context;
    int resource;
    MyMenu data[] = null;


    public MyMenuAdapter(Context context, int resource, MyMenu[] data) {
        super(context, resource, data);
        this.resource = resource;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MenuHolder holder = new MenuHolder();
        MyMenu myMenu = data[position];
        int type = myMenu.type;
//        if(row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            switch (type) {
                case 1:
                    row = inflater.inflate(resource, parent, false);
                    holder.imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
                    holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);
                    break;
                case 0:
                    row = inflater.inflate(R.layout.divider, parent, false);
                    break;
            }
//            row.setTag(holder);
//        }else{
//            holder = (MenuHolder) row.getTag();
//        }
        if(type==1) {

//            Log.d("DEBUG", "Child = " + ((ViewGroup)row).getChildAt(1));
//            if(position == 3)
//                return row;
            holder.txtTitle.setText(myMenu.title);
//            holder.imgIcon.setImageResource(myMenu.icon);

            if (position == MainActivity.itemSelected) {
//            row.setBackgroundColor(getContext().getResources().getColor(R.color.color1));
                ((TextView)((ViewGroup)row).getChildAt(1)).setTextColor(getContext().getResources().getColor(R.color.top));
                ((ImageView)((ViewGroup)row).getChildAt(0)).setImageResource(myMenu.selected_icon);
            }
            else {
//            row.setBackgroundColor(getContext().getResources().getColor(R.color.side));
                ((TextView) ((ViewGroup)row).getChildAt(1)).setTextColor(getContext().getResources().getColor(R.color.activate_text_color));
                ((ImageView)((ViewGroup)row).getChildAt(0)).setImageResource(myMenu.icon);

            }
        }

        return row;
    }

    static class MenuHolder{
        ImageView imgIcon;
        TextView txtTitle;
    }
}

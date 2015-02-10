package com.example.test;

/**
 * Created by Focus on 26-Dec-14.
 */
public class MyMenu {
    public int icon,type,selected_icon;
    public CharSequence title;
    public MyMenu (){
        super();
    }
    public MyMenu (CharSequence title){
        this.title = title;
        this.icon = 0;
        this.type = 1;
    }
    public MyMenu (int icon, CharSequence title){
        super();
        this.icon = icon;
        this.title = title;
        this.type = 1;
    }
    public MyMenu (int icon, CharSequence title, int type){
        super();
        this.icon = icon;
        this.title = title;
        this.type = type;
        this.selected_icon = 0;
    }
    public MyMenu (int selected_icon, int icon, CharSequence title){
        super();
        this.icon = icon;
        this.title = title;
        this.type = 1;
        this.selected_icon = selected_icon;
    }
}

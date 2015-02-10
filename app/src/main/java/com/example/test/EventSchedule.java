package com.example.test;

/**
 * Created by Focus on 31-Dec-14.
 */
public class EventSchedule {
    public CharSequence eventName, eventVenue, startTime, endTime;
    public MyMenu eventObj;

    public EventSchedule (MyMenu eventObj, CharSequence eventVenue, CharSequence startTime, CharSequence endTime){
        this.eventObj = eventObj;
        this.eventVenue = eventVenue;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public EventSchedule (MyMenu eventObj, CharSequence eventVenue, CharSequence startTime){
        this.eventObj = eventObj;
        this.eventVenue = eventVenue;
        this.startTime = startTime;
        this.endTime = "Onwards";
    }
}

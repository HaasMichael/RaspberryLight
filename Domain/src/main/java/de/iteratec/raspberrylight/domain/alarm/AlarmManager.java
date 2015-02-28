/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.alarm;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author developer
 */
public class AlarmManager {
    
    private Gson gson = new Gson();
    
    private List<Alarm> alarms = new ArrayList<>();
    
    public AlarmManager() {
       createDefaultAlarms();
    }
    
    private void createDefaultAlarms() {
        Calendar cal1 = new GregorianCalendar();
        cal1.set(2014, 2, 28, 15, 0, 0);
        alarms.add(new Alarm("Wake me up", cal1.getTime()));
    }
    
    public String getAlarms() {
        return gson.toJson(alarms);
    }
    
    public void addAlarm(String name, Date start) {
        Alarm alarm = new Alarm(name, start);
        alarms.add(alarm);
    }
    
    public void updateAlarm(Alarm alarm) {
        
    }
    
    public void deleteAlarm(Alarm alarm) {
        
    }

    
}

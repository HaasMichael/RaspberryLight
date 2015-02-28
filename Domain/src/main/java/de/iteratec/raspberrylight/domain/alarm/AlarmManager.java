/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.alarm;

import com.google.gson.Gson;
import de.iteratec.raspberrylight.core.Color;

import java.util.*;

/**
 * @author developer
 */
public class AlarmManager {

  private Gson gson;

  private Collection<Alarm> alarms;

  public AlarmManager() {
    gson = new Gson();
    alarms = new LinkedList<>();

    // For testing purposes
    createDefaultAlarms();
  }

  private void createDefaultAlarms() {
    Calendar cal1 = new GregorianCalendar();
    cal1.set(2014, 2, 28, 15, 0, 0);
    alarms.add(new Alarm("Wake me up", cal1.getTime(), new Color(new int[]{255, 0, 0}), 20000));
  }

  public Collection<Alarm> getAlarms() {
    return alarms;
  }

  public void addAlarm(String name, Date start, Color color, int fadeInDuration) {
    Alarm alarm = new Alarm(name, start, color, fadeInDuration);
    alarms.add(alarm);
  }

  public void addAlarm(Alarm alarm) {
    alarms.add(alarm);
  }

  public void updateAlarm(Alarm alarm) {
    Alarm toUpdate = getAlarm(alarm.getName());
    toUpdate.setStart(alarm.getStart());
    toUpdate.setColor(alarm.getColor());
    toUpdate.setFadeInDuration(alarm.getFadeInDuration());
    // TODO update sound file.
  }

  public void deleteAlarm(Alarm alarm) {
    Alarm toRemove = getAlarm(alarm.getName());
    alarms.remove(toRemove);
  }

  public Alarm getAlarm(String name) {
    for (Alarm alarm : alarms) {
      if (name.equalsIgnoreCase(alarm.getName())) {
        return alarm;
      }
    }

    return null;
  }

}

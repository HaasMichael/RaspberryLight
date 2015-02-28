/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.alarm;

import de.iteratec.raspberrylight.core.Color;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author developer
 */
public class Alarm implements Type {

  private static final String dtPattern = "yyyy-MM-dd_HH:mm:ss";
  private static final DateFormat df = new SimpleDateFormat(dtPattern);

  private String name;
  private Date start;
  private String soundfile;
  private Color color;
  private int fadeInDuration;

  private boolean monday;
  private boolean tuesday;
  private boolean wednesday;
  private boolean thursday;
  private boolean friday;
  private boolean saturday;
  private boolean sunday;

  public Alarm(String name, Date start, Color color, int fadeInDuration, boolean monday, boolean tuesday,
               boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
    this.name = name;
    this.start = start;
    this.color = color;
    this.fadeInDuration = fadeInDuration;
    this.monday = monday;
    this.tuesday = tuesday;
    this.wednesday = wednesday;
    this.thursday = thursday;
    this.friday = friday;
    this.saturday = saturday;
    this.sunday = sunday;
  }

  public Alarm(String name, Date start, Color color, int fadeInDuration) {
    this(name, start, color, fadeInDuration, false, false, false, false, false, false, false);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int getFadeInDuration() {
    return fadeInDuration;
  }

  public void setFadeInDuration(int fadeInDuration) {
    this.fadeInDuration = fadeInDuration;
  }

  public boolean isMonday() {
    return monday;
  }

  public void setMonday(boolean monday) {
    this.monday = monday;
  }

  public boolean isTuesday() {
    return tuesday;
  }

  public void setTuesday(boolean tuesday) {
    this.tuesday = tuesday;
  }

  public boolean isWednesday() {
    return wednesday;
  }

  public void setWednesday(boolean wednesday) {
    this.wednesday = wednesday;
  }

  public boolean isThursday() {
    return thursday;
  }

  public void setThursday(boolean thursday) {
    this.thursday = thursday;
  }

  public boolean isFriday() {
    return friday;
  }

  public void setFriday(boolean friday) {
    this.friday = friday;
  }

  public boolean isSaturday() {
    return saturday;
  }

  public void setSaturday(boolean saturday) {
    this.saturday = saturday;
  }

  public boolean isSunday() {
    return sunday;
  }

  public void setSunday(boolean sunday) {
    this.sunday = sunday;
  }
}

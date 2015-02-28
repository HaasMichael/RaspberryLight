/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.alarm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author developer
 */
public class Alarm {
    
    private static final String dtPattern = "yyyy-MM-dd_HH:mm:ss";
    private static final DateFormat df = new SimpleDateFormat(dtPattern);
    
    private String name;
    private Date start;
    private String soundfile;
    
    public Alarm(String name, Date start) {
        this.name = name;
        this.start = start;
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
    
}

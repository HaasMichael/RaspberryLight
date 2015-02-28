/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.core.enums;

/**
 *
 * @author Michael Haas <Michael.Haas@iteratec.de>
 */
public class Brightness {
    
    public static final Brightness DARK = new Brightness(0);
    public static final Brightness GLOOMY = new Brightness(25);
    public static final Brightness FLAT = new Brightness(50);
    public static final Brightness BRIGHT = new Brightness(75);
    public static final Brightness SHINY = new Brightness(100);
    
    private final int value;
    
    public Brightness(final int value){
        this.value = value;
    }
    
    int getValue(){
        return value;
    }
}

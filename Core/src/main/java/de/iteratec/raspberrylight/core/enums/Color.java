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
public class Color {
    public static final Color BLACK = new Color(0x000000);
    public static final Color RED = new Color(0xFF0000);
    public static final Color GREEN = new Color(0x00FF00);
    public static final Color BLUE = new Color(0x0000FF);
    public static final Color WHITE = new Color(0xFFFFFF);
    
    private final int value;
    
    public Color(final int value){
        this.value = value;
    }
    
    int getValue(){
        return value;
    }
}

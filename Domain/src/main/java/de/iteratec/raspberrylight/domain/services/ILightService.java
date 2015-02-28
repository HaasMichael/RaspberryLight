/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.services;

import de.iteratec.raspberrylight.core.enums.Brightness;
import de.iteratec.raspberrylight.core.enums.Color;

/**
 *
 * @author Michael Haas <Michael.Haas@iteratec.de>
 */
public interface ILightService {
    
    void turnOn();
    
    void turnOff();
    
    void wakeUp();
    
    void setColor(final Color color);
    
    void setBrightness(final Brightness brightness);
    
    void increaseBrightness();
    
    void decreaseBrightness();
}

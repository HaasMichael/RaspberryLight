/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.service.controller;

import de.iteratec.raspberrylight.domain.alarm.AlarmManager;
import de.iteratec.raspberrylight.domain.services.ILightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author developer
 */
@RestController
public class LightController {
        
    @Autowired
    private ILightService lightService;
    private final AlarmManager alarmManager = new AlarmManager();
    
    private boolean lightOn = false;
    
    @RequestMapping("/toggle")
    public void toggle() {
        if (lightOn) {
            lightService.turnOn();
        } else {
            lightService.turnOff();
        }
        lightOn = !lightOn;
    }
    
    @RequestMapping(value="/alarms", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAlarms() {
        return "";//alarmManager.getAlarms();
    }
    
    @RequestMapping(value="/wakeup")
    public void wakeUp() {
        lightService.wakeUp();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.service.controller;

import de.iteratec.raspberrylight.domain.alarm.AlarmManager;
import de.iteratec.raspberrylight.domain.light.PiCommunication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author developer
 */
@RestController
public class LightController {
        
    private PiCommunication piCommunication = new PiCommunication();
    private AlarmManager alarmManager = new AlarmManager();
    
    private boolean lightOn = false;
    
    @RequestMapping("/toggle")
    public void toggle() {
        if (lightOn) {
            piCommunication.turnLightOn();
        } else {
            piCommunication.turnLightOff();
        }
        lightOn = !lightOn;
    }
    
    @RequestMapping(value="/pulse")
    public void pulse(@RequestParam int pwmValue, @RequestParam int pwmRange) {
        piCommunication.pulse(pwmValue, pwmRange);
    }
    
    @RequestMapping(value="/alarms", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAlarms() {
        return "";//alarmManager.getAlarms();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.service.controller;

import de.iteratec.raspberrylight.core.enums.Brightness;
import de.iteratec.raspberrylight.domain.services.ILightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Michael Haas <Michael.Haas@iteratec.de>
 */
@RestController
public class LightController {
    
    @Autowired
    private ILightService lightService;
    
    @RequestMapping("/lightsOn")
    public void switchOn(){
        lightService.setBrightness(Brightness.SHINY);
    }
    
    @RequestMapping("/lightsOff")
    public void switchOff(){
        lightService.setBrightness(Brightness.DARK);
    }
}

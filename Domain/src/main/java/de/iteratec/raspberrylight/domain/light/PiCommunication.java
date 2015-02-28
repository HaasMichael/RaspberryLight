/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.light;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.SoftPwm;

/**
 *
 * @author developer
 */
public class PiCommunication {
    
    private final GpioController gpioController;
    
    private final GpioPinDigitalOutput red;
    private final GpioPinDigitalOutput green;
    private final GpioPinDigitalOutput blue;

    public PiCommunication() {
        gpioController = GpioFactory.getInstance();
        
        red = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        green = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04);
        blue = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05);
    }
    
    public void blinkLight() {
        red.blink(2000);
    }
    
    public void turnLightOn() {
        red.high();
        green.high();
        blue.high();
    }
    
    public void turnLightOff() {
        red.low();
        green.low();
        blue.low();
    }
    
    public void pulse(int value, int range) {
        SoftPwm.softPwmCreate(red.getPin().getAddress(), value, range);
    }
    
}

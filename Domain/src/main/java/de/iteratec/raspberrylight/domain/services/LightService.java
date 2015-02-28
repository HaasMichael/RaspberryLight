/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.services;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import de.iteratec.raspberrylight.core.enums.Brightness;
import de.iteratec.raspberrylight.core.enums.Color;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Michael Haas <Michael.Haas@iteratec.de>
 */
@Component
public class LightService implements ILightService, DisposableBean{
    
    private final GpioController gpio;

    private final GpioPinDigitalOutput redPin;
    private final GpioPinDigitalOutput greenPin;
    private final GpioPinDigitalOutput bluePin;

    public LightService(){
        gpio = GpioFactory.getInstance();
        
        redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
        bluePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
        
        init();
    }

    private void init() {
        redPin.low();
        greenPin.low();
        bluePin.low();
    }
    
    @Override
    public void setColor(final Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBrightness(final Brightness brightness) {
        redPin.toggle();
        greenPin.toggle();
        bluePin.toggle();
    }

    @Override
    public void increaseBrightness() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void decreaseBrightness() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() throws Exception {
        gpio.shutdown();
    }
    
}

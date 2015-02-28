/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.services;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.SoftPwm;
import de.iteratec.raspberrylight.core.enums.Brightness;
import de.iteratec.raspberrylight.core.enums.Color;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Michael Haas <Michael.Haas@iteratec.de>
 */
@Component
public class LightService implements ILightService, DisposableBean{
    
    private static final Logger LOGGER = Logger.getLogger(LightService.class);
    
    private final GpioController gpio;

    private final GpioPinDigitalOutput red;
    private final GpioPinDigitalOutput green;
    private final GpioPinDigitalOutput blue;
    
    private Timer increaseBrightnessTimer;
    private int currentStep = 0;

    public LightService(){
        LOGGER.info("Instantiating LightService");
        gpio = GpioFactory.getInstance();
        for (GpioPin pin : gpio.getProvisionedPins()) {
            LOGGER.info("Releaseing pin " + pin.toString());
            gpio.unprovisionPin(pin);
        }
                
        LOGGER.info("Pprovisioning pins...");
        red = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        green = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
        blue = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
        
        init();
    }

    private void init() {
        turnOff();
    }

    @Override
    public void turnOn() {
        LOGGER.info("Turning light on");
        red.high();
        green.high();
        blue.high();
    }

    @Override
    public void turnOff() {
        LOGGER.info("Turning light off");
        red.low();
        green.low();
        blue.low();
    }
    
    @Override
    public void wakeUp() {
        LOGGER.info("Waking up light");
        softPwmCreateForAllPins();
        increaseBrightnessTimer = new Timer();
        increaseBrightnessTimer.scheduleAtFixedRate(increaseBrightnessTimerTask(), 0, 20);
    }

    private void softPwmCreateForAllPins() {
        currentStep = 0;
        softPwmCreateForPin(red.getPin().getAddress());
        softPwmCreateForPin(green.getPin().getAddress());
        softPwmCreateForPin(blue.getPin().getAddress());
    }

    private void softPwmCreateForPin(int pinAddress) {
        SoftPwm.softPwmCreate(pinAddress, 0, 100);
    }

    private void softPwmWriteForAllPins(int value) {
        softPwmWriteForPin(red.getPin().getAddress(), value);
        softPwmWriteForPin(green.getPin().getAddress(), value);
        softPwmWriteForPin(blue.getPin().getAddress(), value);
    }

    private void softPwmWriteForPin(int pinAddress, int value) {
        SoftPwm.softPwmWrite(pinAddress, value);
    }

    private TimerTask increaseBrightnessTimerTask() {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                double brightness = calculateCurrentBrightness();
                LOGGER.info("Setting brightness to " + brightness);
                softPwmWriteForAllPins((int) Math.round(brightness));
                if (brightness > 100) {
                    cancel();
                    killIncreaseBrightnessTimer();
                    return;
                }
                ++currentStep;
            }
            
            private int calculateCurrentBrightness() {
                double result = 1.0 * (currentStep * currentStep) / (100 * 100);
                return (int) Math.round(result);
            }
            
        };
        return task;
    }

    private void killIncreaseBrightnessTimer() {
        LOGGER.info("Killing timer for increasing brightness");
        increaseBrightnessTimer.cancel();
        increaseBrightnessTimer.purge();
        turnOff();
        softPwmCreateForAllPins();
    }
    
    @Override
    public void setColor(final Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBrightness(final Brightness brightness) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

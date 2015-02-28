/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.domain.services;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.DisposableBean;


/**
 *
 * @author David Schowalter
 */
@Component
public class SoundService implements ISoundService, DisposableBean{

    @Override
    public void play(String pathToFile) {
        try {
            Runtime.getRuntime().exec("omxplayer -o local "+pathToFile);
        } catch (IOException ex) {
            Logger.getLogger(SoundService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void destroy() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

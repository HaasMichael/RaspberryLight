package de.iteratec.raspberrylight.service.controller;

import de.iteratec.raspberrylight.service.model.Sound;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sound")
public class SoundController {

    private Map<String, Sound> sounds = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<Sound> getSounds() {
        return sounds.values();
    }

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, consumes = "application/json")
    public void addSound(Sound sound) {
        if (sound != null) {
            sounds.put(sound.getName(), sound);
        }
    }

}

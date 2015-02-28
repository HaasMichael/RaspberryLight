package de.iteratec.raspberrylight.service.controller;

import de.iteratec.raspberrylight.service.model.Sound;
import org.springframework.web.bind.annotation.PathVariable;
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

    public SoundController() {
        // TODO remove (just some mocking data)
        sounds.put("Ring", new Sound("Ring", "ring.mp3"));
        sounds.put("Ring Ring", new Sound("Ring ring", "ringring.mp3"));
        sounds.put("Blubb", new Sound("Blubb", "blubb.mp3"));
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<Sound> getSounds() {
        return sounds.values();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public Sound getSounds(@PathVariable String name) {
        return sounds.get(name);
    }

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, consumes = "application/json")
    public void addSound(Sound sound) {
        if (sound != null) {
            sounds.put(sound.getName(), sound);
        }
    }

}

package de.iteratec.raspberrylight.service.model;

public class Sound {

    private String name;
    private String fileName;

    public Sound() {
    }

    public Sound(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

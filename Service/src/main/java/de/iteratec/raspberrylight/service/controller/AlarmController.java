package de.iteratec.raspberrylight.service.controller;

import de.iteratec.raspberrylight.domain.alarm.Alarm;
import de.iteratec.raspberrylight.domain.alarm.AlarmManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/alarms")
public class AlarmController {

  private static final String MESSAGE_MIME_TYPE = "application/json";

  private final AlarmManager alarmManager;

  public AlarmController() {
    alarmManager = new AlarmManager();
  }

  @RequestMapping(method = RequestMethod.GET, produces = MESSAGE_MIME_TYPE)
  public ResponseEntity<Collection<Alarm>> getAlarms() {
    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Access-Control-Allow-Origin", "*");
    return new ResponseEntity<Collection<Alarm>>(alarmManager.getAlarms(), responseHeaders, HttpStatus.CREATED);
  }

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = MESSAGE_MIME_TYPE)
  public void addAlarm(Alarm alarm) {
    if (alarm != null) {
      alarmManager.addAlarm(alarm);
    }
  }
}

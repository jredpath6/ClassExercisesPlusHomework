/*
 * WeatherData.java 1.0 Feb. 14, 2018
 *
 * Copyright (c) 2018 HFDP and DJP
 */
package headfirst.seniorstudent2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Observable (Subject) broadcasts out pressure, temperature and humidity to all Observer
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */

import java.util.Observable;

public class WeatherData extends Observable {

  private float humidity;
  private float pressure;
  private float temperature;

  /**
   * Initializes empty list of Observers
   */
  public WeatherData() {
	  //No longer needs to create a data structure to hold observables
  }
  
  public void measurementsChanged() {
	  setChanged();
	  notifyObservers();
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public float getTemperature() {
    return temperature;
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  @Override
  public String toString() {
    String s = "temperature: " + temperature;
    s = s + "\n" + "humidity: " + humidity;
    s = s + "\n" + "pressure: " + pressure;
    return s;
  }
}

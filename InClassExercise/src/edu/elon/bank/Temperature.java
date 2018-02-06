/*
 * Temperature.java 1.0 2012/09/12
 *
 * @author Savitch
 * @version 1.0
 */
package edu.elon.bank;


/**
 * Class for a temperature (expressed in degrees Celsius).
 */
public class Temperature {
    private double degrees; // Celsius

    public Temperature() {
        degrees = 0;
    }

    public Temperature(double initialDegrees) {
        degrees = initialDegrees;
    }

    public boolean equals(Temperature otherTemperature) {
        return (degrees == otherTemperature.degrees);
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double newDegrees) {
        degrees = newDegrees;
    }

    /**
     * Returns number of Celsius degrees equal to degreesF Fahrenheit
     * degrees.
     */
    public double toCelsius(double degreesF) {

        return 5 * (degreesF - 32) / 9;
    }

    @Override
    public String toString() {
        return (degrees + " C");
    }

}

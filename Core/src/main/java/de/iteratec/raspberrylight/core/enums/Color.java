/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.iteratec.raspberrylight.core.enums;

/**
 * @author Michael Haas <Michael.Haas@iteratec.de>
 */
public class Color {

  private static final int DEFAULT_MIN_VALUE = 0;
  private static final int DEFAULT_MAX_VALUE = 255;

  private final int[] rgbValues;

  private final int minValue;
  private final int maxValue;

  public Color(final int[] rgbValues) {
    this(rgbValues, DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
  }

  public Color(final int[] rgbValues, final int minValue, final int maxValue) {
    if (rgbValues == null || rgbValues.length != 3) {
      throw new IllegalArgumentException("rgb values must contain three components.");
    }
    this.rgbValues = rgbValues;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public int getMinValue() {
    return minValue;
  }

  public int getMaxValue() {
    return maxValue;
  }

  public int getRed() {
    return rgbValues[0];
  }

  public int getGreen() {
    return rgbValues[1];
  }

  public int getBlue() {
    return rgbValues[2];
  }
}

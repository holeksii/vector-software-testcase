package com.github.holeksii.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle implements Shape {

  private double radius;

  @Override
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }
}

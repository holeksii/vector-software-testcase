package com.github.holeksii.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle implements Shape {
  
  private double base;
  private double height;

  @Override
  public double getArea() {
    return base * height / 2;
  }
}

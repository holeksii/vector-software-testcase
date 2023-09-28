package com.github.holeksii.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle implements Shape {
  
  private double width;
  private double height;

  @Override
  public double getArea() {
    return width * height;
  }
}

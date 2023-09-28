package com.github.holeksii.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square implements Shape {

  private double side;

  @Override
  public double getArea() {
    return side * side;
  }
}

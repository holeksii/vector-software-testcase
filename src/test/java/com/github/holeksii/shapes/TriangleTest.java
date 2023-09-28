package com.github.holeksii.shapes;

import org.junit.jupiter.api.Test;

public class TriangleTest {

  @Test
  public void testGetArea() {
    Triangle triangle = new Triangle(5, 8);
    Double area = triangle.getArea();
    Double expected = 20.0;
    assert area.equals(expected);
  }
}

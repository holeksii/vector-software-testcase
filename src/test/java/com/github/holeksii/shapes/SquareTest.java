package com.github.holeksii.shapes;

import org.junit.jupiter.api.Test;

public class SquareTest {

  @Test
  public void testGetArea() {
    Square square = new Square(5);
    Double area = square.getArea();
    Double expected = 25.0;
    assert area.equals(expected);
  }
}

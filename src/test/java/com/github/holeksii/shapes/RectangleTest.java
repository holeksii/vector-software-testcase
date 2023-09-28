package com.github.holeksii.shapes;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RectangleTest {

  @Test
  public void testGetArea() {
    Rectangle rectangle = new Rectangle(5, 10);
    Double area = rectangle.getArea();
    Double expected = 50.0;
    assertTrue(area.equals(expected));
  }
}

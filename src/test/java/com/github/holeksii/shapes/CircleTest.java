package com.github.holeksii.shapes;

import static com.github.holeksii.Utils.nearlyEqual;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CircleTest {

  @Test
  public void testGetArea() {
    Circle circle = new Circle(5);
    Double area = circle.getArea();
    Double expected = 78.5398163397448;
    assertTrue(nearlyEqual(area, expected));
  }
}

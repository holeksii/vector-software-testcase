package com.github.holeksii.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ShapeTest {

  static List<Shape> SHAPES =
      List.of(new Circle(5), new Rectangle(5, 10), new Square(5), new Triangle(5, 8));

  static final List<Shape> SORTED_SHAPES =
      List.of(new Triangle(5, 8), new Square(5), new Rectangle(5, 10), new Circle(5));

  @Test
  public void testComparator() {
    List<Shape> copy = new ArrayList<>(List.copyOf(SHAPES));
    copy.sort(Shape.comparator);
    assert copy.equals(SORTED_SHAPES);
  }

  @Test
  public void testComparable() {
    List<Shape> copy = new ArrayList<>(List.copyOf(SHAPES));
    Collections.sort(copy);
    assert copy.equals(SORTED_SHAPES);
  }
}

package com.github.holeksii.shapes;

import java.util.Comparator;

public interface Shape extends Comparable<Shape> {
  double getArea();

  default int compareTo(Shape other) {
    return Double.compare(this.getArea(), other.getArea());
  }

  static Comparator<Shape> comparator = Shape::compare;

  private static int compare(Shape a, Shape b) {
    return a.compareTo(b);
  }
}

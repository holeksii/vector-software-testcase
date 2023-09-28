package com.github.holeksii;

import java.util.ArrayList;
import java.util.List;
import com.github.holeksii.shapes.*;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>(List.of(
            new Circle(5),
            new Rectangle(5, 10),
            new Square(5),
            new Triangle(5, 10)
        ));

        shapes.forEach(s -> System.out.println(s.getArea()));
        System.out.println();

        shapes.sort(Shape.comparator);

        shapes.forEach(s -> System.out.println(s.getArea()));
    }
}

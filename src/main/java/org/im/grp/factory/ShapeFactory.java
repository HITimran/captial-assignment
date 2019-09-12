package org.im.grp.factory;

import org.im.grp.CalculateAreaService;
import org.im.grp.shapes.Circle;
import org.im.grp.shapes.Shape;
import org.im.grp.shapes.Triangle;

public class ShapeFactory {

    public CalculateAreaService getAreaOf(Shape shape, double[] sides) {
        if (shape != null) {
            switch (shape) {
                case Circle: {
                    return new Circle(sides);
                }
                case Triangle: {
                    return new Triangle(sides);
                }
                default: {
                    throw new IllegalArgumentException("Area of the " + shape.name() + " is not implemented");
                }
            }
        } else {
            throw new NullPointerException("Shapes can't be null");
        }

    }
}

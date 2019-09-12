package org.im.grp.factory;

import org.im.grp.CalculateAreaService;
import org.im.grp.CustomExceptions.ValidationFailException;
import org.im.grp.shapes.Circle;
import org.im.grp.shapes.Shape;
import org.im.grp.shapes.Triangle;

import java.util.Arrays;
import java.util.logging.Logger;


public class ShapeFactory {
    private final static Logger log = Logger.getLogger(ShapeFactory.class.getName());

    public CalculateAreaService getAreaOf(Shape shape, double[] sides) {
        if (hasNegativeSides(sides)) {
            throw new ValidationFailException("areas cannot be formed with negative value/s");
        }
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

    private boolean hasNegativeSides(double[] sides) {
        try {
            return Arrays.stream(sides).filter(i -> i < 0).toArray().length > 0;
        } catch (NullPointerException e) {
            log.info(String.format("The arguments has null values %s ", sides));
            throw new NullPointerException("Sides cannot be null , Please enter a valid parameter");
        }
    }
}

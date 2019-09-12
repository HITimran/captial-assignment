package org.im.grp.shapes;


import org.im.grp.CalculateAreaService;

import java.util.logging.Logger;

public class Circle implements CalculateAreaService {

    private double radius;
    private final static Logger log = Logger.getLogger(Triangle.class.getName());

    public Circle(double[] radius) {

        if (radius.length == 1) {
            this.radius = radius[0];
        } else {
            throw new IllegalArgumentException("Circle require only Radius , extra arguments should be removed");
        }
    }

    @Override
    public double getArea() {
        log.info(String.format("calculating the area of circle with %s radius", radius));
        return Math.PI * radius * radius;
    }
}

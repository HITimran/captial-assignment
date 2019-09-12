package org.im.grp.shapes;


import org.im.grp.CalculateAreaService;

public class Circle implements CalculateAreaService {

    private double radius;

    public Circle(double[] radius) {
        try {
            if (radius.length == 1) {
                this.radius = radius[0];
            } else {
                throw new IllegalArgumentException("Circle require only Radius , please remove extra arguments");
            }
        }catch (NullPointerException e)
        {
            throw new NullPointerException("Please enter a valid radius");
        }

    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

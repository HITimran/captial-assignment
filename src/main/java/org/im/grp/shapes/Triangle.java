package org.im.grp.shapes;

import org.im.grp.CalculateAreaService;
import org.im.grp.CustomExceptions.ValidationFailException;

public class Triangle implements CalculateAreaService {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double[] sides) {
        try {
            if (sides.length == 3) {
                this.sideA = sides[0];
                this.sideB = sides[1];
                this.sideC = sides[2];
            } else {
                throw new IllegalArgumentException("Triangle has 3 sides and not :: " + sides.length + " :: sides");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Possibly all/one among sides are null, we cannot create triangle with null side/s");
        }
    }


    // Function to calculate for validity
    private boolean hasValidSides() {
        // check condition
        return !(sideA + sideB <= sideC)
                && !(sideA + sideC <= sideB)
                && !(sideB + sideC <= sideA);
    }

    @Override
    public double calculateArea() {
        //The area of a triangle is derived using hero's formula
        if (hasValidSides()) {
            //where p is half perimeter of the triangle
            double p = (sideA + sideB + sideC) / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        } else
            throw new ValidationFailException("Triangle should have valid sides , checkout sides again for " + toString());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}

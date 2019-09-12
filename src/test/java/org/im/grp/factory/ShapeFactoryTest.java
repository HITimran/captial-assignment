package org.im.grp.factory;

import org.im.grp.CalculateAreaService;
import org.im.grp.CustomExceptions.ValidationFailException;
import org.im.grp.shapes.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {
    private ShapeFactory shapeFactory;

    private CalculateAreaService area;

    @Before
    public void test() {
        shapeFactory = new ShapeFactory();
    }

    @Test
    public void testTriangleWithValidArguments() {
        double[] sides = {5.0, 6.0, 7.0f};
        area = shapeFactory.getAreaOf(Shape.Triangle, sides);
        Assert.assertNotNull(area);
    }

    @Test
    public void testCircleWithValidArguments() {
        double[] sides = {5.0};
        area = shapeFactory.getAreaOf(Shape.Circle, sides);
        Assert.assertNotNull(area);
    }

    @Test
    public void testForShapesWhenProvidedAsNull() {
        double[] sides = {5.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(null, sides);
        } catch (NullPointerException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Shapes can't be null");
        }
        assertTrue(thrown);
    }

    @Test
    public void testForShapesWhenCalculateAreaServiceNotImplemented() {
        double[] sides = {5.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Square, sides);
        } catch (IllegalArgumentException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Area of the Square is not implemented");
        }
        assertTrue(thrown);
    }

    @Test
    public void testForSidesWhenContainNegativeValue() {
        double[] sides = {-5.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Circle, sides);
        } catch (ValidationFailException e) {
            thrown = true;
            assertEquals(e.getMessage(), "areas cannot be formed with negative value/s");
        }
        assertTrue(thrown);
    }
}
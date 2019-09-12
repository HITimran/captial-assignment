package org.im.grp.factory;

import org.im.grp.CalculateAreaService;
import org.im.grp.shapes.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {
    ShapeFactory shapeFactory;

    @Mock
    CalculateAreaService area;

    @Before
    public void test() {
        shapeFactory = new ShapeFactory();
    }

    @Test
    public void testTriangleWithValidArguments() {
        double[] sides = {5.0, 6.0, 7.0};
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
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Square, null);
        } catch (IllegalArgumentException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Area of the Square is not implemented");
        }
        assertTrue(thrown);
    }
}
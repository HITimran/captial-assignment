package org.im.grp.shapes;

import org.im.grp.CalculateAreaService;
import org.im.grp.factory.ShapeFactory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CircleTest {
    private ShapeFactory shapeFactory;

    CalculateAreaService area;

    @Before
    public void test() {
        shapeFactory = new ShapeFactory();
    }

    @Test
    public void testForAreaOfCircleWhenRadiusIsNull() {
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Circle, null);
        } catch (NullPointerException e) {
            thrown = true;
            assertEquals( "Sides cannot be null , Please enter a valid parameter",e.getMessage());
        }
        assertTrue(thrown);
    }

    @Test
    public void testForAreaOfCircleWhenRadiusIsValid() {
        double[] sides = {8.0};
        area = shapeFactory.getAreaOf(Shape.Circle, sides);
        assertEquals("The area of the Circle should be returned with delta precision of 0.062 ",
                201.0, area.calculateArea(), 0.062);
    }

    @Test
    public void testForAreaOfCircleWithWrongArgument() {
        double[] sides = {0.8, 9.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Circle, sides);
        } catch (IllegalArgumentException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Circle require only Radius , please remove extra arguments");
        }
        assertTrue(thrown);
    }
}
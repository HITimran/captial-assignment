package org.im.grp.shapes;

import org.im.grp.CalculateAreaService;
import org.im.grp.CustomExceptions.ValidationFailException;
import org.im.grp.factory.ShapeFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TriangleTest {

    private ShapeFactory shapeFactory;

    @Mock
    CalculateAreaService area;

    @Before
    public void test() {
        shapeFactory = new ShapeFactory();
    }

    @Test
    public void testForAreaOfTriangleWhenNullSidesArePassed() {
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Triangle, null);
        } catch (NullPointerException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Possibly all/one among sides are null, we cannot create triangle with null side/s");
        }
        assertTrue(thrown);
    }

    @Test
    public void testForExceptionWithAreaOfTriangleWithExtraSides() {

        double[] sides = {8.0, 9, 9.0, 7.9};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Triangle, sides);
        } catch (IllegalArgumentException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Triangle has 3 sides and not :: " + sides.length + " :: sides");
        }
        assertTrue(thrown);
    }

    @Test
    public void testForAreaOfTriangleWhenSidesAreValid() {
        double[] sides = {8.0, 9, 10.0};
        area = shapeFactory.getAreaOf(Shape.Triangle, sides);
        assertEquals("The area of the Triangle should be returned with delta precision of 0.001 ",
                34.197, area.calculateArea(), 0.001);
    }

    @Test
    public void testForExceptionWithInvalidSideAMax() {

        double[] sides = {101.0, 11.0, 5.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Triangle, sides);
            area.calculateArea();
        } catch (ValidationFailException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Triangle should have valid sides , checkout sides again for " + area.toString());
        }
        assertTrue(thrown);
    }

    @Test
    public void testForExceptionWithInvalidSideBMax() {

        double[] sides = {101.0, 1100.0, 5.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Triangle, sides);
            area.calculateArea();
        } catch (ValidationFailException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Triangle should have valid sides , checkout sides again for " + area.toString());
        }
        assertTrue(thrown);
    }

    @Test
    public void testForExceptionWithInvalidSideCMax() {

        double[] sides = {101.0, 11.0, 5000.0};
        boolean thrown = false;
        try {
            area = shapeFactory.getAreaOf(Shape.Triangle, sides);
            area.calculateArea();
        } catch (ValidationFailException e) {
            thrown = true;
            assertEquals(e.getMessage(), "Triangle should have valid sides , checkout sides again for " + area.toString());
        }
        assertTrue(thrown);
    }

}
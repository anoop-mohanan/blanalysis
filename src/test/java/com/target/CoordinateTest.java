package com.target;

import com.target.domain.Coordinate;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testCoordinate() throws Exception {
        Coordinate coordinate = new Coordinate(12, 11);
        Assert.assertEquals(12, coordinate.getX());
        Assert.assertEquals(11, coordinate.getY());
    }

    @Test
    public void testCoordinateWithinField() throws Exception {
        Coordinate coordinate= new Coordinate(10, 10);
        Assert.assertTrue(App.validateRange(coordinate));
    }

    @Test
    public void testCoordinateOutsideField() {
        Coordinate coordinate = new Coordinate(1000,1000);
        Assert.assertFalse(App.validateRange(coordinate));
    }


}

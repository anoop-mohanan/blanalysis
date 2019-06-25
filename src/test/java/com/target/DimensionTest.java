package com.target;

import com.target.domain.Coordinate;
import com.target.domain.Dimension;
import org.junit.Assert;
import org.junit.Test;

public class DimensionTest {
    @Test
    public void testDimension() {
        Dimension dimension = new Dimension();
        Coordinate startCoordinate = new Coordinate();
        startCoordinate.setX(1);
        startCoordinate.setY(1);
        Coordinate endCoordinate = new Coordinate();
        endCoordinate.setX(10);
        endCoordinate.setY(10);
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);



        Dimension expectedDimension = new Dimension();
        Coordinate expectedStartCoordinate = new Coordinate();
        expectedStartCoordinate.setX(1);
        expectedStartCoordinate.setY(1);

        Coordinate expectedEndCoordinate = new Coordinate();
        expectedEndCoordinate.setY(10);
        expectedEndCoordinate.setX(10);

        expectedDimension.setStart(expectedStartCoordinate);
        expectedDimension.setEnd(expectedEndCoordinate);
        Assert.assertEquals(dimension, expectedDimension);

    }

}

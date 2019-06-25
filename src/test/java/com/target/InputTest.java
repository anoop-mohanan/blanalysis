package com.target;

import com.target.domain.Coordinate;
import com.target.domain.Dimension;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This JUnit class tests the conversion of user input into coordinates.
 */
public class InputTest {

    @Test
    public void testSingleCoordinateInput() throws Exception {
        String input = "{\"0 292 399 307\"}";
        List<Dimension> actualDimensions  = App.getDimensions(input);

        Coordinate startCoordinate = new Coordinate(0, 292);
        Coordinate endCoordinate = new Coordinate(399, 307);
        Dimension dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);

        List<Dimension> expectedDimensions = new ArrayList<>();
        expectedDimensions.add(dimension);

        Assert.assertEquals(actualDimensions.size(), expectedDimensions.size());
        Assert.assertTrue(actualDimensions.get(0).equals(expectedDimensions.get(0)));

    }

    @Test
    public void testMultipleCoordinatesInput() throws Exception {
        String input = "{\"48 192 351 207\", \"48 392 351 407\", \"120 52 135 547\", \"260 52 275 547\"}";
        List<Dimension> actualDimensions  = App.getDimensions(input);


        List<Dimension> expectedDimensions = new ArrayList<>();
        Coordinate startCoordinate = new Coordinate(48, 192);
        Coordinate endCoordinate = new Coordinate(351, 207);
        Dimension dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        expectedDimensions.add(dimension);
        startCoordinate = new Coordinate(48, 392);
        endCoordinate = new Coordinate(351, 407);
        dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        expectedDimensions.add(dimension);
        startCoordinate = new Coordinate(120, 52);
        endCoordinate = new Coordinate(135, 547);
        dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        expectedDimensions.add(dimension);
        startCoordinate = new Coordinate(260, 52);
        endCoordinate = new Coordinate(275, 547);
        dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        expectedDimensions.add(dimension);

        Assert.assertEquals(actualDimensions.size(), expectedDimensions.size());
        Assert.assertTrue(actualDimensions.get(0).equals(expectedDimensions.get(0)));
        Assert.assertTrue(actualDimensions.get(1).equals(expectedDimensions.get(1)));
        Assert.assertTrue(actualDimensions.get(2).equals(expectedDimensions.get(2)));
        Assert.assertTrue(actualDimensions.get(3).equals(expectedDimensions.get(3)));
    }
}

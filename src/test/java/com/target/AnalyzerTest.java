package com.target;

import com.target.domain.Coordinate;
import com.target.domain.Dimension;
import com.target.service.Analyzer;
import com.target.util.FieldUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerTest {

    @Test
    public void analyzeSingleBarrenField() throws Exception {
        int [] [] field = new int [400] [600];

        Coordinate startCoordinate = new Coordinate(0, 292);
        Coordinate endCoordinate = new Coordinate(399, 307);
        Dimension dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(dimension);

        //Fill the barren land on the fertile land.
        FieldUtils.fillCoordinates(field, dimensions);

        //Perform analysis.
        List<Integer> areas = Analyzer.analyze(field);

        Assert.assertEquals(2, areas.size());
        Assert.assertEquals(116800, areas.get(0).intValue());
        Assert.assertEquals(116800, areas.get(1).intValue());

    }

    @Test
    public void analyzeMultipleBarrenField() throws Exception {
        int [] [] field = new int [400] [600];

        List<Dimension> dimensions = new ArrayList<>();
        Coordinate startCoordinate = new Coordinate(48, 192);
        Coordinate endCoordinate = new Coordinate(351, 207);
        Dimension dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        dimensions.add(dimension);
        startCoordinate = new Coordinate(48, 392);
        endCoordinate = new Coordinate(351, 407);
        dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        dimensions.add(dimension);
        startCoordinate = new Coordinate(120, 52);
        endCoordinate = new Coordinate(135, 547);
        dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        dimensions.add(dimension);
        startCoordinate = new Coordinate(260, 52);
        endCoordinate = new Coordinate(275, 547);
        dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        dimensions.add(dimension);

        //Fill the barren land on the fertile land.
        FieldUtils.fillCoordinates(field, dimensions);

        //Perform analysis.
        List<Integer> areas = Analyzer.analyze(field);

        Assert.assertEquals(2, areas.size());
        Assert.assertEquals(22816, areas.get(0).intValue());
        Assert.assertEquals(192608, areas.get(1).intValue());
        Assert.assertTrue(areas.get(0).intValue() < areas.get(1).intValue());
    }

}

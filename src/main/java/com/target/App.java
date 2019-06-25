package com.target;

import com.target.domain.Coordinate;
import com.target.domain.Dimension;
import com.target.exception.CoordinateOutOfBoundsException;
import com.target.service.Analyzer;
import com.target.util.FieldUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This application performs the barren land analysis.
 * The field is of the size 400 x 600
 * The user inputs the set of start and end coordinates representing rectangles on the graph.
 *
 * Note: Assumption, is that the user enters valid values.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //define the field.
        int [] [] field = new int [400] [600];

        Scanner scanner = new Scanner(System.in);

        System.out.println("BARREN LAND ANALYSIS");
        System.out.println("Land Area: 400 x 600");
        System.out.print("Please enter the coordinates : ");
        //Read input from the user.
        String input = scanner.nextLine();

        //Convert the input to a list of dimensions.
        List<Dimension> dimensions = getDimensions(input);

        //Fill the barren land on the fertile land.
        FieldUtils.fillCoordinates(field, dimensions);

        //Perform analysis.
        List<Integer> areas = Analyzer.analyze(field);

        //Print area of fertile land in the increasing order.
        System.out.println("Fertile area from smallest to greatest");
        areas.stream().forEach( a -> System.out.println(a));
    }

    /**
     * This method takes the user input.
     * @param input - Set of coordinates.
     * @return - List of dimensions.
     */
    public static List<Dimension> getDimensions(String input) {
        List<Dimension> inputDimensions = new ArrayList<>();

        //refine input string.
        input = input.replace("\"", "").replace("{", "").replace("}", "");

        String [] tokens = input.split(",");

        for (int i = 0; i < tokens.length; i++) {
            inputDimensions.add(getDimension(tokens[i].trim()));
        }

        return inputDimensions;
    }

    /**
     * This method will convert string containing the bottom left corner and the top right corner of the rectangle.
     * @param input String having the coordinates in the format [startx starty endx endy]
     * @return - Dimension representing the bottom left and top right corner of the rectangle.
     */
    public static Dimension getDimension(String input) {
        String [] tokens = input.split(" ");
        if(tokens.length != 4) {
            throw new RuntimeException("Invalid Coordinate  : " + input);
        }

        Coordinate startCoordinate = new Coordinate(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
        Coordinate endCoordinate = new Coordinate(Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
        if(!(validateRange(startCoordinate) && validateRange(endCoordinate))) {
            throw new CoordinateOutOfBoundsException("Invalid coordinates provided.");
        }
        Dimension dimension = new Dimension();
        dimension.setStart(startCoordinate);
        dimension.setEnd(endCoordinate);
        return dimension;
    }

    /**
     * This method checks if the coordinate is within the field of 400 x 600
     * @param coordinate - Coordinate to be tested.
     * @return - true if valid, false otherwise.
     */
    public static boolean validateRange(Coordinate coordinate) {
        boolean isValidCoordinate = true;
        if(coordinate.getX() < 0 || coordinate.getY() > 399) {
            isValidCoordinate = false;
        } else if(coordinate.getY() < 0 || coordinate.getY() > 599) {
            isValidCoordinate = false;
        }
        return isValidCoordinate;
    }

}

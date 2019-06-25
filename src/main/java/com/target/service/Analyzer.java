package com.target.service;

import com.target.domain.Coordinate;

import java.util.*;

/**
 * This method performs the Barren Land Analysis via the Breadth First Search Approach.
 */
public class Analyzer {


    /**
     * This method accepts a fertile field with/without barren sections of land
     * @param field - Field to be analyzed.
     * @return - Area of fertile land smallest to the largest.
     */
    public static List<Integer> analyze(int [][] field) {
        int [][] visited = new int [field.length][field[0].length];
        Queue<Coordinate> queue = new LinkedList<>();

        Coordinate coordinate = null;
        List<Integer> areaList = new ArrayList<>();

        for(int x = 0; x< field.length; x++) {
            for(int y=0; y< field[0].length; y++) {
                coordinate = new Coordinate(x, y);

                if(field[coordinate.getX()][coordinate.getY()] == 0 && visited[coordinate.getX()][coordinate.getY()] == 0) {
                    visited[coordinate.getX()][coordinate.getY()] = 1;
                    queue.offer(coordinate);
                    areaList.add(traverse(field, visited, queue));
                } else if(field[coordinate.getX()][coordinate.getY()] == 1) {
                    visited[coordinate.getX()][coordinate.getY()] = 1;
                }

            }
        }
        Collections.sort(areaList);
        return areaList;
    }

    /**
     * This method traverses the field from the coordinate provided in the queue.
     * @param field - Field to be traversed.
     * @param visited - The field replica that records the coordinates of the field that have been visited.
     * @param queue - The coordinates that are to be traversed from to the neighbouring coordinates.
     * @return - the fertile area of the field to which this coordinate belongs to.
     */
    private static Integer traverse(int [] [] field, int [] [] visited, Queue<Coordinate> queue) {
        Integer area = 1;
        while(queue.peek() != null) {
            Coordinate edge = queue.poll();
            List<Coordinate> adjacent = getAdjacentCoordinates(field, edge);
            for(Coordinate coordinate : adjacent) {
                if (visited[coordinate.getX()][coordinate.getY()] == 0 && field[coordinate.getX()][coordinate.getY()] == 0) {
                    queue.offer(coordinate);
                    visited[coordinate.getX()][coordinate.getY()] = 1;
                    area = area + 1;
                }
            }
        }
        return area;
    }

    /**
     * This method determines the neighbours of the given coordinate.
     * @param field - The field
     * @param coordinate - coordinate whose neighbours are to be determined.
     * @return - adjacent coordinates.
     */
    private static List<Coordinate> getAdjacentCoordinates(int [] [] field, Coordinate coordinate) {
        List<Coordinate> adjacentList = new ArrayList<>();

        if(((coordinate.getX()) >= 0 && (coordinate.getX()) < field.length) && ((coordinate.getY() - 1) >= 0 && (coordinate.getY() - 1) < field[0].length)) {
            adjacentList.add(new Coordinate(coordinate.getX(), coordinate.getY() - 1));
        }

        if(((coordinate.getX() + 1) >= 0 && (coordinate.getX() + 1) < field.length) && ((coordinate.getY()) >= 0 && (coordinate.getY()) < field[0].length)) {
            adjacentList.add(new Coordinate(coordinate.getX() + 1, coordinate.getY()));
        }

        if(((coordinate.getX()) >= 0 && (coordinate.getX()) < field.length) && ((coordinate.getY() + 1) >= 0 && (coordinate.getY() + 1) < field[0].length)) {
            adjacentList.add(new Coordinate(coordinate.getX(), coordinate.getY() + 1));
        }

        if(((coordinate.getX() - 1) >= 0 && (coordinate.getX() - 1) < field.length) && ((coordinate.getY()) >= 0 && (coordinate.getY()) < field[0].length)) {
            adjacentList.add(new Coordinate(coordinate.getX() - 1, coordinate.getY()));
        }

        return adjacentList;
    }
}

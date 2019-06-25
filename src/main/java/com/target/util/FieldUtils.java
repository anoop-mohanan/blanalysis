package com.target.util;


import com.target.domain.Dimension;

import java.util.List;

/**
 * This class provides utility methods for printing and filling the field.
 */
public class FieldUtils {

    /**
     * This method fills the barren sections of the land.
     * @param field - field
     * @param dimensions - dimensions of barren land.
     * @return
     */
    public static void fillCoordinates(int [] [] field, List<Dimension> dimensions) {

        for(Dimension d : dimensions) {
            for(int i=d.getStart().getX();i<= d.getEnd().getX(); i++) {
                for(int j=d.getStart().getY(); j<= d.getEnd().getY(); j++) {
                    field [i] [j] = 1;
                }
            }
        }
    }

    /**
     * This method will print the field.
     * @param field - Field to be printed.
     */
    public static void printField(int [] [] field) {
        for(int i = 0; i< field.length; i++) {
            for(int j=field[0].length -1; j >= 0; j --) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

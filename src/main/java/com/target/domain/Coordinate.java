package com.target.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents a 2-D coordinate.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Coordinate {
    private int x;
    private int y;
}

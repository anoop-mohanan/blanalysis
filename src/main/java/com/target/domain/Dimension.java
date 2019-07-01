package com.target.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents the Dimension of the rectangle.
 */

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Dimension {

    private Coordinate start;
    private Coordinate end;
}

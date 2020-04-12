package com.esiea.tp4A.domain;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rightSide() {
        if (ordinal()+1 == 4)
            return NORTH;
        else
            return Direction.values()[ordinal()+1];
    }

    public Direction leftSide() {
        if (ordinal()-1 == -1)
            return WEST;
        else
            return Direction.values()[ordinal()-1];
    }

    public Direction getOppositeDirection(){
        return values()[(this.ordinal()+2)%4];
    }
    }

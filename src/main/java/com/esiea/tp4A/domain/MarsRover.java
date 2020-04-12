package com.esiea.tp4A.domain;

public interface MarsRover {
    default MarsRover initPos(Position position) {
        return this;
    }
    default MarsRover reviseMap(PlanetMap map) {
        return this;
    }
    default MarsRover setLaserConf(int range) {
        return this;
    }
    default Position move(String command){
        return Position.of(0, 0, Direction.NORTH);
    }
}

package com.esiea.tp4A.domain;

public interface MarsRover {
     MarsRover initPos(Position position) ;
     MarsRover reviseMap(PlanetMap map);
     MarsRover setLaserConf(int range);
     Position move(String command);
}

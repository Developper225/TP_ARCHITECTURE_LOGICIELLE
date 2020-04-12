package com.esiea.tp4A.domain;

public class MovingRover implements MarsRover {

    private final Position position;
    private final PlanetMap planetMap;
    private final int laserRange;

    public MovingRover(Position position, int laserRange, PlanetMap planetMap) {
        this.position = position;
        this.laserRange = laserRange;
        this.planetMap = planetMap;
    }
@Override
    public MarsRover initPos(Position position) {
        return new MovingRover(position, this.laserRange, planetMap);
    }
@Override
    public MarsRover reviseMap(PlanetMap planetMap) {
        return new MovingRover(this.position, this.laserRange, planetMap);
    }
@Override
    public MarsRover setLaserConf(int range) {
        return new MovingRover(this.position, range, planetMap);
    }

    @Override
    public Position move(String command) {
        Position posit = position;
        Direction direction = posit.getDirection();
        for (char instruction : (command.toLowerCase()).toCharArray()) {
            switch (instruction) {
                case 'f':
                    posit = posit.movingPosition(posit.getX(), posit.getY(), direction, planetMap);
                    break;
                case 'b':
                    posit = posit.movingPosition(posit.getX(), posit.getY(), direction.getOppositeDirection(), planetMap);
                    break;
                case 'l':
                    direction = direction.leftSide();
                    break;
                case 'r':
                    direction = direction.rightSide();
                    break;
                    case 's':
                    this.shoot();
                    break;
                default:
                    throw new InvalidCommandException("Commande " + command + " invalide");
            }
        }
        return new Position.FixedPosition(posit.getX(), posit.getY(), direction);
    }

    private void shoot() {
        Position previousPosition = this.position;
        Position tempPosition;
        for (int i=1; i<=laserRange; i++){
            tempPosition = this.move("f");
            if(tempPosition.equals(previousPosition)){
                for (Position position : this.planetMap.obstaclePositions()) {
                    this.planetMap.deleteObstacle(position);
                }
                break;
            } previousPosition = tempPosition;
        }
    }

}

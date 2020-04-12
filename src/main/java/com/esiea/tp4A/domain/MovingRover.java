package com.esiea.tp4A.domain;

public class MovingRover implements MarsRover {


    private Position position;
    private  int laserRange;
    private PlanetMap planetMap;
    MovingRover(int x, int y, Direction direction) {
        position = Position.of(x,y,direction);
    }

    @Override
    public Position move(String command) {

        int xPosition = position.getX();
        int yPosition = position.getY();
        Direction direction = position.getDirection();
        //String dPosition = direction;
        switch(position.getDirection()) {

            case NORTH:
                switch ((command.toLowerCase())) {
                    case "f":
                        yPosition = yPosition + 1;

                        break;
                    case "b":
                        yPosition = yPosition - 1;

                        break;
                    case "l":
                        direction = Direction.WEST;

                        break;
                    case "r":
                        direction = Direction.EAST;

                        break;
                }
                break;

            case EAST:
                switch ((command.toLowerCase())) {
                    case "f":
                        xPosition = xPosition + 1;


                        break;
                    case "b":
                        xPosition = xPosition - 1;


                        break;
                    case "l":
                        direction = Direction.NORTH;


                        break;
                    case "r":
                        direction = Direction.SOUTH;

                        break;
                }
                break;


            case SOUTH:
                switch ((command.toLowerCase())) {
                    case "f":
                        yPosition = yPosition - 1;


                        break;
                    case "b":
                        yPosition = yPosition + 1;


                        break;
                    case "l":
                        direction = Direction.EAST;


                        break;
                    case "r":
                        direction = Direction.WEST;

                        break;
                }
                break;

            case WEST:
                switch ((command.toLowerCase())) {
                    case "f":
                        xPosition = xPosition - 1;

                        break;
                    case "b":
                        xPosition = xPosition + 1;


                        break;
                    case "l":
                        direction = Direction.SOUTH;


                        break;
                    case "r":
                        direction = Direction.NORTH;

                        break;
                }
                break;
            default:
                throw new InvalidCommandException("Commande" + command + "inconnue");

        }
        position = Position.of(xPosition,yPosition,direction);

        return new Position.FixedPosition(position.getX(),position.getY(),position.getDirection());
    }
}

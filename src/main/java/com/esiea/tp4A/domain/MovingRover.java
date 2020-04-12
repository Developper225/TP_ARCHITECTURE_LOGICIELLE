package com.esiea.tp4A.domain;

public class MovingRover implements MarsRover {


    Position position;

    public MovingRover(int x, int y, Direction direction) {
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
                if ((command.toLowerCase()).equals("f")) {
                    yPosition = yPosition + 1;

                } else if ((command.toLowerCase()).equals("b")) {
                    yPosition = yPosition - 1;

                } else if ((command.toLowerCase()).equals("l")) {
                    direction = Direction.WEST;

                } else if ((command.toLowerCase()).equals("r")) {
                    direction = Direction.EAST;

                } break;

            case EAST:
                if ((command.toLowerCase()).equals("f")) {
                    xPosition = xPosition + 1;


                } else if ((command.toLowerCase()).equals("b")) {
                    xPosition = xPosition - 1;


                } else if ((command.toLowerCase()).equals("l")) {
                    direction = Direction.NORTH;


                } else if ((command.toLowerCase()).equals("r")) {
                    direction = Direction.SOUTH;

                } break;


            case SOUTH:
                if ((command.toLowerCase()).equals("f")) {
                    yPosition = yPosition - 1;


                } else if ((command.toLowerCase()).equals("b")) {
                    yPosition = yPosition + 1;


                } else if ((command.toLowerCase()).equals("l")) {
                    direction = Direction.EAST;


                } else if ((command.toLowerCase()).equals("r")) {
                    direction = Direction.WEST;

                } break;

            case WEST:
                if ((command.toLowerCase()).equals("f")) {
                    xPosition = xPosition-1;

                } else if ((command.toLowerCase()).equals("b")) {
                    xPosition = xPosition + 1;


                } else if ((command.toLowerCase()).equals("l")) {
                    direction = Direction.SOUTH;


                } else if ((command.toLowerCase()).equals("r")) {
                    direction = Direction.NORTH;

                } break;
            default:
                throw new InvalidCommandException("Commande" + command + "inconnue");

        }
        position = Position.of(xPosition,yPosition,direction);
        Position.FixedPosition fixedPosition = new Position.FixedPosition(position.getX(),position.getY(),position.getDirection());

        return fixedPosition;
    }
}

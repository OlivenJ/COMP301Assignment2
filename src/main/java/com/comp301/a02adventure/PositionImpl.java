package com.comp301.a02adventure;

public class PositionImpl implements Position {
    int X;
    int Y;

    public PositionImpl(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    //TODO Some doubt about this implementation
    public Position getNeighbor(Direction direction) {
        int currentX = this.getX();
        int currentY = this.getY();
        int newX = 0;
        int newY = 0;

        if (direction == Direction.NORTH) {
            newX = currentX;
            newY = currentY + 1;
        } else if (direction == Direction.EAST) {
            newX = currentX + 1;
            newY = currentY;
        } else if (direction == Direction.WEST) {
            newX = currentX - 1;
            newY = currentY;
        } else if (direction == Direction.SOUTH) {
            newX = currentX;
            newY = currentY - 1;
        }

        Position newPosition = new PositionImpl(newX, newY);
        return newPosition;
    }
}

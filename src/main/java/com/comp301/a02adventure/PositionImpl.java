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

    //TODO not implement yet;
    public Position getNeighbor(Direction direction) {
        return null;
    }
}

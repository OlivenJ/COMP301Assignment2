package com.comp301.a02adventure;

public class MapImpl implements Map {

    private int width;
    private int height;
    private final int numItems;

    private Cell[][] grid;


    public MapImpl(int width, int height, int numItems) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("The dimensions of the map should be non-negative.");
        }

        this.width = width;
        this.height = height;
        this.numItems = numItems;

        this.grid = new Cell[width][height];

    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Cell getCell(int x, int y) {
        if (x > this.width || y > this.height) {
            throw new IndexOutOfBoundsException("The location is out of the map's boundary.");
        }

        return grid[x][y];

    }

    public Cell getCell(Position position) {
        int currentX = position.getX();
        int currentY = position.getY();

        if (currentX > this.width || currentY > this.height) {
            throw new IndexOutOfBoundsException("The location is out of the map's boundary.");
        }

        return grid[currentX][currentY];

    }

    public void initCell(int x, int y) {

        if (x > this.width || y > this.height) {

            throw new IndexOutOfBoundsException("The location is out of the map's boundary");
        }

        Cell newCell = new CellImpl(x, y);
        grid[x][y] = newCell;
    }

    public int getNumItems() {
        return this.numItems;
    }
}

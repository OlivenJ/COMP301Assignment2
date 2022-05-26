package com.comp301.a02adventure;

public class CellImpl implements Cell {
    private Position position;
    private String name;
    private String description;

    private Inventory chest;

    private boolean visited = false;


    public CellImpl(int x, int y, String name, String description) {
        this.position = new PositionImpl(x, y);

        if (name == null || description == null) {
            throw new IllegalArgumentException("The values for both name and description should not be null");
        }

        this.name = name;
        this.description = description;
    }

    public CellImpl(int x, int y) {
        this(x, y, "", "");
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Position getPosition() {
        return this.position;
    }

    public Inventory getChest() {
        return this.chest;
    }

    public boolean getIsVisited() {
        return this.visited;
    }

    public boolean hasChest() {
        if (this.chest == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChest(Inventory chest) {
        this.chest = chest;
    }

    public void visit() {
        this.visited = true;
    }
}

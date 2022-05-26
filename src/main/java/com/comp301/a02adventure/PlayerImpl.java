package com.comp301.a02adventure;

public class PlayerImpl implements Player {

    private Position position;
    private String name;
    private Inventory inventory;

    public PlayerImpl(String name, int startX, int startY) {
        this.position = new PositionImpl(startX, startY);

        if (name == null) {
            throw new IllegalArgumentException("Name must be string.");
        }
        
        this.name = name;
    }

    public Position getPosition() {
        return this.position;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public String getName() {
        return this.name;
    }

    public void move(Direction direction) {
        this.position = this.position.getNeighbor(direction);
    }
}

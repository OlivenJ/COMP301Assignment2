package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {

    private Map map;
    private Player player;

    public GameImpl(Map map, Player player) {
        if (map == null || player == null) {
            throw new IllegalArgumentException("The values of the arguments should not be null.");

        }

        this.map = map;
        this.player = player;
    }

    public Position getPlayerPosition() {

        return player.getPosition();

    }

    public String getPlayerName() {
        return player.getName();
    }

    public List<Item> getPlayerItems() {
        return player.getInventory().getItems();
    }

    public boolean getIsWinner() {
        int holdItemNum = player.getInventory().getNumItems();

        return holdItemNum >= map.getNumItems();
    }

    public void printCellInfo() {
        Position currentPos = this.player.getPosition();
        Cell currentCell = this.map.getCell(currentPos);

        String cellName = currentCell.getName();
        String cellDescription = currentCell.getDescription();
        boolean cellVisited = currentCell.getIsVisited();
        boolean cellHasChest = currentCell.hasChest();

        System.out.println("Location:" + cellName);
        System.out.println(cellDescription);
        if (cellVisited) {
            System.out.println("You have already visited this location.");
        }

        if (cellHasChest) {
            System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
        }

        currentCell.visit();
    }

    public void openChest() {
        Position currentPos = this.player.getPosition();
        Cell currentCell = this.map.getCell(currentPos);

        if (currentCell.hasChest()) {
            if (currentCell.getChest().isEmpty()) {
                System.out.println("The chest is empty.");
            } else {
                player.getInventory().transferFrom(currentCell.getChest());
                System.out.println("You collected these items: " + currentCell.getChest().getItems());
            }
        } else {
            System.out.println("No chest to open, sorry!");
        }

    }

    public boolean canMove(Direction direction) {
        Position currentPos = this.player.getPosition();
        int maxX = this.map.getWidth();
        int maxY = this.map.getHeight();

        Position nextPos = currentPos.getNeighbor(direction);
        int newX = nextPos.getX();
        int newY = nextPos.getY();

        if (newX <= maxX && newY <= maxY) {
            if (this.map.getCell(newX, newY) != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void move(Direction direction) {
        if (canMove(direction)) {
            this.player.move(direction);
            this.printCellInfo();
        } else {
            System.out.println("You can't go that way! Try another direction.");
        }

    }
}

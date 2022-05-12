package com.comp301.a02adventure;

import java.util.ArrayList;

public class InventoryImpl implements Inventory {

    private ArrayList<Item> bag;

    public InventoryImpl() {
        this.bag = new ArrayList<Item>();
    }

    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    public int getNumItems() {
        return bag.size();
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> cloneBag = new ArrayList<Item>();
        cloneBag.addAll(this.bag);
        return cloneBag;
    }

    public void addItem(Item item) {
        bag.add(item);
    }

    public void removeItem(Item item) {
        bag.remove(item);
    }

    public void clear() {
        bag.clear();
    }

    public void transferFrom(Inventory other) {
        ArrayList<Item> interm = (ArrayList<Item>) other.getItems();
        other.clear();
        bag.addAll(interm);
    }
}

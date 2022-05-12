package com.comp301.a02adventure;

public class ItemImpl implements Item {

    final String name;

    public ItemImpl(String name) {

        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("The name must be string.");
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Item obj) {
        return this.getName().equals(obj.getName());
    }

    public String toString() {
        return getName();
    }
}

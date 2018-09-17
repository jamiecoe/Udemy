package com.jamiecoe;

import java.util.ArrayList;
import java.util.List;

public class Flat implements Saveable {

    private String type;
    private List<String> savedItems;

    public Flat() {
        this.type = "Flat";
        this.savedItems = new ArrayList<String>();
    }

    @Override
    public List<String> getSavedItems() {
        return this.savedItems;
    }

    @Override
    public void setSavedItems(List<String> newSavedItems) {
        this.savedItems = newSavedItems;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();

        description
                .append(this.type)
                .append("\n");

        for (String item: this.savedItems) {
            description
                    .append(item)
                    .append("\n");
        }

        return description.toString();
    }
}

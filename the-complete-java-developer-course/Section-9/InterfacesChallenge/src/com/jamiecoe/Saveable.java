package com.jamiecoe;

import java.util.List;

public interface Saveable {
    List<String> getSavedItems();
    void setSavedItems(List<String> itemList);
}

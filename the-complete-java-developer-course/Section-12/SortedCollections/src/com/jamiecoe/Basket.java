package com.jamiecoe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    // Key is StockItem, value is quantity in basket
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        this.basketList = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = basketList.getOrDefault(item, 0);
            basketList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(basketList);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + basketList.size() + " items\n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item :
                basketList.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}

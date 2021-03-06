package com.jamiecoe;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    // key is StockItem, value is quantity in basket
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        // TreeMap's will sort your values automatically when values, using your compareTo method
        // It is therefore less efficient than a HashMap or LinkedHashMap
        this.basketList = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = basketList.getOrDefault(item, 0);
            basketList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public boolean removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = basketList.getOrDefault(item, 0);
            int leftOverAmount = inBasket - quantity;
            if (leftOverAmount > 0) {
                basketList.put(item, leftOverAmount);
                return true;
            } else if (leftOverAmount == 0) {
                basketList.remove(item);
                return true;
            }

            return false;
        }

        return false;
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(basketList);
    }

    public void checkoutBasket() {
        for(Map.Entry<StockItem, Integer> item: basketList.entrySet()) {
            StockItem stockItem = item.getKey();
            int reservedQuantity = item.getValue();

            stockItem.adjustStock(-reservedQuantity);
            stockItem.adjustReserveStock(-reservedQuantity);

            basketList.remove(stockItem, reservedQuantity);
        }
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + basketList.size() + (basketList.size() != 1 ? " items\n" : " item\n");
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item :
                basketList.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}

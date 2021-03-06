package com.jamiecoe;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        // LinkedHashMap will retain order in which items are added (unlike regular HashMap)
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // getOrDefault either returns list.get(item.getName())
            // or if that's not available, it will return item
            // so we're checking if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);

            // If there are already stocks of this item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            // Then add item to list (overwriting previous entry if it was already there)
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        int availableStock = inStock.quantityInStock() - inStock.quantityReserved();

        if (
            (inStock != null) &&
            (availableStock >= quantity) &&
            (quantity > 0)
        ) {
            inStock.adjustReserveStock(quantity);
            return quantity;
        }

        return 0;
    }

    public int returnStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        int reservedQuantity = inStock.quantityReserved() - quantity;

        if ((inStock != null) && (reservedQuantity >= 0)) {
            inStock.adjustReserveStock(-quantity);
            return quantity;
        }

        return 0;
    }

    public StockItem getStockItem(String key) {
        return list.get(key);
    }

    public Map<String, Double> getPriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : this.list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> getItems() {
        // Stops anyone editing the list outside this class
        // if they try to, the program will throw an error
        // Remember that it is only the Collection which is unmodifiable
        // The objects inside the collection can be accessed and modified
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s += stockItem + ". There are " + stockItem.quantityInStock() + " in stock. There are "
                    + stockItem.quantityReserved()
                    + " reserved. Value of item: ";

            // We'll format value so it's to 2 decimal places and f means its a floating number
            s += String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}

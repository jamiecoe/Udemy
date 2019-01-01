package com.jamiecoe;

public class MainChallenge {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        Basket jamiesBasket = new Basket("Jamie's Basket");
        Basket stevesBasket = new Basket("Steve's Basket");
        reserveItem(jamiesBasket, "car", 1);
        reserveItem(jamiesBasket, "car", 1);

        reserveItem(stevesBasket, "towel", 1);

        System.out.println(jamiesBasket);
        System.out.println(stevesBasket);
        System.out.println(stockList);

        unreserveItem(jamiesBasket, "car", 1);
        unreserveItem(jamiesBasket, "towel", 1);

        System.out.println(jamiesBasket);
        System.out.println(stevesBasket);
        System.out.println(stockList);
    }

    public static void reserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
        }

        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
        }
    }

    public static void unreserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
        }

        if (basket.removeFromBasket(stockItem, quantity)) {
            stockList.returnStock(item, quantity);
        }
    }
}

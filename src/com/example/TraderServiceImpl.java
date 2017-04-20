package com.example;

import javafx.util.Pair;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by admin on 4/19/17.
 */
public class TraderServiceImpl implements TraderService {

    Random random = new Random();
    private Map<String, Stock> stocks = new HashMap<>();
    private List<Trade> trades = new ArrayList<>();


    @Override
    public synchronized void addShares(String stockName, int numShares, int price) {
        Stock stock = stocks.get(stockName);

        if (stock == null) {
            //create a stock and add to the map
            Stock stock1 = new Stock(stockName, price, numShares);
            stocks.put(stockName, stock1);

        } else {
            //add the numShares to exisiting stock
            int newNumofShares = numShares + stock.getNumShare();
            Stock stock1 = new Stock(stockName, price, newNumofShares);
            stocks.put(stockName, stock1);
        }
    }

    @Override
    public synchronized Stock getStock(String stockName) {
        return stocks.get(stockName);
    }

    @Override  //locking the whole method
    public synchronized Trade buyShares(String traderName, String stockName, int numShares, int price) throws SharesException {
        Stock stock = new Stock(stockName, numShares, price);

        if (stock == null) {
            throw new SharesException();
        }

        int sharesAfterBuying = numShares - stock.getNumShare();
        Stock stock1 = new Stock(stockName, sharesAfterBuying, price);
        stocks.put(stockName, stock1);

        LocalDateTime timeOfTrade = LocalDateTime.now();
        Trade trade = new Trade(stockName, price, numShares, traderName, timeOfTrade);
        trades.add(trade);

        return trade;
    }

    @Override
    public void clearStocks() {
        stocks.clear();
    }

    @Override
    public List<Trade> getTrades() {
        return trades;
    }

    @Override
    public String toString() {
        return "TraderServiceImpl{" +
                "stocks=" + stocks +
                '}';
    }
}

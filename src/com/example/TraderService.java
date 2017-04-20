package com.example;

import java.util.List;

/**
 * Created by admin on 4/19/17.
 */
public interface TraderService {

        void addShares(String stockName, int numShares, int price);
        Stock getStock(String stockName);
        Trade buyShares(String traderName, String stockName, int numShares, int price) throws SharesException;
        void clearStocks();
        List<Trade> getTrades();
    }



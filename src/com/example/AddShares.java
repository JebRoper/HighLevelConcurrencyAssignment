package com.example;

import java.util.concurrent.Callable;

/**
 * Created by admin on 4/19/17.
 */
public class AddShares implements Callable<String> {

    private TraderServiceImpl traderService;
    private String stockName;
    private int numShares;
    private int stockPrice;

    public AddShares(TraderServiceImpl traderService, String stockName, int numShares, int stockPrice) {
        this.traderService = traderService;
        this.stockName = stockName;
        this.numShares = numShares;
        this.stockPrice = stockPrice;
    }

    @Override
    public String call() throws Exception {
        System.out.println("A");
        traderService.addShares(stockName, numShares,stockPrice);
        //System.out.println(traderService);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            //do nothing
        }
        return "Added " + numShares + " shares at $" + stockPrice + " for stock " + stockName;
    }

}
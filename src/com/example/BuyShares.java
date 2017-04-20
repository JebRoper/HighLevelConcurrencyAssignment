package com.example;

import java.util.concurrent.Callable;

/**
 * Created by admin on 4/19/17.
 */
public class BuyShares implements Callable<String> {

    private TraderServiceImpl traderService;
    private String traderName;
    private String stockName;
    private int numShares;
    private int price;

    public BuyShares(TraderServiceImpl traderService, String traderName, String stockName, int numShares, int price) {
        this.traderService = traderService;
        this.traderName = traderName;
        this.stockName = stockName;
        this.numShares = numShares;
        this.price = price;
    }

    @Override
    public String call() {
        System.out.println("B");
            try {
                traderService.buyShares(traderName, stockName, numShares, price);
            } catch (SharesException e) {
                System.out.println(e);  //return e.getMessage();
            }
            System.out.println(traderService);
            try {
                Thread.sleep(1500L);
            } catch (InterruptedException e) {
                //do nothing
            }
        return "The trader " + traderName + " bought " + stockName + " at " + numShares + " number of shares at $" + price ;
    }

    }


package com.example;

import java.util.concurrent.Callable;

/**
 * Created by admin on 4/19/17.
 */
public class GetShares implements Callable<String> {

    private String stockName;
    private TraderServiceImpl traderService;

    public GetShares(String stockName, TraderServiceImpl traderService) {
        this.stockName = stockName;
        this.traderService = traderService;
    }

    @Override
    public String call() {
        System.out.println("G");
        Stock stock = traderService.getStock(stockName);
        System.out.println(stock);
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            //do nothing
        }
        return "Got stock " + stockName;
    }

}


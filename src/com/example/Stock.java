package com.example;

/**
 * Created by admin on 4/19/17.
 */
public class Stock {

    private String tradingName;
    private int pricePerShare;
    private int numShare;

    public Stock(String tradingName, int pricePerShare, int numShare) {
        this.tradingName = tradingName;
        this.pricePerShare = pricePerShare;
        this.numShare = numShare;
    }

    public String getTradingName(String abc) {
        return tradingName;
    }

    public int getPricePerShare() {
        return pricePerShare;
    }

    public int getNumShare() {
        return numShare;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "tradingName='" + tradingName + '\'' +
                ", pricePerShare=" + pricePerShare +
                ", numShare=" + numShare +
                '}';
    }
}

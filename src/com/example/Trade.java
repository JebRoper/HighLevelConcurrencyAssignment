package com.example;

import java.time.LocalDateTime;

/**
 * Created by admin on 4/19/17.
 */
public final class Trade extends Stock {

    private String whoMadeTrade;
    private LocalDateTime localDateTime;

    public Trade(String tradingName, int pricePerShare, int numShare, String whoMadeTrade, LocalDateTime localDateTime) {
        super(tradingName, pricePerShare, numShare);
        this.whoMadeTrade = whoMadeTrade;
        this.localDateTime = localDateTime;
    }

    public String getWhoMadeTrade() {
        return whoMadeTrade;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return super.toString() +"Trade{" +
                "whoMadeTrade='" + whoMadeTrade + '\'' +
                ", localDateTime=" + localDateTime +
                '}' ;

    }   //TODO call super tostring
}

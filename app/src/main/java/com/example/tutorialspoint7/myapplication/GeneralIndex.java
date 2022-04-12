package com.example.tutorialspoint7.myapplication;

public class GeneralIndex {

    private String title;
    private String trades;
    private String volume;
    private String amount;
    private Company company;

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getTrades() {
        return trades;
    }

    public void setTrades(String trades) {
        this.trades = trades;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

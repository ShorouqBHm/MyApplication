package com.example.tutorialspoint7.myapplication;

public class GeneralIndex {

    private String name;
    private  double trades;
    private double volume;
    private  double amount;
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTrades() {
        return trades;
    }

    public void setTrades(double trades) {
        this.trades = trades;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

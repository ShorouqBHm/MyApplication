package com.example.tutorialspoint7.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Trade {


    private String name;
    private  double askP;
   private double lastP;
   private  double bidP;
    private double highP;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAskP() {
        return askP;
    }

    public void setAskP(double askP) {
        this.askP = askP;
    }

    public double getLastP() {
        return lastP;
    }

    public void setLastP(double lastP) {
        this.lastP = lastP;
    }

    public double getBidP() {
        return bidP;
    }

    public void setBidP(double bidP) {
        this.bidP = bidP;
    }

    public double getHighP() {
        return highP;
    }

    public void setHighP(double highP) {
        this.highP = highP;
    }
}

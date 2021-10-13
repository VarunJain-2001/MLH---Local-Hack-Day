package com.example.don8;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction implements Serializable {
    private final String name;
    private final String date;
    private final String status;
    private final int image;

    public Transaction(String name, String date, String status, int image) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.image = image;

    }

    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
    public int getImage() { return image; }
    @Override
    public String toString() { return "Charity: " + name + "\nStatus: " + status + "\nDate:" + date; }
}

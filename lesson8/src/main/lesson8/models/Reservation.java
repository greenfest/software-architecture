package src.main.lesson8.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;
    private final int id;

    private Table table;

    private Date date;
    private String name;

    private boolean isCancelled = false;

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        isCancelled = true;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    {
        id = ++counter;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }

}
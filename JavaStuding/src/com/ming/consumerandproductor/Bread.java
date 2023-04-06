package com.ming.consumerandproductor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Bread {
    private int codeid;
    private String name;
    private double price;
    private Date date;

    public int getCodeid() {
        return codeid;
    }

    public void setCodeid(int codeid) {
        this.codeid = codeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bread bread = (Bread) o;
        return codeid == bread.codeid && Double.compare(bread.price, price) == 0 && Objects.equals(name, bread.name) && Objects.equals(date, bread.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeid, name, price, date);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "codeid=" + codeid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date2string(date) +
                '}';
    }
    private String date2string(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}

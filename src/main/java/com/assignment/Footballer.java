package com.assignment;
import java.io.*;
import java.util.*;

public class Footballer implements Serializable{
    private int footballerId;
    private String name;
    private Club club;
    private Date doB;
    private int price;

    public Footballer(int footballerId, String name, Club club, Date doB, int price) {
        this.footballerId = footballerId;
        this.name = name;
        this.club = club;
        this.doB = doB;
        this.price = price;
    }

    public int getFootballerId() {
        return footballerId;
    }

    public void setFootballerId(int footballerId) {
        this.footballerId = footballerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getCountry() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Footballer [footballerId =" + footballerId + ", name = " + name + ", club = " + club + ", doB="
                + doB + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, footballerId, doB, club, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Footballer other = (Footballer) obj;
        return price == other.price
                && doB == other.doB
                && footballerId == other.footballerId && Objects.equals(doB, other.doB)
                && Objects.equals(club, other.club) && Objects.equals(name, other.name);
    }
}

package com.assignment;

import java.util.*;

public class FootballManagerModel {
    private ArrayList<Footballer> footballers;
    private String name;

    public FootballManagerModel() {
        this.footballers = new ArrayList<Footballer>();
        this.name="";
    }

    public FootballManagerModel(ArrayList<Footballer> footballers) {
        this.footballers = footballers;
    }

    public ArrayList<Footballer> getFootballers() {
        return footballers;
    }

    public void setFootballers(ArrayList<Footballer> footballers) {
        this.footballers = footballers;
    }

    public void insert(Footballer footballer) {
        if (footballer.getDoB() != null) {
            this.footballers.add(footballer);
        }
    }

    public void delete(Footballer footballer) {
        ArrayList<Footballer> tempFootballers = new ArrayList<Footballer>();
        for(Footballer footballer_1: this.footballers) {
            if(footballer_1.getFootballerId() == footballer.getFootballerId())
                tempFootballers.add(footballer_1);
        }
        for (Footballer footballer_1: tempFootballers) {
            this.footballers.remove(footballer_1);
        }
    }

    public void update(Footballer footballer) {
        if (footballer.getDoB() == null) {
            return;
        }
        ArrayList<Footballer> tempFootballers = new ArrayList<Footballer>();
        for(Footballer footballer_1: this.footballers) {
            if(footballer_1.getFootballerId() == footballer.getFootballerId())
                tempFootballers.add(footballer_1);
        }
        for (Footballer footballer_1: tempFootballers) {
            this.footballers.remove(footballer_1);
        }
        this.footballers.add(footballer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkExist(Footballer footballer) {
        for(Footballer footballer_1: footballers) {
            if(footballer_1.getFootballerId() == footballer.getFootballerId())
                return true;
        }
        return false;
    }


}
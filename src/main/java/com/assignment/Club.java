package com.assignment;

import java.io.*;
import java.util.*;

public class Club implements Serializable{
    private int clubId;
    private String name;

    public Club(int clubId, String name) {
        this.name = name;
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Club [clubId =" + clubId + ", name =" + name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Club other = (Club) obj;
        return clubId == other.clubId && Objects.equals(name, other.name);
    }
    public static ArrayList<Club> getClubList(){
        String[] arr_club = {"Arsenal",
                "Aston Villa",
                "Bournemouth",
                "Brentford",
                "Brighton & Hove Albion",
                "Chelsea",
                "Crystal Palace",
                "Everton",
                "Fulham",
                "Leeds United",
                "Leicester City",
                "Liverpool",
                "Manchester City",
                "Manchester United",
                "Newcastle United",
                "Nottingham Forest",
                "Southampton",
                "Tottenham Hotspur",
                "West Ham United",
                "Wolverhampton Wanderers",
        };


        ArrayList<Club> listClub = new ArrayList<Club>();
        int i = 0;
        for (String name : arr_club) {
            Club club = new Club(i, name);
            listClub.add(club);
            i++;
        }
        return listClub;
    }

    public static Club getClubById(int clubId) {
        return Club.getClubList().get(clubId);
    }

    public static Club getClubByName(String name) {
        ArrayList<Club> listClub = Club.getClubList();
        for (Club club : listClub) {
            if(club.name.equals(name))
                return club;
        }
        return null;
    }
}

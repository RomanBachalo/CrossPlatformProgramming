package com.company;

import java.util.Objects;

public class FootballClub {
    private String name;
    private String city;
    private int foundationDate;

    FootballClub(){}
    FootballClub(String _name, String _city, int _date){
        name = _name;
        city = _city;
        foundationDate = _date;
    }
    FootballClub(FootballClub club){
        this.name = club.name;
        this.city = club.city;
        this.foundationDate = club.foundationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(int foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClub that = (FootballClub) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

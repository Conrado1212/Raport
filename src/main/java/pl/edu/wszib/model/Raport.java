package pl.edu.wszib.model;

import java.util.Calendar;

public class Raport {
    private String login;
    private String pointOfSales;
    private Calendar whenWasLogged;

    public Raport(String login, String pointOfSales, Calendar whenWasLogged) {
        this.login = login;
        this.pointOfSales = pointOfSales;
        this.whenWasLogged = whenWasLogged;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPointOfSales() {
        return pointOfSales;
    }

    public void setPointOfSales(String pointOfSales) {
        this.pointOfSales = pointOfSales;
    }

    public Calendar getWhenWasLogged() {
        return whenWasLogged;
    }

    public void setWhenWasLogged(Calendar whenWasLogged) {
        this.whenWasLogged = whenWasLogged;
    }

    @Override
    public String toString() {
        return "Raport{" +
                "login='" + login + '\'' +
                ", pointOfSales='" + pointOfSales + '\'' +
                ", whenWasLogged='" + whenWasLogged + '\'' +
                '}';
    }
}

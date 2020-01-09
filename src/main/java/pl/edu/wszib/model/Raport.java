package pl.edu.wszib.model;

public class Raport {
    private String login;
    private String pointOfSales;
    private String whenWasLogged;

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

    public String getWhenWasLogged() {
        return whenWasLogged;
    }

    public void setWhenWasLogged(String whenWasLogged) {
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

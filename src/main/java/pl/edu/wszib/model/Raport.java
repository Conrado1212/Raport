package pl.edu.wszib.model;

public class Raport {
    private String login;
    private String pointOfSales;
    private String whenWasLogged;

    public Raport(String login, String pointOfSales, String whenWasLogged) {
        this.login = login;
        this.pointOfSales = pointOfSales;
        this.whenWasLogged = whenWasLogged;
    }

    public Raport() {

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

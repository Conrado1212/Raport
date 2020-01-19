package pl.edu.wszib.services;

import pl.edu.wszib.model.Raport;

public interface IRaportService {
    Raport getRaportByLogin(String login);

    Raport getRaportByPointOfSales(String pointOfSales);

    Raport getRaportByWhenWasLogged(String whenWasLogged);
}

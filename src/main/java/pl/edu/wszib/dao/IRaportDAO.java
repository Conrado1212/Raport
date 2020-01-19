package pl.edu.wszib.dao;

import pl.edu.wszib.model.Raport;

import java.util.List;

public interface IRaportDAO {
    List<Raport> getAllRaport();

    void saveRaport(Raport raport);

    Raport getRaportByLogin(String login);

    Raport getRaportByPointOfSales(String pointOfSales);

    Raport getRaportByWhenWasLogged(String whenWasLogged);

    List<Raport> getAllRaports();
}
